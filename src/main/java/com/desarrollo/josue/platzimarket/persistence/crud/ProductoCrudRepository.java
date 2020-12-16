package com.desarrollo.josue.platzimarket.persistence.crud;

import com.desarrollo.josue.platzimarket.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD
//Para hacer el to go de un objeto es control mas clic izquierdo sobre el objeto
=======
//Para hacer el to go de un objeto es control mas clic derecho sobre el objeto
>>>>>>> ce010ff858cd2c38f8e28b1af4dfae667930191a

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //Lo comentado es otra opcion para la misma consulta
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?",nativeQuery = true)
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado );
}
