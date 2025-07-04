package br.sp.gov.itu.fatec.backend.entities;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contact {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String lastname;
  private String nickname;
  private Phone[] phone;
  private Email[] email;
  private Address[] address;
  private LocalDate birthday;
  private String note;
  private boolean favorite;
  private Category category;
  private String photo;

  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Contact other = (Contact) obj;
    return Objects.equals(id, other.id);
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLastname() {
    return lastname;
  }
  public void setLastname(String lastname) {
    this.lastname = lastname;
  }
  public String getNickname() {
    return nickname;
  }
  public void setNickname(String nickname) {
    this.nickname = nickname;
  }
  public Phone[] getPhone() {
    return phone;
  }
  public void setPhone(Phone[] phone) {
    this.phone = phone;
  }
  public Email[] getEmail() {
    return email;
  }
  public void setEmail(Email[] email) {
    this.email = email;
  }
  public Address[] getAddress() {
    return address;
  }
  public void setAddress(Address[] address) {
    this.address = address;
  }
  public LocalDate getBirthday() {
    return birthday;
  }
  public void setBirthday(LocalDate birthday) {
    this.birthday = birthday;
  }
  public String getNote() {
    return note;
  }
  public void setNote(String note) {
    this.note = note;
  }
  public boolean isFavorite() {
    return favorite;
  }
  public void setFavorite(boolean favorite) {
    this.favorite = favorite;
  }
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }
}
