package com.ideaas.services.service;

import com.ideaas.services.dao.certificado.CertificadoDao;
import com.ideaas.services.dao.certificado.CertificadoDaoPagination;
import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.Imagen;
import com.ideaas.services.service.interfaces.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CertificadoServiceImpl implements CertificadoService {

    private CertificadoDao dao;
    private CertificadoDaoPagination daoPagination;
    private FileServiceImpl fileService;

    @Value("${file.upload-dir}")
    private String filePathCertificados;

    @Value("${file.upload-dir}")
    private String folder;

    @Value("${file.upload-dir}")
    private String pathImagenesContext;

    @Autowired
    public CertificadoServiceImpl(CertificadoDao dao, CertificadoDaoPagination daoPagination, FileServiceImpl fileService) {
        this.dao = dao;
        this.daoPagination = daoPagination;
        this.fileService = fileService;
    }

    @Override
    public List<Certificado> findAll(){
        return dao.findAll();
    }

    @Override
    public Certificado save(Certificado certificado){

        //Al ingresar un dia de ausentismo se setea a la fecha de finalizacion el mismo dia que la fecha de comienzo porque la ausencia sera el mismo dia.
        switch (certificado.getAusentismo()){
            case 1:
                certificado.setFechaFinalizacion(certificado.getFechaInicio());
                break;
            default:
                certificado.setFechaFinalizacion(certificado.getFechaInicio().plusDays(certificado.getAusentismo()));
                break;
        }
        return dao.save(certificado);
    }

    @Override
    public Certificado get(Long id) {
        Certificado certificado = dao.findById(id).get();
        return dao.findById(id).get();
    }

    @Override
    public List<Certificado> findAll(Integer pageSize, Integer pageNo, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Certificado> certificados = daoPagination.findAll(paging);

        return certificados.getContent();
    }





    @Override
    public void saveImage(MultipartFile imageFile) throws Exception {
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);

    }


    @Override
    public void addImagenes(List<Certificado> certificados) {
        for (Certificado certificado: certificados){
            try {
                List<Imagen> imagenesDelCertificado= this.leerImagenesDe(certificado);
                this.armarUrlDeImagen(certificado, imagenesDelCertificado);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void armarUrlDeImagen(Certificado certificado, List<Imagen> imagenesDelCertificado) {
        for(Imagen imagen : imagenesDelCertificado){
            final String url = imagen.getUrl();
            imagen.setUrl(pathImagenesContext + "//CERTIFICADOS//" + certificado.getColaborador().getId() + "//" + url);
            certificado.imagenes.add(imagen);
        }
    }

    @Override
    public List<Imagen> leerImagenesDe(Certificado certificado) throws  Exception{
        final List<Imagen> imagenes = new ArrayList<>();
        fileService.crearDirectorioParaImagenesDe(certificado.getColaborador().getId().toString());
        String path = filePathCertificados + certificado.getColaborador().getId().toString();
        certificado.imagenes = fileService.readFiles(path);

        return imagenes;
    }

    @Override
    public void agregarImagenesALosCertificados(List<Certificado> certificados) {
        this.addImagenes(certificados);
    }

    @Override
    public List<Certificado> findCertificadoByColaborador(String value) {
        return dao.findCertificadoByColaborador(value);
    }

}
