package com.servicio.cliente.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.servicio.cliente.Models.ClienteModels;
import com.servicio.cliente.Service.ClienteServce;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {


    @Autowired
    private ClienteServce clienteServce;

    @RequestMapping(value = "/Formulario", method = RequestMethod.GET)
    public String ClenteFormulario(Model modelo){

        ClienteModels cliente = new ClienteModels();

        modelo.addAttribute("miCliente", cliente);

        return "formulario-cliente";
    }



    @RequestMapping("/Lista")
    public String listaCliente(Model modelo){

        List<ClienteModels> ListaClientea = clienteServce.ListarCliente();

        modelo.addAttribute("ListaClientes", ListaClientea);

        return "lista-cliente";
    }

    
    @RequestMapping("/guardar")
    public String GuardarCliente(@ModelAttribute("miCliente") ClienteModels cliente){

        clienteServce.GuardarCliente(cliente);

        return "redirect:/cliente/Lista";

    
    }


    
}
