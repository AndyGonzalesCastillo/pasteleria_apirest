package com.pasteleria.gestionPasteleria.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pasteleria.gestionPasteleria.entity.ProveedorEntity;
import com.pasteleria.gestionPasteleria.service.ProveedorService;

@RestController
@RequestMapping("/proveedor")
public class ProveedorRestController {
   @Autowired
    private ProveedorService servicio;

    @GetMapping
    public List<ProveedorEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ProveedorEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ProveedorEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ProveedorEntity add(@RequestBody ProveedorEntity p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public ProveedorEntity update(@PathVariable long id, @RequestBody ProveedorEntity p) {
        p.setCodigo(id);
        return servicio.update(p);
    }

    @DeleteMapping("/{id}")
    public ProveedorEntity delete(@PathVariable long id) {
        ProveedorEntity objProveedor = new ProveedorEntity();
        objProveedor.setEstado(false);
        return servicio.delete(ProveedorEntity.builder().codigo(id).build());
    }
}