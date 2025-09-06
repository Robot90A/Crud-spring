package com.servicio.cliente.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.servicio.cliente.Models.ClienteModels;
import com.servicio.cliente.Repository.ClienteRepository;
import java.util.Optional;

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
        public Optional<ClienteModels> CargarCliente(Long id) {

            return clienteRepository.findById(id);

    }
    

    @Override
    @Transactional
    public void eliminarCliente(Long id) {

        clienteRepository.deleteById(id);
    }

    


}
