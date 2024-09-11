package org.esfe.LLLVG20240910.Dtos.Productos;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProductoSalida implements Serializable {
    private Integer id;
    private String nombreLLVG;
    private String descripcionLLVG;
    private BigDecimal precio;
}