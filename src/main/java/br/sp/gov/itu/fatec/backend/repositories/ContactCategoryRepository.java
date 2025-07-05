package br.sp.gov.itu.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.sp.gov.itu.fatec.backend.entities.ContactCategory;

public interface ContactCategoryRepository extends JpaRepository<ContactCategory, Long> {

}
