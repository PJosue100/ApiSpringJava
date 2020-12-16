package com.desarrollo.josue.platzimarket.persistence;

import com.desarrollo.josue.platzimarket.domain.Product;
import com.desarrollo.josue.platzimarket.domain.repository.ProductRepository;
import com.desarrollo.josue.platzimarket.persistence.crud.ProductoCrudRepository;
import com.desarrollo.josue.platzimarket.persistence.entity.Producto;
import com.desarrollo.josue.platzimarket.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Component Es una manera general de indicar a sqpring que la clase se trata de un componente
//pero es mejor colocal @Repository ya que es mas especificao con el contenido de la clase
//Con esta anotacion le indicamos a spring que esta clase va interactuar con nuestra base de datos
@Repository
public class ProductoRepository implements ProductRepository {

    //Inversion de control lo que se sabe al momento es que el hay dos objetos creados no instanciados que van a provocar una excepcion null
    //por lo tanto debemos de ceder el control de dichos objetos al framework en este caso es spring, usaremos para tal cometido la anotacion @Autowired de spring
    // logramos lo anterior por medio del contenedor de inversion de control de spring, hay que tener en consideracion que esta etiqueta solo funciona con componentes de spring

    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();

        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos=  productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);

        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto1 -> mapper.toProduct(producto1));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }



}
