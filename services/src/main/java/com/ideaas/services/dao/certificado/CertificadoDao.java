package com.ideaas.services.dao.certificado;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.certificado.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CertificadoDao extends JpaRepository<Certificado, Long> {
    @Query("SELECT c FROM Certificado c WHERE c.colaborador.name LIKE %?1%"
            + "OR c.colaborador.sucursal.name LIKE %?1%"
    )
    List<Certificado> findCertificadoByColaborador(String value);

    List<Certificado> findByColaborador(Colaborador colaborador);
    List<Certificado> findAllByFechaInicioLessThanEqualAndFechaFinalizacionGreaterThanEqual(LocalDate fechaInicio, LocalDate fechaFin);

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=1 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoEnero();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=2 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoFebrero();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=3 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoMarzo();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=4 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoAbril();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=5 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoMayo();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=6 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoJunio();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=7 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoJulio();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=8 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoAgosto();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=9 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoSeptiembre();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=10 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoOctubre();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=11 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoNoviembre();

    @Query( value = "SELECT SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO)=12 AND YEAR(CER_FECHA_INICIO) = YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoDiciembre();

    @Query( value = "SELECT SUM(CER_AUSENTISMO) FROM CERTIFICADOS WHERE MONTH(CER_FECHA_INICIO) = MONTH(CURRENT_DATE()); ", nativeQuery = true)
    Integer findByAusentismoFechaActual();

    @Query( value = "SELECT  SUM( CER_AUSENTISMO) AS CANTIDAD_AUSENCIA FROM CERTIFICADOS WHERE YEAR(CER_FECHA_INICIO)=YEAR(CURDATE());", nativeQuery = true)
    Integer findByAusentismoAnioActual();

//    @Query( value = "SELECT COL_NAME,SUM(CERTIFICADOS.CER_AUSENTISMO) AS AUSENCIAS FROM CERTIFICADOS JOIN COLABORADORES ON CERTIFICADOS.CER_COL_ID = COLABORADORES.COL_ID JOIN SUCURSALES ON COLABORADORES.COL_SUC_ID = SUCURSALES.SUC_ID WHERE YEAR(CER_FECHA_INICIO)=YEAR(CURDATE()) GROUP BY COL_ID;", nativeQuery = true)
//    List<Certificado>findByAusentismoColaborador(LocalDate fechaInicio, LocalDate fechaFin);

    @Query( value = "SELECT SUM(CERTIFICADOS.CER_AUSENTISMO) AS AUSENCIAS FROM CERTIFICADOS JOIN COLABORADORES ON CERTIFICADOS.CER_COL_ID = COLABORADORES.COL_ID JOIN SUCURSALES ON COLABORADORES.COL_SUC_ID = SUCURSALES.SUC_ID WHERE MONTH(CER_FECHA_INICIO) AND YEAR (CER_FECHA_INICIO) = YEAR(CURDATE()) GROUP BY COL_ID;", nativeQuery = true)
    Integer findByAusentismoColaboradorPorAnio();




}
