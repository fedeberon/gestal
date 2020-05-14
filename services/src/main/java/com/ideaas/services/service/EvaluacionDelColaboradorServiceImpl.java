package com.ideaas.services.service;

import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorDao;
import com.ideaas.services.dao.evaluacionDelColaborador.EvaluacionDelColaboradorPaginationDao;
import com.ideaas.services.domain.EvaluacionDelColaborador;
import com.ideaas.services.service.interfaces.EvaluacionDelColaboradorService;
import com.ideaas.services.service.interfaces.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Enzo on 17/2/2020.
 */

@Service
public class EvaluacionDelColaboradorServiceImpl implements EvaluacionDelColaboradorService{

    private EvaluacionDelColaboradorDao dao;
    private EvaluacionDelColaboradorPaginationDao daoPageable;
    public static Long rating;

    @Autowired
    public EvaluacionDelColaboradorServiceImpl(EvaluacionDelColaboradorDao dao, EvaluacionDelColaboradorPaginationDao paginationDao) {
        this.dao = dao;
        this.daoPageable = paginationDao;
    }

    @Override
    public List<EvaluacionDelColaborador> findAllPageable(Integer pageSize, Integer pageNo, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EvaluacionDelColaborador> evaluacionDelColaborador = daoPageable.findAll(paging);

        return evaluacionDelColaborador.getContent();
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }

    @Override
    public List<EvaluacionDelColaborador> findAll(){
        return dao.findAll();
    }

    @Override
    public EvaluacionDelColaborador get(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public EvaluacionDelColaborador save(EvaluacionDelColaborador evaluacionDelColaborador) {
        evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> itemEvaluado.setEvaluacionDelColaborador(evaluacionDelColaborador));
        evaluacionDelColaborador.setFechaDeCarga(new Date());
        evaluacionDelColaborador.setResultado(this.calcularRatingPorConsideracion(evaluacionDelColaborador));
        return dao.save(evaluacionDelColaborador);
    }

    @Override
    public Float calcularRatingPorConsideracion(EvaluacionDelColaborador evaluacionDelColaborador){

        AtomicReference<Float> resultado = new AtomicReference<>(Float.valueOf(0));
            evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
                Long cantConsideracionesEnchecked = itemEvaluado.getConsideracionItemEvaluados().stream().mapToLong(consideracionItemEvaluado -> consideracionItemEvaluado.isCheckeado() ? 1 : 0).sum();

                itemEvaluado.setValorConsideracionItemEvaluados(cantConsideracionesEnchecked);
            });
        AtomicBoolean evaluacionInvalidada = new AtomicBoolean(false);
        evaluacionInvalidada.set(false);
        evaluacionDelColaborador.getItemEvaluados().forEach(itemEvaluado -> {
            //Si el checkbox que invalida la evaluacion o el rating del item es 0, el score de la evaluacion es 0
            if(itemEvaluado.getItem().isInvalidaEvaluacion() == true && itemEvaluado.getItem().getScore() == 0) {
                evaluacionInvalidada.set(true);
                evaluacionDelColaborador.setResultado(Float.valueOf(0));
            }else {
                Float resultadoPorItem = (Float.valueOf(itemEvaluado.getValorConsideracionItemEvaluados()) * Float.valueOf(itemEvaluado.getItem().getScore()));
                resultado.set(resultado.get() + resultadoPorItem);
            }
            });
        if (evaluacionInvalidada.get() == true){
            evaluacionDelColaborador.setResultado(Float.valueOf(0));

        }else {
            evaluacionDelColaborador.setResultado(resultado.get());
        }
        return resultado.get();
    }

    @Override
    public long cantidadEvaluacionesMes() {
        return dao.cantidadEvaluacionesMes();
    }

    @Override
    public long cantidadEvaluacionesEntreRango(){
        return dao.cantidadEvaluacionesEntreRango();
    }

    @Override
    public long cantidadEvaluacionesMayor(){
        return dao.cantidadEvaluacionesMayor();
    }

    @Override
    public long cantidadEvaluacionesEnCero(){
        return dao.cantidadEvaluacionesEnCero();
    }


}
