// com.proyecto.categoria.config.DataLoader.java
package com.proyecto.categoria.config;

import com.proyecto.categoria.model.Categoria;
import com.proyecto.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (categoriaRepository.count() == 0) {
            cargarCategoriasIniciales();
        }
    }

    private void cargarCategoriasIniciales() {
        // 🔹 CAMBIO: quitamos los IDs fijos, Hibernate generará los IDs automáticamente
        List<Categoria> categorias = Arrays.asList(
            crearCategoria("Bebestibles", "Gaseosas, jugos y bebidas energéticas."),
            crearCategoria("Víveres", "Alimentos no perecederos como arroz, fideos y azúcar."),
            crearCategoria("Limpieza", "Productos de aseo personal y del hogar."),
            crearCategoria("Abarrotes", "Generalmente productos de consumo diario.")
        );

        // 🔹 CAMBIO: usamos saveAll normalmente sin asignar IDs manuales
        categoriaRepository.saveAll(categorias);
        System.out.println("✅ " + categorias.size() + " categorías cargadas inicialmente.");
    }

    // 🔹 CAMBIO: método crearCategoria ya no recibe ni asigna el ID
    private Categoria crearCategoria(String nombre, String descripcion) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);
        return categoria;
    }
}
