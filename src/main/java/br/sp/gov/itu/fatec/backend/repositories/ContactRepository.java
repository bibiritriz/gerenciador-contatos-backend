package br.sp.gov.itu.fatec.backend.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.sp.gov.itu.fatec.backend.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
  List<Contact> findByNameContainingIgnoreCase(String name);

  List<Contact> findByNameIgnoreCase(String name);

  List<Contact> findByLastnameContainingIgnoreCase(String lastname);

  List<Contact> findByLastnameIgnoreCase(String lastname);

  List<Contact> findByNicknameContainingIgnoreCase(String nickname);

  List<Contact> findByNicknameIgnoreCase(String nickname);

  List<Contact> findByPhones_NumberContainingIgnoreCase(String partialNumber);

  List<Contact> findByEmails_AddressContainingIgnoreCase(String partialAddress);

  List<Contact> findByFavorite(boolean favorite);

  List<Contact> findByCategories_NameIgnoreCase(String name);

  List<Contact> findByCategories_Id(Long categoryId);
}

