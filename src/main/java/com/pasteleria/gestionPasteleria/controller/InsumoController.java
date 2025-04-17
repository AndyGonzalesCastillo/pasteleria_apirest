package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.InsumoEntity;
import com.pasteleria.gestionPasteleria.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InsumoController {
    @Autowired
    private InsumoService servicio;

    @GetMapping("/listarinsumo")
    public String MostrarInsumo(Model modelo) {
        modelo.addAttribute("insumos", servicio.findAllCustom());
        return "insumo/listar";
    }

    @GetMapping("/registroinsumo")
    public String MostrarRegistroInsumo() {
        return "insumo/crear";
    }

    @GetMapping("/actualizainsumo/{id}")
    public String MostrarActualizaInsumo(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("insumos", servicio.findById(id));
        return "insumo/editar";
    }

    @GetMapping("/eliminarinsumo/{id}")
    public String EliminarInsumo(@PathVariable Long id,
                                    Model modelo) {
        InsumoEntity objinsumo = new InsumoEntity();
        objinsumo.setCodigo(id);
        servicio.delete(objinsumo);
        return "redirect:/listarinsumo";
    }

    @ModelAttribute("insumo")
    public InsumoEntity ModeloInsumo() {
        return new InsumoEntity();
    }

    @PostMapping("/registrarinsumo")
    public String RegistrarInsumo(@ModelAttribute("insumo") InsumoEntity c) {
        servicio.add(c);
        return "redirect:/listarinsumo";
    }

    @PostMapping("actualizarinsumo/{id}")
    public String ActualizarInsumo(@PathVariable Long id,
                                      @ModelAttribute("insumo") InsumoEntity c) {
        servicio.update(c);
        return "redirect:/listarinsumo";
    }
}
