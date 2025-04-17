package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;
import com.pasteleria.gestionPasteleria.entity.ProveedorEntity;
import com.pasteleria.gestionPasteleria.service.CategoriaService;
import com.pasteleria.gestionPasteleria.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
    @Autowired
    private ProveedorService servicio;

    @GetMapping("/listarproveedor")
    public String MostrarProveedor(Model modelo) {
        modelo.addAttribute("proveedores", servicio.findAllCustom());
        return "proveedor/listar";
    }

    @GetMapping("/registroproveedor")
    public String MostrarRegistroProveedor() {
        return "proveedor/crear";
    }

    @GetMapping("/actualizaproveedor/{id}")
    public String MostrarActualizaProveedor(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("proveedores", servicio.findById(id));
        return "proveedor/editar";
    }

    @GetMapping("/eliminarproveedor/{id}")
    public String EliminarProveedor(@PathVariable Long id,
                                    Model modelo) {
        ProveedorEntity objproveedor = new ProveedorEntity();
        objproveedor.setCodigo(id);
        servicio.delete(objproveedor);
        return "redirect:/listarproveedor";
    }

    @ModelAttribute("proveedor")
    public ProveedorEntity ModeloProveedor() {
        return new ProveedorEntity();
    }

    @PostMapping("/registrarproveedor")
    public String RegistrarProveedor(@ModelAttribute("proveedor") ProveedorEntity c) {
        servicio.add(c);
        return "redirect:/listarproveedor";
    }

    @PostMapping("actualizarproveedor/{id}")
    public String ActualizarProveedor(@PathVariable Long id,
                                      @ModelAttribute("proveedor") ProveedorEntity c) {
        servicio.update(c);
        return "redirect:/listarproveedor";
    }
}
