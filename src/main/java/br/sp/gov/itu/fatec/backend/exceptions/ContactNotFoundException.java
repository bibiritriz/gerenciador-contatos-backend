package br.sp.gov.itu.fatec.backend.exceptions;

public class ContactNotFoundException extends RuntimeException {
  public ContactNotFoundException(Long id) {
    super("Contato com ID " + id + " não encontrado");
  }
}
