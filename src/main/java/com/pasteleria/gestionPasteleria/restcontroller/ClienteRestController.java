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
import com.pasteleria.gestionPasteleria.entity.ClienteEntity;
import com.pasteleria.gestionPasteleria.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
    @Autowired
    private ClienteService servicio;

    @GetMapping
    public List<ClienteEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<ClienteEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public ClienteEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public ClienteEntity add(@RequestBody ClienteEntity c) {
        return servicio.add(c);
    }

    @PutMapping("/{id}")
    public ClienteEntity update(@PathVariable long id, @RequestBody ClienteEntity c) {
        c.setCodigo(id);
        return servicio.update(c);
    }

    @DeleteMapping("/{id}")
    public ClienteEntity delete(@PathVariable long id) {
        ClienteEntity objCliente = new ClienteEntity();
        objCliente.setEstado(false);
        return servicio.delete(ClienteEntity.builder().codigo(id).build());
    }
}
