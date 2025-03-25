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
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;
import com.pasteleria.gestionPasteleria.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {
   @Autowired
    private ProductoService servicio;

    @GetMapping
    public List<ProductoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ProductoEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity p) {
        return servicio.add(p);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable long id, @RequestBody ProductoEntity p) {
        p.setCodigo(id);
        return servicio.update(p);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable long id) {
        ProductoEntity objPedido = new ProductoEntity();
        objPedido.setEstado(false);
        return servicio.delete(ProductoEntity.builder().codigo(id).build());
    }
}