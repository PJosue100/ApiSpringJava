package com.desarrollo.josue.platzimarket.persistence.crud;

import com.desarrollo.josue.platzimarket.persistence.entity.Compra;
import com.desarrollo.josue.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


//Para hacer el to go de un objeto es control mas clic izquierdo sobre el objeto

public interface CompraCrudRepository extends CrudRepository<Compra,Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);
}
