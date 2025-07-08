package br.sp.gov.itu.fatec.backend.entities;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TBL_ADDRESSES")
public class Address implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String number;
  private String street;
  private String neighborhood;
  private String complement;
  private String city;
  private String state;
  private String country;
  private String zipCode;
  @ManyToMany(mappedBy = "addresses")
  @JsonBackReference
  private List<Contact> contacts;
}
