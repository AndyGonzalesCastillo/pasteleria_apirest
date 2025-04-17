package com.pasteleria.gestionPasteleria.controller;

import ch.qos.logback.core.net.server.Client;
import com.pasteleria.gestionPasteleria.entity.ClienteEntity;
import com.pasteleria.gestionPasteleria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService servicio;

    @GetMapping("/listarcliente")
    public String MostrarCliente(Model modelo) {
        modelo.addAttribute("clientes", servicio.findAllCustom());
        return "cliente/listar";
    }

    @GetMapping("/registrocliente")
    public String MostrarRegistroCliente() {
        return "cliente/crear";
    }

    @GetMapping("/actualizacliente/{id}")
    public String MostrarActualizaCliente(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("clientes", servicio.findById(id));
        return "cliente/editar";
    }

    @GetMapping("/eliminarcliente/{id}")
    public String EliminarCliente(@PathVariable Long id,
                                    Model modelo) {
        ClienteEntity objcliente = new ClienteEntity();
        objcliente.setCodigo(id);
        servicio.delete(objcliente);
        return "redirect:/listarcliente";
    }

    @ModelAttribute("cliente")
    public ClienteEntity ModeloCliente() {
        return new ClienteEntity();
    }

    @PostMapping("/registrarcliente")
    public String RegistrarCliente(@ModelAttribute("cliente") ClienteEntity c) {
        servicio.add(c);
        return "redirect:/listarcliente";
    }

    @PostMapping("actualizarcliente/{id}")
    public String ActualizarCliente(@PathVariable Long id,
                                      @ModelAttribute("cliente") ClienteEntity c) {
        servicio.update(c);
        return "redirect:/listarcliente";
    }
}
