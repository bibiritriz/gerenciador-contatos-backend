package br.sp.gov.itu.fatec.backend.exceptions;

public class PhoneNotFoundException extends RuntimeException{
  public PhoneNotFoundException(Long id) {
    super("Telefone com ID " + id + " não encontrado");
  }
}
