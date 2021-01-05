package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.User;
import com.ideaas.services.domain.certificado.Certificado;
import com.ideaas.services.domain.certificado.Imagen;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface CertificadoService {

    List<Certificado> findAll();

    Certificado save(Certificado certificado);

    Certificado getById(Long id);

    void deleteById(Long id);

    List<Certificado> findAll(Integer pageSize, Integer pageNo, String sortBy);

    void saveImage(MultipartFile imageFile) throws Exception;

    void addImagenes(List<Certificado> certificados);

    void armarUrlDeImagen(Certificado certificado, List<Imagen> imagenesDelCertificado);

    List<Imagen> leerImagenesDe(Certificado certificado) throws  Exception;

    void agregarImagenesALosCertificados(List<Certificado> certificados);

    List<Certificado> findCertificadoByColaborador(String value);

    Integer findByAusentismoEnero();

    Integer findByAusentismoFebrero();

    Integer findByAusentismoMarzo();

    Integer findByAusentismoAbril();

    Integer findByAusentismoMayo();

    Integer findByAusentismoJunio();

    Integer findByAusentismoJulio();

    Integer findByAusentismoAgosto();

    Integer findByAusentismoSeptiembre();

    Integer findByAusentismoOctubre();

    Integer findByAusentismoNoviembre();

    Integer findByAusentismoDiciembre();

    Integer findByAusentismoFechaActual();

    Integer findByAusentismoAnioActual();

    Map<String, Integer> getCantidadDeCertificadosPorMes();

    List<Certificado> buscarEstadisticasPorFecha(LocalDate fechaInicio, LocalDate fechaFin);

    List<Certificado> obtenerAusenciasMesActual();

    List<Certificado> obtenerAusenciasAnoActual();
}
