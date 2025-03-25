package com.pasteleria.gestionPasteleria.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;
import com.pasteleria.gestionPasteleria.repository.CategoriaRepository;
import com.pasteleria.gestionPasteleria.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository repositorio;

    @Override
    public List<CategoriaEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public CategoriaEntity findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return repositorio.save(c);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objCategoria = new CategoriaEntity();
        BeanUtils.copyProperties(c, objCategoria);
        return repositorio.save(objCategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
        CategoriaEntity objCategoria = repositorio.findById(c.getCodigo()).get();
        objCategoria.setEstado(false);
        return repositorio.save(objCategoria);

    }
}
