package com.servicio.cliente.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicio.cliente.Models.ClienteModels;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

    @RequestMapping(value = "/Formulario", method = RequestMethod.GET)
    public String ClenteFormulario(Model modelo){

        ClienteModels cliente = new ClienteModels();

        modelo.addAttribute("miCliente", cliente);

        return "formulario-cliente";
    }


    
}
