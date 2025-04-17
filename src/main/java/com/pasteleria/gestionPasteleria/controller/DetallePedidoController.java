package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.DetallePedidoEntity;
import com.pasteleria.gestionPasteleria.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService servicio;

    @GetMapping("/listardetallepedido")
    public String MostrarDetallePedido(Model modelo) {
        modelo.addAttribute("detalle_pedidos", servicio.findAll());
        return "detalle_pedido/listar";
    }

    @GetMapping("/registrodetallepedido")
    public String MostrarRegistroDetallePedido() {
        return "detalle_pedido/crear";
    }

    @GetMapping("/actualizadetallepedido/{id}")
    public String MostrarActualizaDetallePedido(@PathVariable Long id,
                                                Model modelo) {
        modelo.addAttribute("detalle_pedidos", servicio.findById(id));
        return "detalle_pedido/editar";
    }

    @ModelAttribute("detalle_pedido")
    public DetallePedidoEntity ModeloDetallePedido() {
        return new DetallePedidoEntity();
    }

    @PostMapping("/registrardetallepedido")
    public String RegistrarDetallePedido(@ModelAttribute("detalle_pedido") DetallePedidoEntity c) {
        servicio.add(c);
        return "redirect:/listardetallepedido";
    }

    @PostMapping("actualizardetallepedido/{id}")
    public String ActualizarDetallePedido(@PathVariable Long id,
                                          @ModelAttribute("detalle_pedido") DetallePedidoEntity c) {
        servicio.update(c);
        return "redirect:/listardetallepedido";
    }
}
