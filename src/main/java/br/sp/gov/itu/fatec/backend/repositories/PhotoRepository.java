package br.sp.gov.itu.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.sp.gov.itu.fatec.backend.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

}
