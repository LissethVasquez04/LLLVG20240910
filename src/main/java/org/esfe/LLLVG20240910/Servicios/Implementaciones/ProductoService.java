package org.esfe.LLLVG20240910.Servicios.Implementaciones;
import org.esfe.LLLVG20240910.Dtos.Productos.*;
import org.esfe.LLLVG20240910.Modelos.*;
import org.esfe.LLLVG20240910.Repositorios.*;
import org.esfe.LLLVG20240910.Servicios.Interfaces.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoSalida> obtenerTodos() {
        List<ProductLLVG> productos = productoRepository.findAll();

        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());
    }

   /*  @Override
    public Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable) {
        Page<ProductLLVG> page = productoRepository.findAll(pageable);

        List<ProductoSalida> productosDto = page.stream()
                .map(producto -> modelMapper.map(producto, ProductoSalida.class))
                .collect(Collectors.toList());

        return new PageImpl<>(productosDto, page.getPageable(), page.getTotalElements());
    }*/

    @Override
    public ProductoSalida obtenerPorId(Integer id) {
        return modelMapper.map(productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")), ProductoSalida.class);
    }

    @Override
    public ProductoSalida crear(ProductoGuardar productoGuardar) {
        ProductLLVG producto = productoRepository.save(modelMapper.map(productoGuardar, ProductLLVG.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public ProductoSalida editar(ProductoModificar productoModificar) {
        ProductLLVG producto = productoRepository.save(modelMapper.map(productoModificar, ProductLLVG.class));
        return modelMapper.map(producto, ProductoSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        productoRepository.deleteById(id);
    }
}