package com.pasteleria.gestionPasteleria.controller;

import com.pasteleria.gestionPasteleria.entity.CategoriaEntity;
import com.pasteleria.gestionPasteleria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CategoriaController {

    //@GetMapping --> para poder manejar las rutas --> obtener una ruta y mostrar
    //la vista correspondiente(.html)
    //Para cargar datos en la vista primero agregamos un modelo de tipo Model
    //en ese modelo enviaremos los datos hacia la vista, haciendo uso de una
    //variable de envio, en este caso sera "categoria" y dentro de esa variable
    //podemos enviar la informacion en este caso enviamos la funcion findAllCustom
    //que te hace una consulta a la base de datos y te trae toda la informacion
    @Autowired
    private CategoriaService servicio;

    @GetMapping("/listarcategoria")
    public String MostrarCategoria(Model modelo) {
        modelo.addAttribute("categorias", servicio.findAllCustom());
        return "categoria/listar";
    }

    @GetMapping("/registrocategoria")
    public String MostrarRegistroCategoria() {
        return "categoria/crear";
    }

    @GetMapping("/actualizacategoria/{id}")
    public String MostrarActualizaCategoria(@PathVariable Long id,
                                            Model modelo) {
        modelo.addAttribute("categorias", servicio.findById(id));
        return "categoria/editar";
    }

    @GetMapping("/eliminarcategoria/{id}")
    public String EliminarCategoria(@PathVariable Long id,
                                    Model modelo) {
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setCodigo(id);
        servicio.delete(objcategoria);
        return "redirect:/listarcategoria";
    }

    @ModelAttribute("categoria")
    public CategoriaEntity ModeloCategoria() {
        return new CategoriaEntity();
    }

    @PostMapping("/registrarcategoria")
    public String RegistrarCategoria(@ModelAttribute("categoria") CategoriaEntity c) {
        servicio.add(c);
        return "redirect:/listarcategoria";
    }

    @PostMapping("actualizarcategoria/{id}")
    public String ActualizarCategoria(@PathVariable Long id,
                                      @ModelAttribute("categoria") CategoriaEntity c) {
        servicio.update(c);
        return "redirect:/listarcategoria";
    }
}
