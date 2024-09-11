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

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalida> buscarPorId(@PathVariable Integer id) {
        ProductoSalida producto = productoService.obtenerPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
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
        // Se asume que el ID se usará para encontrar y actualizar el producto correcto
        // Si `ProductoModificar` no tiene un campo para ID, deberías manejar eso en el servicio
        ProductoSalida producto = productoService.editar(productoModificar);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        productoService.eliminarPorId(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }
}

