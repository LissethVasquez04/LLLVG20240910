package org.esfe.LLLVG20240910.Servicios.Interfaces;

import org.esfe.LLLVG20240910.Dtos.Productos.ProductoGuardar;
import org.esfe.LLLVG20240910.Dtos.Productos.ProductoModificar;
import org.esfe.LLLVG20240910.Dtos.Productos.ProductoSalida;


import java.util.List;
public interface IProductoService {
    List<ProductoSalida> obtenerTodos();
    ProductoSalida obtenerPorId(Integer id);
    ProductoSalida crear(ProductoGuardar productoGuardar);
    ProductoSalida editar(ProductoModificar productoModificar);
    void eliminarPorId(Integer id);
}