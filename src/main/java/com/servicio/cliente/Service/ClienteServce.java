package com.servicio.cliente.Service;

import java.util.List;
import java.util.Optional;

import com.servicio.cliente.Models.ClienteModels;

public interface ClienteServce {


    public List<ClienteModels> ListarCliente();

    public void GuardarCliente(ClienteModels cliente);

    public Optional<ClienteModels> CargarCliente(Long id);

    public void eliminarCliente(Long id);
    
}
