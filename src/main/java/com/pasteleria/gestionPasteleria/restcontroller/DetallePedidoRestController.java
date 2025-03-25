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
import com.pasteleria.gestionPasteleria.entity.DetallePedidoEntity;
import com.pasteleria.gestionPasteleria.service.DetallePedidoService;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoRestController {
     @Autowired
    private DetallePedidoService servicio;

    @GetMapping
    public List<DetallePedidoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/{id}")
    public DetallePedidoEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public DetallePedidoEntity add(@RequestBody DetallePedidoEntity d) {
        return servicio.add(d);
    }

    @PutMapping("/{id}")
    public DetallePedidoEntity update(@PathVariable long id, @RequestBody DetallePedidoEntity d) {
        d.setCodigo(id);
        return servicio.update(d);
    }

}
