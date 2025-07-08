package br.sp.gov.itu.fatec.backend.exceptions;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(Long id) {
    super("Categoria com ID " + id + " não encontrado");
  }
}
