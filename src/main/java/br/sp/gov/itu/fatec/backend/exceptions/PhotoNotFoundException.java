package br.sp.gov.itu.fatec.backend.exceptions;

public class PhotoNotFoundException extends RuntimeException {
  public PhotoNotFoundException(Long id) {
    super("Foto com ID " + id + " não encontrado");
  }
}
