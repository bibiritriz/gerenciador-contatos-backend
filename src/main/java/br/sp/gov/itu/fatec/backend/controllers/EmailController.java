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
import br.sp.gov.itu.fatec.backend.entities.Email;
import br.sp.gov.itu.fatec.backend.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("emails")
@CrossOrigin
public class EmailController {
  @Autowired
  private EmailService emailService;

  @Operation(summary = "Criar novo e-mail")
  @PostMapping
  public ResponseEntity<Email> save(@RequestBody Email email) {
    Email saved = emailService.save(email);
    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(location).body(saved);
  }

  @Operation(summary = "Listar todos os e-mails")
  @GetMapping
  public ResponseEntity<List<Email>> getAll() {
    return ResponseEntity.ok(emailService.getAll());
  }

  @Operation(summary = "Buscar e-mail por ID")
  @GetMapping("/{id}")
  public ResponseEntity<Email> getById(@PathVariable Long id) {
    return ResponseEntity.ok(emailService.getById(id));
  }

  @Operation(summary = "Atualizar e-mail totalmente")
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Email email) {
    emailService.update(id, email);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualizar e-mail parcialmente")
  @PatchMapping("/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> fields) {
    emailService.parcialUpdate(id, fields);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Excluir e-mail")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    emailService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
