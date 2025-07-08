package br.sp.gov.itu.fatec.backend.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.sp.gov.itu.fatec.backend.entities.Address;
import br.sp.gov.itu.fatec.backend.entities.Category;
import br.sp.gov.itu.fatec.backend.entities.Contact;
import br.sp.gov.itu.fatec.backend.entities.Email;
import br.sp.gov.itu.fatec.backend.entities.Phone;
import br.sp.gov.itu.fatec.backend.entities.Photo;
import br.sp.gov.itu.fatec.backend.exceptions.AddressNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.CategoryNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.ContactNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.EmailNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.InvalidPatchFieldException;
import br.sp.gov.itu.fatec.backend.exceptions.PhoneNotFoundException;
import br.sp.gov.itu.fatec.backend.repositories.AddressRepository;
import br.sp.gov.itu.fatec.backend.repositories.CategoryRepository;
import br.sp.gov.itu.fatec.backend.repositories.ContactRepository;
import br.sp.gov.itu.fatec.backend.repositories.EmailRepository;
import br.sp.gov.itu.fatec.backend.repositories.PhoneRepository;

@Service
public class ContactService {
  @Autowired
  private ContactRepository contactRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private EmailRepository emailRepository;

  @Autowired
  private PhoneRepository phoneRepository;

  public List<Contact> findByPartialName(String name) {
    return contactRepository.findByNameContainingIgnoreCase(name);
  }

  public List<Contact> findByExactName(String name) {
    return contactRepository.findByNameIgnoreCase(name);
  }

  public List<Contact> findByPartialLastname(String lastname) {
    return contactRepository.findByLastnameContainingIgnoreCase(lastname);
  }

  public List<Contact> findByExactLastname(String lastname) {
    return contactRepository.findByLastnameIgnoreCase(lastname);
  }

  public List<Contact> findByPartialNickname(String nickname) {
    return contactRepository.findByNicknameContainingIgnoreCase(nickname);
  }

  public List<Contact> findByExactNickname(String nickname) {
    return contactRepository.findByNicknameIgnoreCase(nickname);
  }

  public List<Contact> findByPartialPhoneNumber(String number) {
    return contactRepository.findByPhones_NumberContainingIgnoreCase(number);
  }

  public List<Contact> findByPartialEmailAddress(String emailAddress) {
    return contactRepository.findByEmails_AddressContainingIgnoreCase(emailAddress);
  }

  public List<Contact> findByFavorite(boolean favorite) {
    return contactRepository.findByFavorite(favorite);
  }

  public List<Contact> findByCategoryName(String categoryName) {
    return contactRepository.findByCategories_NameIgnoreCase(categoryName);
  }

  public List<Contact> findByCategories_Id(Long categoryId) {
    return contactRepository.findByCategories_Id(categoryId);
  }

  public Contact saveContact(Contact contact) {
    if (!contact.getAddresses().isEmpty()) {
      contact.getAddresses().forEach((a) -> {
        this.addressRepository.save(a);
      });
    } ;
    return contactRepository.save(contact);
  }

  public void deleteContact(Long id) {
    getByID(id);
    contactRepository.deleteById(id);
  }

  public List<Contact> getAll() {
    return contactRepository.findAll();
  }

  public Contact getByID(Long id) {
    return contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
  }

  public void updateContact(Long id, Contact newContact) {
    Contact contact =
        contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));
    contact.setAddresses(newContact.getAddresses());
    contact.setBirthday(newContact.getBirthday());
    contact.setCategories(newContact.getCategories());
    contact.setEmails(newContact.getEmails());
    contact.setFavorite(newContact.isFavorite());
    contact.setLastname(newContact.getLastname());
    contact.setName(newContact.getName());
    contact.setNickname(newContact.getNickname());
    contact.setNote(newContact.getNote());
    contact.setPhones(newContact.getPhones());
    contact.setPhoto(newContact.getPhoto());
    contactRepository.save(contact);
  }

  public void parcialUpdate(Long id, Map<String, Object> fields) {
    Contact contact = getByID(id);
    fields.forEach((field, value) -> {
      switch (field) {
        case "name":
          contact.setName((String) value);
          break;

        case "lastname":
          contact.setLastname((String) value);
          break;
        case "nickname":
          contact.setNickname((String) value);
          break;

        case "phones":
          contact.setPhones((List<Phone>) value);
          break;

        case "emails":
          contact.setEmails((List<Email>) value);
          break;

        case "addresses":
          contact.setAddresses((List<Address>) value);
          break;

        case "birthday":
          contact.setBirthday((LocalDate) value);
          break;
        case "note":
          contact.setNote((String) value);
          break;

        case "favorite":
          contact.setFavorite((boolean) value);
          break;

        case "categories":
          contact.setCategories((List<Category>) value);
          break;

        case "photourl":
          contact.setPhoto((Photo) value);
          break;
        default:
          throw new InvalidPatchFieldException(field);
      }

    });
    contactRepository.save(contact);
  }
}
