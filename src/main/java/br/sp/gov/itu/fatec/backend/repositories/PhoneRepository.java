package br.sp.gov.itu.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.sp.gov.itu.fatec.backend.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
