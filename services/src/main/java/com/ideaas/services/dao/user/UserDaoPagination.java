package com.ideaas.services.dao.user;

import com.ideaas.services.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Enzo on 21/2/2020.
 */
public interface UserDaoPagination extends PagingAndSortingRepository<User, Long> {
}
