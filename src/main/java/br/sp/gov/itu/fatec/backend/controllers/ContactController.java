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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.sp.gov.itu.fatec.backend.entities.Contact;
import br.sp.gov.itu.fatec.backend.services.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("contacts")
@CrossOrigin
@Tag(name = "Controle de Contatos", description = "Operações relacionadas à entidade de contatos")
public class ContactController {
  @Autowired
  private ContactService contactService;

  @Operation(summary = "Busca contatos por nome parcial")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/name/partial")
  public ResponseEntity<List<Contact>> findByPartialName(@RequestParam String name) {
    return ResponseEntity.ok(contactService.findByPartialName(name));
  }

  @Operation(summary = "Busca contatos por nome exato")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/name/exact")
  public ResponseEntity<List<Contact>> findByExactName(@RequestParam String name) {
    return ResponseEntity.ok(contactService.findByExactName(name));
  }

  @Operation(summary = "Busca contatos por sobrenome parcial")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/lastname/partial")
  public ResponseEntity<List<Contact>> findByPartialLastname(@RequestParam String lastname) {
    return ResponseEntity.ok(contactService.findByPartialLastname(lastname));
  }

  @Operation(summary = "Busca contatos por apelido parcial")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/lastname/exact")
  public ResponseEntity<List<Contact>> findByExactLastname(@RequestParam String lastname) {
    return ResponseEntity.ok(contactService.findByExactLastname(lastname));
  }

  @Operation(summary = "Busca contatos por apelido parcial")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/nickname/partial")
  public ResponseEntity<List<Contact>> findByPartialNickname(@RequestParam String nickname) {
    return ResponseEntity.ok(contactService.findByPartialNickname(nickname));
  }

  @Operation(summary = "Busca contatos por número de telefone")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/phone")
  public ResponseEntity<List<Contact>> findByPhone(@RequestParam String partialNumber) {
    return ResponseEntity.ok(contactService.findByPartialPhoneNumber(partialNumber));
  }

  @Operation(summary = "Busca contatos por e-mail")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/email")
  public ResponseEntity<List<Contact>> findByEmail(@RequestParam String partialEmail) {
    return ResponseEntity.ok(contactService.findByPartialEmailAddress(partialEmail));
  }

  @Operation(summary = "Busca contatos favoritos")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/favorite")
  public ResponseEntity<List<Contact>> findByFavorite(@RequestParam boolean favorite) {
    return ResponseEntity.ok(contactService.findByFavorite(favorite));
  }

  @Operation(summary = "Busca contatos por nome de categoria")
  @ApiResponse(responseCode = "200", description = "Contatos encontrados")
  @GetMapping("/search/category")
  public ResponseEntity<List<Contact>> findByCategory(@RequestParam String categoryName) {
    return ResponseEntity.ok(contactService.findByCategoryName(categoryName));
  }

  @Operation(summary = "Cria um novo contato")
  @ApiResponses({ @ApiResponse(responseCode = "201", description = "Contato criado com sucesso"),
      @ApiResponse(responseCode = "400", description = "Requisição inválida", content = @Content(schema = @Schema(hidden = true))) })
  @PostMapping
  public ResponseEntity<Contact> saveContact(
      @RequestBody(description = "Dados do novo contato", required = true, content = @Content(schema = @Schema(implementation = Contact.class))) @org.springframework.web.bind.annotation.RequestBody Contact contact) {
    Contact savedContact = contactService.saveContact(contact);
    URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(savedContact.getId()).toUri();
    return ResponseEntity.created(location).body(savedContact);
  }

  @Operation(summary = "Lista todos os contatos")
  @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
  @GetMapping
  public ResponseEntity<List<Contact>> getContacts() {
    return ResponseEntity.ok(contactService.getAll());
  }

  @Operation(summary = "Busca um contato pelo ID")
  @ApiResponses({ @ApiResponse(responseCode = "200", description = "Contato encontrado"),
      @ApiResponse(responseCode = "404", description = "Contato não encontrado") })
  @GetMapping("{id}")
  public ResponseEntity<Contact> getContactById(
      @Parameter(description = "ID do contato", example = "1") @PathVariable Long id) {
    return ResponseEntity.ok(contactService.getByID(id));
  }


  @Operation(summary = "Atualiza um contato existente")
  @ApiResponses({ @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso"),
      @ApiResponse(responseCode = "404", description = "Contato não encontrado") })
  @PutMapping("{id}")
  public ResponseEntity<Void> updateContact(
      @Parameter(description = "ID do contato", example = "1") @PathVariable Long id,
      @org.springframework.web.bind.annotation.RequestBody Contact contact) {
    contactService.saveContact(contact);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Atualiza parcialmente um contato")
  @ApiResponses({ @ApiResponse(responseCode = "204", description = "Contato atualizado com sucesso"),
      @ApiResponse(responseCode = "404", description = "Contato não encontrado") })
  @PatchMapping("{id}")
  public ResponseEntity<Void> updateParcialContact(@PathVariable Long id,
  @org.springframework.web.bind.annotation.RequestBody Map<String, Object> contact) {
    contactService.parcialUpdate(id, contact);
    return ResponseEntity.noContent().build();
  }

  @Operation(summary = "Remove um contato pelo ID")
  @ApiResponses({ @ApiResponse(responseCode = "204", description = "Contato removido com sucesso"),
      @ApiResponse(responseCode = "404", description = "Contato não encontrado") })
  @DeleteMapping("{id}")
  public ResponseEntity<Void> deleteContact(
      @Parameter(description = "ID do contato", example = "1") @PathVariable Long id) {
    contactService.deleteContact(id);
    return ResponseEntity.noContent().build();
  }

}
