package com.pasteleria.gestionPasteleria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping()
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/menuprincipal")
    public String MostrarMenu() {
        return "menu_principal";
    }
}
