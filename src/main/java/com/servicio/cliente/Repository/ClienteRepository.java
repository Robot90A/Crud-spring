package com.servicio.cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.cliente.Models.ClienteModels;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModels, Long> {


}
