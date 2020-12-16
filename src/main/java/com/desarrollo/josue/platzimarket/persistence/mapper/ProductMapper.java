package com.desarrollo.josue.platzimarket.persistence.mapper;

import com.desarrollo.josue.platzimarket.domain.Product;
import com.desarrollo.josue.platzimarket.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


//La opcion uses la agregamos con el fin de indicar a mapstruc que utilice la clase mapeadora de categoria al momento de recibirla en el objeto productos
@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto",target = "productId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "categoria",target = "category"),
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto>productos);


    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);



}
