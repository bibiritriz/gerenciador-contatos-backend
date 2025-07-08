package br.sp.gov.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.sp.gov.itu.fatec.backend.entities.Email;
import br.sp.gov.itu.fatec.backend.exceptions.EmailNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.InvalidPatchFieldException;
import br.sp.gov.itu.fatec.backend.repositories.EmailRepository;

@Service
public class EmailService {
  @Autowired
  private EmailRepository emailRepository;

  public List<Email> getAll() {
    return emailRepository.findAll();
  }

  public Email getById(Long id) {
    return emailRepository.findById(id).orElseThrow(() -> new EmailNotFoundException(id));
  }

  public Email save(Email email) {
    return emailRepository.save(email);
  }

  public Email update(Long id, Email newEmail) {
    Email email = getById(id);
    email.setAddress(newEmail.getAddress());
    email.setLabel(newEmail.getLabel());
    return emailRepository.save(email);
  }

  public void parcialUpdate(Long id, Map<String, Object> fields) {
    Email email = getById(id);

    fields.forEach((field, value) -> {
      switch (field) {
        case "address":
          email.setAddress((String) value);
          break;
        case "label":
          email.setLabel((String) value);
          break;
        default:
          throw new InvalidPatchFieldException(field);
      }
    });

    emailRepository.save(email);
  }

  public void delete(Long id) {
    getById(id);
    emailRepository.deleteById(id);
  }
}
