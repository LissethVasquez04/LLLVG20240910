package org.esfe.LLLVG20240910.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class ProductLLVG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_llvg", nullable = false)
    private String nombreLLVG;

    @Column(name = "descripcion_llvg")
    private String descripcionLLVG;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
}