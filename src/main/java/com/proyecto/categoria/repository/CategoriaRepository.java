package com.proyecto.categoria.repository;

import com.proyecto.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Si quisieras buscar categorías por nombre:
    // Categoria findByNombre(String nombre); 
}