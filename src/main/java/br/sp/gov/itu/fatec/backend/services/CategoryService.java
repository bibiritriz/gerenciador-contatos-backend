package br.sp.gov.itu.fatec.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.sp.gov.itu.fatec.backend.entities.Category;
import br.sp.gov.itu.fatec.backend.entities.Contact;
import br.sp.gov.itu.fatec.backend.exceptions.CategoryNotFoundException;
import br.sp.gov.itu.fatec.backend.repositories.CategoryRepository;
import br.sp.gov.itu.fatec.backend.repositories.ContactRepository;

@Service
public class CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ContactRepository contactRepository;

  public List<Category> getAll() {
    return categoryRepository.findAll();
  }

  public Category getById(Long id) {
    return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
  }

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public Category update(Long id, Category newCategory) {
    Category category = getById(id);
    category.setName(newCategory.getName());
    return categoryRepository.save(category);
  }

  public void delete(Long id) {
    Category category = getById(id);
    List<Contact> contacts = contactRepository.findByCategories_Id(id);
    contacts.forEach((contact) -> {
      contact.getCategories().remove(category);
      contactRepository.save(contact);
    });
    categoryRepository.deleteById(id);
  }
}
