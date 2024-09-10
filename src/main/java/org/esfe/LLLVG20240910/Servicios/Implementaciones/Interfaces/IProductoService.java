import org.esfe.LLVG20240910.Dtos.Productos.ProductoGuardar;
import org.esfe.LLVG20240910.Dtos.Productos.ProductoModificar;
import org.esfe.LLVG20240910.Dtos.Productos.ProductoSalida;*
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class IProductoServide {
    List<ProductoSalida> obtenerTodos();

    Page<ProductoSalida> obtenerTodosPaginados(Pageable pageable);

    ProductoSalida obtenerPorId(Integer id);

    ProductoSalida crear(ProductoGuardar ProductoGuardar);

    ProductoSalida editar(ProductoModificar ProductoModificar);

    void eliminarPorId(Integer id);
}
