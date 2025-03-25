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
import com.pasteleria.gestionPasteleria.entity.EmpleadoEntity;
import com.pasteleria.gestionPasteleria.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoRestController {
    @Autowired
    private EmpleadoService servicio;

    @GetMapping
    public List<EmpleadoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/{id}")
    public EmpleadoEntity findById(@PathVariable long id) {
        return servicio.findById(id);
    }

    @PostMapping
    public EmpleadoEntity add(@RequestBody EmpleadoEntity e) {
        return servicio.add(e);
    }

    @PutMapping("/{id}")
    public EmpleadoEntity update(@PathVariable long id, @RequestBody EmpleadoEntity e) {
        e.setCodigo(id);
        return servicio.update(e);
    }

    @DeleteMapping("/{id}")
    public EmpleadoEntity delete(@PathVariable long id) {
        EmpleadoEntity objEmpleado = new EmpleadoEntity();
        objEmpleado.setEstado(false);
        return servicio.delete(EmpleadoEntity.builder().codigo(id).build());
    }
}
