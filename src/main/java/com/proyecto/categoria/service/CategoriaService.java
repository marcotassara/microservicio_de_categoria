package com.proyecto.categoria.service;

import com.proyecto.categoria.dto.CategoriaDTO;
import com.proyecto.categoria.model.Categoria;
import com.proyecto.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> obtenerTodas() {
        return categoriaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CategoriaDTO obtenerPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }
    
    public CategoriaDTO guardar(CategoriaDTO dto) {
        Categoria categoria = convertToEntity(dto);
        Categoria saved = categoriaRepository.save(categoria);
        return convertToDTO(saved);
    }
    
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Métodos de Mapeo
    private CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNombre(categoria.getNombre());
        dto.setDescripcion(categoria.getDescripcion());
        return dto;
    }
    
    private Categoria convertToEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId()); // Es importante mantener el ID para updates
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return categoria;
    }
}
