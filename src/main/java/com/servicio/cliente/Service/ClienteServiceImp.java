package com.servicio.cliente.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicio.cliente.Models.ClienteModels;
import com.servicio.cliente.Repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteServce {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteModels> ListarCliente() {

        return clienteRepository.findAll();

    }

    @Override
    @Transactional
    public void GuardarCliente(ClienteModels cliente) {

        clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public ClienteModels ActualizarCliente(ClienteModels clienteModels) {

        return clienteRepository.save(clienteModels);

    }

    @Override
    @Transactional
    public void eliminarCliente(Long id) {

        clienteRepository.deleteById(id);
    }

}
