package br.sp.gov.itu.fatec.backend.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.sp.gov.itu.fatec.backend.entities.Phone;
import br.sp.gov.itu.fatec.backend.services.PhoneService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("phones")
@CrossOrigin
public class PhoneController {
  @Autowired
  private PhoneService phoneService;

  @Operation(summary = "Criar novo telefone")
  @PostMapping
  public ResponseEntity<Phone> save(@RequestBody Phone phone) {
    Phone saved = phoneService.save(phone);
    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(location).body(saved);
  }

  @Operation(summary = "Listar todos os telefones")
  @GetMapping
  public ResponseEntity<List<Phone>> getAll() {
    return ResponseEntity.ok(phoneService.getAll());
  }

  @Operation(summary = "Buscar telefone por ID")
  @GetMapping("/{id}")
  public ResponseEntity<Phone> getById(@PathVariable Long id) {
    return ResponseEntity.ok(phoneService.getById(id));
  }

  @Operation(summary = "Atualização total do telefone")
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Phone phone) {
    phoneService.update(id, phone);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualização parcial do telefone")
  @PatchMapping("/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> fields) {
    phoneService.parcialUpdate(id, fields);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Excluir telefone")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    phoneService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
