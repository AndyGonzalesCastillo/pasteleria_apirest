package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.EmpleadoEntity;
import com.pasteleria.gestionPasteleria.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService servicio;

    @GetMapping("/listarempleado")
    public String MostrarEmpleado(Model modelo) {
        modelo.addAttribute("empleados", servicio.findAllCustom());
        return "empleado/listar";
    }

    @GetMapping("/registroempleado")
    public String MostrarRegistroEmpleado() {
        return "empleado/crear";
    }

    @GetMapping("/actualizaempleado/{id}")
    public String MostrarActualizaEmpleado(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("empleados", servicio.findById(id));
        return "empleado/editar";
    }

    @GetMapping("/eliminarempleado/{id}")
    public String EliminarEmpleados(@PathVariable Long id,
                                    Model modelo) {
        EmpleadoEntity objempleado = new EmpleadoEntity();
        objempleado.setCodigo(id);
        servicio.delete(objempleado);
        return "redirect:/listarempleado";
    }

    @ModelAttribute("empleado")
    public EmpleadoEntity ModeloEmpleado() {
        return new EmpleadoEntity();
    }

    @PostMapping("/registrarempleado")
    public String RegistrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity c) {
        servicio.add(c);
        return "redirect:/listarempleado";
    }

    @PostMapping("actualizarempleado/{id}")
    public String ActualizarEmpleado(@PathVariable Long id,
                                      @ModelAttribute("empleado") EmpleadoEntity c) {
        servicio.update(c);
        return "redirect:/listarempleado";
    }
}
