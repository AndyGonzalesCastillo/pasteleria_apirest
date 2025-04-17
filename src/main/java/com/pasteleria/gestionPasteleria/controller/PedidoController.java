package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.PedidoEntity;
import com.pasteleria.gestionPasteleria.entity.ProductoEntity;
import com.pasteleria.gestionPasteleria.service.ClienteService;
import com.pasteleria.gestionPasteleria.service.EmpleadoService;
import com.pasteleria.gestionPasteleria.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PedidoController {
    @Autowired
    private PedidoService servicio;

    @Autowired
    private EmpleadoService servicioempleado;

    @Autowired
    private ClienteService serviciocliente;

    @GetMapping("/listarpedido")
    public String MostrarPedido(Model modelo) {
        modelo.addAttribute("pedidos", servicio.findAllCustom());
        return "pedido/listar";
    }

    @GetMapping("/registropedido")
    public String MostrarRegistrarPedido(Model modelo) {
        modelo.addAttribute("empleados",
                servicioempleado.findAllCustom());
        modelo.addAttribute("clientes",
                serviciocliente.findAllCustom());
        return "pedido/crear";
    }

    @GetMapping("/actualizapedido/{id}")
    public String MostrarActualizaPedido(@PathVariable Long id,
                                           Model modelo) {
        modelo.addAttribute("empleados",
                servicioempleado.findAllCustom());
        modelo.addAttribute("clientes",
                serviciocliente.findAllCustom());
        modelo.addAttribute("pedidos", servicio.findById(id));
        return "pedido/editar";
    }

    @GetMapping("/eliminarpedido/{id}")
    public String EliminarPedido(@PathVariable Long id,
                                   Model modelo) {
        PedidoEntity objpedido = new PedidoEntity();
        objpedido.setCodigo(id);
        servicio.delete(objpedido);
        return "redirect:/listarpedido";
    }

    @ModelAttribute("pedido")
    public PedidoEntity ModeloPedido() {
        return new PedidoEntity();
    }

    @PostMapping("/registrarpedido")
    public String RegistrarPedido(@ModelAttribute("pedido") PedidoEntity p) {
        servicio.add(p);
        return "redirect:/listarpedido";
    }

    @PostMapping("/actualizarpedido/{id}")
    public String ActualizarPedido(@PathVariable Long id,
                                     @ModelAttribute("pedido") PedidoEntity p) {
        servicio.update(p);
        return "redirect:/listarpedido";
    }




}
