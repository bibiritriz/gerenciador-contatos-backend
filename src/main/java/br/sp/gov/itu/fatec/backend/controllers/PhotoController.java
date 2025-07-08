package br.sp.gov.itu.fatec.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.sp.gov.itu.fatec.backend.entities.Photo;
import br.sp.gov.itu.fatec.backend.services.PhotoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("photos")
@CrossOrigin
public class PhotoController {
  @Autowired
  private PhotoService photoService;

  @Operation(summary = "Listar todos as fotos")
  @GetMapping
  public ResponseEntity<List<Photo>> getAll() {
    return ResponseEntity.ok(photoService.getAll());
  }
}
