package br.sp.gov.itu.fatec.backend.controllers;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.sp.gov.itu.fatec.backend.entities.Category;
import br.sp.gov.itu.fatec.backend.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("categories")
@CrossOrigin
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @Operation(summary = "Criar nova categoria")
  @PostMapping
  public ResponseEntity<Category> save(@RequestBody Category category) {
    Category saved = categoryService.save(category);
    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(location).body(saved);
  }

  @Operation(summary = "Listar todas as categorias")
  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    return ResponseEntity.ok(categoryService.getAll());
  }

  @Operation(summary = "Buscar categoria por ID")
  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(@PathVariable Long id) {
    return ResponseEntity.ok(categoryService.getById(id));
  }

  @Operation(summary = "Atualização total da categoria")
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Category category) {
    categoryService.update(id, category);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Excluir categoria")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    categoryService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
