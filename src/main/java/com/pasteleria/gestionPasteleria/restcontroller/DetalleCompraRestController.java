package com.pasteleria.gestionPasteleria.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pasteleria.gestionPasteleria.entity.DetalleCompraEntity;
import com.pasteleria.gestionPasteleria.service.DetalleCompraService;

@RestController
@RequestMapping("/detallecompra")
public class DetalleCompraRestController {
     @Autowired
    private DetalleCompraService servicio;

    @GetMapping
    public List<DetalleCompraEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public DetalleCompraEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public DetalleCompraEntity add(@RequestBody DetalleCompraEntity d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public DetalleCompraEntity update(@PathVariable long id, @RequestBody DetalleCompraEntity d) {
        d.setCodigo(id);
        return servicio.update(d);
    }

}
