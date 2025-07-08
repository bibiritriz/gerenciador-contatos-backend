package br.sp.gov.itu.fatec.backend.exceptions;

public class AddressNotFoundException extends RuntimeException {
  public AddressNotFoundException(Long id) {
    super("Endereço com ID " + id + " não encontrado");
  }
}
