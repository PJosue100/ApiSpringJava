package com.desarrollo.josue.platzimarket.persistence.entity;

import javax.persistence.*;

@Entity
//Cuando uso un mobre diferente al que tiene la tabla de la base de datos debo de agregar la etiqueta @table
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Cuando uso un mobre diferente al que tiene la tabla de la base de datos debo de agregar la etiqueta @Column para indicar que representa una columna de la tabla
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    //la relacion es muchos a uno porque varios productos puede estar en una sola categoria
    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false,updatable = false)
    //Para establecer la relacion entre productos y categoria se debe de crear un objeto categoria
    private Categoria categoria;


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
<<<<<<< HEAD

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
=======
>>>>>>> ce010ff858cd2c38f8e28b1af4dfae667930191a
}
