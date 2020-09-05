package com.ideaas.services.service.interfaces;

import com.ideaas.services.domain.Sucursal;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by Benja on 22/3/2020.
 */
public interface SucursalService {

    List<Sucursal> findAllPageable(Integer pageSize, Integer pageNo, String sortBy);
    List<Sucursal> findAll();
    Sucursal get(Long id);
    Sucursal save(Sucursal sucursal);

}

