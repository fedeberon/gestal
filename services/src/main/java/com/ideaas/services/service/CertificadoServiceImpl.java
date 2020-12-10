package com.ideaas.services.service;

import com.ideaas.services.dao.certificado.CertificadoDao;
import com.ideaas.services.dao.certificado.CertificadoDaoPagination;
import com.ideaas.services.dao.colaborador.ColaboradorDao;
import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.Imagen;
import com.ideaas.services.service.interfaces.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;
@Service
public class CertificadoServiceImpl implements CertificadoService {

    private CertificadoDao dao;
    private CertificadoDaoPagination daoPagination;
    private FileServiceImpl fileService;
    private ColaboradorDao colaboradorDao;

    @Value("${file.upload-dir}")
    private String filePathCertificados;

    @Value("${file.upload-dir}")
    private String folder;

    @Value("${file.upload-dir}")
    private String pathImagenesContext;

    @Autowired
    public CertificadoServiceImpl(CertificadoDao dao, CertificadoDaoPagination daoPagination, FileServiceImpl fileService, ColaboradorDao colaboradorDao) {
        this.dao = dao;
        this.daoPagination = daoPagination;
        this.fileService = fileService;
        this.colaboradorDao = colaboradorDao;
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
    public Certificado getById(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public void deleteById(Long id){
        dao.deleteById(id);
    }

    @Override
    public List<Certificado> findAll(Integer pageSize, Integer pageNo, String id) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(id).descending());
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

    @Override
    public Integer findByAusentismoEnero() {
        return dao.findByAusentismoEnero();
    }

    @Override
    public Integer findByAusentismoFebrero() {
        return dao.findByAusentismoFebrero();
    }

    @Override
    public Integer findByAusentismoMarzo() {
        return dao.findByAusentismoMarzo();
    }

    @Override
    public Integer findByAusentismoAbril() {
        return dao.findByAusentismoAbril();
    }

    @Override
    public Integer findByAusentismoMayo() {
        return dao.findByAusentismoMayo();
    }

    @Override
    public Integer findByAusentismoJunio() {
        return dao.findByAusentismoJunio();
    }

    @Override
    public Integer findByAusentismoJulio() {
        return dao.findByAusentismoJulio();
    }

    @Override
    public Integer findByAusentismoAgosto() {
        return dao.findByAusentismoAgosto();
    }

    @Override
    public Integer findByAusentismoSeptiembre() {
        return dao.findByAusentismoSeptiembre();
    }

    @Override
    public Integer findByAusentismoOctubre() {
        return dao.findByAusentismoOctubre();
    }

    @Override
    public Integer findByAusentismoNoviembre() {
        return dao.findByAusentismoNoviembre();
    }

    @Override
    public Integer findByAusentismoDiciembre() {
        return dao.findByAusentismoDiciembre();
    }

    @Override
    public Integer findByAusentismoFechaActual() {
        return dao.findByAusentismoFechaActual();
    }

    @Override
    public Integer findByAusentismoAnioActual() {
        return dao.findByAusentismoAnioActual();
    }

    @Override
    public Map<String, Integer> getCantidadDeCertificadosPorMes(){
        List<Certificado> certificados = dao.findAll();
        Map map = new HashMap<String, Long>();
        certificados.forEach(unCertificado -> asigarCantidadDeDiasAlMes(map, unCertificado));

        return map;
    }


    private void asigarCantidadDeDiasAlMes(Map<String, Long> map, Certificado certificado){
        LocalDate inicio = certificado.getFechaInicio();
        String key = inicio.getMonth().getDisplayName(TextStyle.FULL, Locale.US) + "-" + inicio.getYear();
        if (certificado.getColaborador().getId() == 0){
            System.out.println("En noviembre");
        }
        LocalDate fin = certificado.getFechaFinalizacion();
        Month mesInicio = inicio.getMonth();
        Month mesFin = fin.getMonth();
        long dias = 0;

        if(esUnCertificadoDelMismoMes(mesInicio, mesFin)){
            dias = DAYS.between(inicio, fin);
        }

        else {
            /**
             * Cuenta los dias del primer mes
             */
            dias = DAYS.between(inicio, inicio.withDayOfMonth(inicio.lengthOfMonth()));

            /**
             * Cuentas los dias de los meses intermedios
             */
            LocalDate next = inicio;
            do {
                next = next.plusMonths(1);

                if (next.getMonth().equals(fin.getMonth())){
                    break;
                }

                key = next.getMonth().name() + "-" + next.getYear();
                YearMonth yearMonthObject = YearMonth.of(next.getYear() , next.getMonth().getValue());
                dias += yearMonthObject.lengthOfMonth();
            }
            while (!esUnCertificadoDelMismoMes(fin.getMonth(), next.getMonth()));


            /**
             * Cuenta los dias del ultimo mes
             */
            dias += DAYS.between(fin.withDayOfMonth(1), certificado.getFechaFinalizacion());

        }
        agregarDiasAlMes(map, key, dias);
    }

    public LocalDate add(LocalDate date, int workdays) {
        if (workdays < 1) {
            return date;
        }

        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }

        return result;
    }

    private boolean esUnCertificadoDelMismoMes(Month mesInicio, Month mesFin) {
        return mesInicio.equals(mesFin);
    }

    private void agregarDiasAlMes(Map<String, Long> map, String key, long dias) {
        if (map.containsKey(key)) {
            Long previusValue = map.get(key);
            Long total = previusValue + dias + 1;
            map.put(key, total);
        } else {
            map.put(key, dias + 1);
        }
    }

    @Override
    public List<Certificado> buscarEstadisticasPorFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return dao.findAllByFechaInicioLessThanEqualAndFechaFinalizacionGreaterThanEqual(fechaInicio, fechaFin);
    }
}
