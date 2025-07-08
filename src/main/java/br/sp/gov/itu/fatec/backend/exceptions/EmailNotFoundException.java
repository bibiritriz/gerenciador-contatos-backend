package br.sp.gov.itu.fatec.backend.exceptions;

public class EmailNotFoundException extends RuntimeException {
  public EmailNotFoundException(Long id) {
    super("Email com ID " + id + " não encontrado");
  }
}
