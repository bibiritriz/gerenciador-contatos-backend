package br.sp.gov.itu.fatec.backend.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "TBL_CONTACTS")
public class Contact implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String lastname;

        private String nickname;

        @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
                        orphanRemoval = true)
        @JsonManagedReference
        private List<Phone> phones = new ArrayList<>();

        @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL,
                        orphanRemoval = true)
        @JsonManagedReference
        private List<Email> emails = new ArrayList<>();

        @ManyToMany
        @JoinTable(name = "contacts_addresses", joinColumns = @JoinColumn(name = "contact_id"),
                        inverseJoinColumns = @JoinColumn(name = "address_id"))
        private List<Address> addresses = new ArrayList<>();

        private LocalDate birthday;

        private String note;

        private boolean favorite;

        @ManyToMany
        @JoinTable(name = "contacts_categories", joinColumns = @JoinColumn(name = "contact_id"),
                        inverseJoinColumns = @JoinColumn(name = "category_id"))
        private List<Category> categories = new ArrayList<>();

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "photo_id")
        private Photo photo;
}
