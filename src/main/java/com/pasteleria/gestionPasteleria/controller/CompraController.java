package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.CompraEntity;
import com.pasteleria.gestionPasteleria.service.CompraService;
import com.pasteleria.gestionPasteleria.service.EmpleadoService;
import com.pasteleria.gestionPasteleria.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraController {
    @Autowired
    private CompraService servicio;

    @Autowired
    private EmpleadoService servicioempleado;

    @Autowired
    private ProveedorService servicioproveedor;

    @GetMapping("/listarcompra")
    public String MostrarCompra(Model modelo) {
        modelo.addAttribute("compras", servicio.findAllCustom());
        return "compra/listar";
    }

    @GetMapping("/registrocompra")
    public String MostrarRegistrarCompra(Model modelo) {
        modelo.addAttribute("empleados",
                servicioempleado.findAllCustom());
        modelo.addAttribute("proveedores",
                servicioproveedor.findAllCustom());
        return "compra/crear";
    }

    @GetMapping("/actualizacompra/{id}")
    public String MostrarActualizaCompra(@PathVariable Long id,
                                           Model modelo) {
        modelo.addAttribute("empleados",
                servicioempleado.findAllCustom());
        modelo.addAttribute("proveedores",
                servicioproveedor.findAllCustom());
        modelo.addAttribute("compras", servicio.findById(id));
        return "compra/editar";
    }

    @GetMapping("/eliminarcompra/{id}")
    public String EliminarCompra(@PathVariable Long id,
                                   Model modelo) {
        CompraEntity objcompra = new CompraEntity();
        objcompra.setCodigo(id);
        servicio.delete(objcompra);
        return "redirect:/listarcompra";
    }

    @ModelAttribute("compra")
    public CompraEntity ModeloProducto() {
        return new CompraEntity();
    }

    @PostMapping("/registrarcompra")
    public String RegistrarCompra(@ModelAttribute("compra") CompraEntity p) {
        servicio.add(p);
        return "redirect:/listarcompra";
    }

    @PostMapping("/actualizarcompra/{id}")
    public String ActualizarCompra(@PathVariable Long id,
                                     @ModelAttribute("compra") CompraEntity p) {
        servicio.update(p);
        return "redirect:/listarcompra";
    }
}
