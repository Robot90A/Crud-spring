package com.servicio.cliente.Service;

import java.util.List;
import com.servicio.cliente.Models.ClienteModels;

public interface ClienteServce {


    public List<ClienteModels> ListarCliente();

    public void GuardarCliente(ClienteModels cliente);

    public ClienteModels ActualizarCliente(ClienteModels clienteModels);

    public void eliminarCliente(Long id);
    
}
