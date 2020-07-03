package com.ideaas.services.dao.certificado;

import com.ideaas.services.domain.Colaborador;
import com.ideaas.services.domain.Rol;
import com.ideaas.services.domain.certificado.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoDao extends JpaRepository<Certificado, Long> {
    @Query("SELECT c FROM Certificado c WHERE c.colaborador.name LIKE %?1%"
            + "OR c.colaborador.lastName LIKE %?1%"
            + "OR c.colaborador.sucursal.name LIKE %?1%"
            + "OR c.fechaDeCarga LIKE %?1%"
    )
    List<Certificado> findCertificadoByColaborador(String value);
}
