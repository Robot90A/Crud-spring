package com.servicio.cliente.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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



    @RequestMapping(value = "/Lista", method = RequestMethod.GET)
    public String listaCliente(Model modelo){

        List<ClienteModels> ListaClientea = clienteServce.ListarCliente();

        modelo.addAttribute("ListaClientes", ListaClientea);

        return "lista-cliente";
    }

    
    @PostMapping("/guardar")
    public String GuardarCliente(@ModelAttribute("miCliente") ClienteModels cliente){

        clienteServce.GuardarCliente(cliente);

        return "redirect:/cliente/Lista";

    
    }


    @RequestMapping(value = "/cargarCliente", method = RequestMethod.GET)
    public String CargarCliene(Model modelo, @RequestParam("id") Long idCliente){

        ClienteModels miClienteModels = clienteServce.CargarCliente(idCliente)

               .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        modelo.addAttribute("miCliente", miClienteModels);

        return "formulario-cliente";

    }


    @RequestMapping(value = "/eliminarCliente", method = RequestMethod.GET)
    public String EliminarCliente(@RequestParam("id") Long idCliente){

        clienteServce.eliminarCliente(idCliente);

        return "redirect:/cliente/Lista";
    }


    
}
