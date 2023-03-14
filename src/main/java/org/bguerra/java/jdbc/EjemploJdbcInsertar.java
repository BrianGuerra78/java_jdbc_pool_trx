package org.bguerra.java.jdbc;

import org.bguerra.java.jdbc.modelo.Categoria;
import org.bguerra.java.jdbc.modelo.Producto;
import org.bguerra.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.bguerra.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.bguerra.java.jdbc.repositorio.Repositorio;
import org.bguerra.java.jdbc.servicio.CatalogoServicio;
import org.bguerra.java.jdbc.servicio.Servicio;
import org.bguerra.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbcInsertar {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("=============LISTAR================");
        servicio.listar().forEach(System.out::println);
        System.out.println("=============INSERTAR NUEVA CATEGORIA==============");
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");


        System.out.println("==============INSERTAR NUEVO PRODUCTO===============");
        Producto producto = new Producto();
        producto.setNombre("Lampara Led Escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("HC90190");
        servicio.guardarProductoConCategoria(producto, categoria);

        System.out.println("Producto guardado con exito " + producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}