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
import br.sp.gov.itu.fatec.backend.entities.Address;
import br.sp.gov.itu.fatec.backend.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("addresses")
@CrossOrigin
@Tag(name = "Endereços", description = "Operações de gerenciamento de endereços")
public class AddressController {
  @Autowired
  private AddressService addressService;

  @Operation(summary = "Criar novo endereço")
  @PostMapping
  public ResponseEntity<Address> save(@RequestBody Address address) {
    Address saved = addressService.save(address);
    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(saved.getId()).toUri();
    return ResponseEntity.created(location).body(saved);
  }

  @Operation(summary = "Listar todos os endereços")
  @GetMapping
  public ResponseEntity<List<Address>> getAll() {
    return ResponseEntity.ok(addressService.getAll());
  }

  @Operation(summary = "Buscar endereço por ID")
  @GetMapping("/{id}")
  public ResponseEntity<Address> getById(@PathVariable Long id) {
    return ResponseEntity.ok(addressService.getById(id));
  }

  @Operation(summary = "Atualização total do endereço")
  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Address address) {
    addressService.update(id, address);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualização parcial do endereço")
  @PatchMapping("/{id}")
  public ResponseEntity<Void> parcialUpdate(@PathVariable Long id,
      @RequestBody Map<String, Object> fields) {
    addressService.parcialUpdate(id, fields);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Excluir endereço")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    addressService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
