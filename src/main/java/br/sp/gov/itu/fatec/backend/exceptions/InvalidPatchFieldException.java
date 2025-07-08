package br.sp.gov.itu.fatec.backend.exceptions;

public class InvalidPatchFieldException extends RuntimeException {
  public InvalidPatchFieldException(String fieldName) {
    super("Campo inválido no PATCH: " + fieldName);
  }
}
