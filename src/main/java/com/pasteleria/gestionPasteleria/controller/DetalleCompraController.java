package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;
import com.pasteleria.gestionPasteleria.entity.DetalleCompraEntity;
import com.pasteleria.gestionPasteleria.service.CategoriaService;
import com.pasteleria.gestionPasteleria.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetalleCompraController {
    @Autowired
    private DetalleCompraService servicio;

    @GetMapping("/listardetallecompra")
    public String MostrarDetalleCompra(Model modelo) {
        modelo.addAttribute("detalle_compras", servicio.findAll());
        return "detalle_compra/listar";
    }

    @GetMapping("/registrodetallecompra")
    public String MostrarRegistroDetalleCompra() {
        return "detalle_compra/crear";
    }

    @GetMapping("/actualizadetallecompra/{id}")
    public String MostrarActualizaDetalleCompra(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("detalle_compras", servicio.findById(id));
        return "detalle_compra/editar";
    }

    @ModelAttribute("detalle_compra")
    public DetalleCompraEntity ModeloDetalleCompra() {
        return new DetalleCompraEntity();
    }

    @PostMapping("/registrardetallecompra")
    public String RegistrarDetalleCompra(@ModelAttribute("detalle_compra") DetalleCompraEntity c) {
        servicio.add(c);
        return "redirect:/listardetallecompra";
    }

    @PostMapping("actualizardetallecompra/{id}")
    public String ActualizarDetalleCompra(@PathVariable Long id,
                                      @ModelAttribute("detalle_compra") DetalleCompraEntity c) {
        servicio.update(c);
        return "redirect:/listardetallecompra";
    }
}
