package com.ideaas.services.dao.certificado;

import com.ideaas.services.domain.certificado.Certificado;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoDaoPagination extends PagingAndSortingRepository<Certificado, Long> {
}
