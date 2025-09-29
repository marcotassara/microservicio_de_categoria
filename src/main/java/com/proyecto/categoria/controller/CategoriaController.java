package com.proyecto.categoria.controller;

import com.proyecto.categoria.dto.CategoriaDTO;
import com.proyecto.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Endpoint: GET http://localhost:8081/api/v1/categorias
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarTodas() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    // Endpoint: GET http://localhost:8081/api/v1/categorias/{id}
    // ESTE ES EL ENDPOINT QUE LLAMA EL MICROSERVICIO DE PRODUCTOS
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obtenerPorId(@PathVariable Long id) {
        CategoriaDTO categoria = categoriaService.obtenerPorId(id);
        if (categoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> crear(@RequestBody CategoriaDTO dto) {
        CategoriaDTO nueva = categoriaService.guardar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
}
