package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CertificadoService {

    List<Certificado> findAll();

    Certificado save(Certificado certificado);

    Certificado get(Long id);

    List<Certificado> findAll(Integer pageSize, Integer pageNo, String sortBy);

    void saveImage(MultipartFile imageFile) throws Exception;

    void addImagenes(List<Certificado> certificados);

    void armarUrlDeImagen(Certificado certificado, List<Imagen> imagenesDelCertificado);

    List<Imagen> leerImagenesDe(Certificado certificado) throws  Exception;

    void agregarImagenesALosCertificados(List<Certificado> certificados);

    List<Certificado> findCertificadoByColaborador(String value);
}
