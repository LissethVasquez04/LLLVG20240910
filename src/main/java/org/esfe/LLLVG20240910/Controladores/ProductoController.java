package org.esfe.LLLVG20240910.Controladores;

import org.esfe.LLLVG20240910.Dtos.Productos.ProductoGuardar;
import org.esfe.LLLVG20240910.Dtos.Productos.ProductoModificar;
import org.esfe.LLLVG20240910.Dtos.Productos.ProductoSalida;
import org.esfe.LLLVG20240910.Servicios.Interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoSalida>> mostrarTodos() {
        List<ProductoSalida> productos = productoService.obtenerTodos();
        if (!productos.isEmpty()) {
            return ResponseEntity.ok(productos);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductoSalida> crear(@RequestBody ProductoGuardar productoGuardar) {
        ProductoSalida producto = productoService.crear(productoGuardar);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoSalida> editar(@PathVariable Integer id, @RequestBody ProductoModificar productoModificar) {
        ProductoSalida producto = productoService.editar(productoModificar);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        productoService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}
