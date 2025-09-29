package com.proyecto.categoria.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CATEGORIAS")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_seq")
    @SequenceGenerator(name = "categoria_seq", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
    @Column(name = "IDCATEGORIA", length = 50)
    private Long id;
    
    @Column(name = "NOMBRE", nullable = false, length = 100, unique = true)
    private String nombre;
    
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    

}