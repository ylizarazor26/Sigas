package com.sigas.gestion.controladores;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NavegacionControlador {

    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}


