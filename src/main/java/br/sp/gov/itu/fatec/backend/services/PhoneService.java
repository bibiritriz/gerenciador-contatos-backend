package br.sp.gov.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.sp.gov.itu.fatec.backend.entities.Phone;
import br.sp.gov.itu.fatec.backend.exceptions.InvalidPatchFieldException;
import br.sp.gov.itu.fatec.backend.exceptions.PhoneNotFoundException;
import br.sp.gov.itu.fatec.backend.repositories.PhoneRepository;

@Service
public class PhoneService {
  @Autowired
  private PhoneRepository phoneRepository;

  public List<Phone> getAll() {
    return phoneRepository.findAll();
  }

  public Phone getById(Long id) {
    return phoneRepository.findById(id).orElseThrow(() -> new PhoneNotFoundException(id));
  }

  public Phone save(Phone phone) {
    return phoneRepository.save(phone);
  }

  public Phone update(Long id, Phone newPhone) {
    Phone phone = getById(id);
    phone.setNumber(newPhone.getNumber());
    phone.setLabel(newPhone.getLabel());
    return phoneRepository.save(phone);
  }

  public void parcialUpdate(Long id, Map<String, Object> fields) {
    Phone phone = getById(id);

    fields.forEach((field, value) -> {
      switch (field) {
        case "number":
          phone.setNumber((String) value);
          break;
        case "label":
          phone.setLabel((String) value);
          break;
        default:
          throw new InvalidPatchFieldException(field);
      }
    });

    phoneRepository.save(phone);
  }

  public void delete(Long id) {
    getById(id);
    phoneRepository.deleteById(id);
  }
}
