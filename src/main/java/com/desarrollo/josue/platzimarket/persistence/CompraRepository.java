package com.desarrollo.josue.platzimarket.persistence;

import com.desarrollo.josue.platzimarket.domain.Purchase;
import com.desarrollo.josue.platzimarket.domain.repository.PurchaseRepository;
import com.desarrollo.josue.platzimarket.persistence.crud.CompraCrudRepository;
import com.desarrollo.josue.platzimarket.persistence.entity.Compra;
import com.desarrollo.josue.platzimarket.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Component Es una manera general de indicar a sqpring que la clase se trata de un componente
//pero es mejor colocal @Repository ya que es mas especificao con el contenido de la clase
//Con esta anotacion le indicamos a spring que esta clase va interactuar con nuestra base de datos
@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        //Investigar sobre el almacenamiento en cascada de los productos.
        //Usamos un foreach y setCompra con el fin de que cada producto que exista en la compra conozca a que compra pertenece.
        //Ademas hay que configurar algunos aspectos en las anotaciones del objeto Compra para que almacene en cascada los datos
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));


        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
