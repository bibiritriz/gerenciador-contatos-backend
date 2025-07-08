package br.sp.gov.itu.fatec.backend.exceptions;

import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  private static final String FIELD_TIMESTAMP = "timestamp";
  private static final String FIELD_STATUS = "status";
  private static final String FIELD_ERROR = "error";
  private static final String FIELD_MESSAGE = "message";
  private static final String ERROR_NOT_FOUND = "Not Found";


  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleContactNotFound(ContactNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(AddressNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleAddressNotFound(AddressNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleCategoryNotFound(CategoryNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(EmailNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handleEmailNotFound(EmailNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(PhoneNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handlePhoneNotFound(PhoneNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(PhotoNotFoundException.class)
  public ResponseEntity<Map<String, Object>> handlePhotoNotFound(PhotoNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 404, FIELD_ERROR,
            ERROR_NOT_FOUND, FIELD_MESSAGE, ex.getMessage()));
  }

  @ExceptionHandler(InvalidPatchFieldException.class)
  public ResponseEntity<Map<String, Object>> handleInvalidPatchField(
      InvalidPatchFieldException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(Map.of(FIELD_TIMESTAMP, LocalDateTime.now(), FIELD_STATUS, 400, FIELD_ERROR,
            "Invalid Field", FIELD_MESSAGE, ex.getMessage()));
  }
}
