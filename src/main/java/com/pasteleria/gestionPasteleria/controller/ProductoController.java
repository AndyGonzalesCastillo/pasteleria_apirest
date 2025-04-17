package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.ProductoEntity;
import com.pasteleria.gestionPasteleria.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService servicio;

    @Autowired
    private CategoriaService serviciocategoria;

    @GetMapping("/listarproducto")
    public String MostrarProducto(Model modelo) {
        modelo.addAttribute("productos", servicio.findAllCustom());
        return "producto/listar";
    }

    @GetMapping("/registroproducto")
    public String MostrarRegistroProducto(Model modelo) {
        modelo.addAttribute("categorias",
                serviciocategoria.findAllCustom());
        return "producto/crear";
    }

    @GetMapping("/actualizaproducto/{id}")
    public String MostrarActualizaProducto(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("categorias",
                serviciocategoria.findAllCustom());
        modelo.addAttribute("productos", servicio.findById(id));
        return "producto/editar";
    }

    @GetMapping("/eliminarproducto/{id}")
    public String EliminarProducto(@PathVariable Long id,
                                    Model modelo) {
        ProductoEntity objproducto = new ProductoEntity();
        objproducto.setCodigo(id);
        servicio.delete(objproducto);
        return "redirect:/listarproducto";
    }

    @ModelAttribute("producto")
    public ProductoEntity ModeloProducto() {
        return new ProductoEntity();
    }

    @PostMapping("/registrarproducto")
    public String RegistrarProducto(@ModelAttribute("producto") ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarproducto";
    }

    @PostMapping("actualizarproducto/{id}")
    public String ActualizarProducto(@PathVariable Long id,
                                      @ModelAttribute("producto") ProductoEntity c) {
        servicio.update(c);
        return "redirect:/listarproducto";
    }




}
