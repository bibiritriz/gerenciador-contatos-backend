package br.sp.gov.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.sp.gov.itu.fatec.backend.entities.Address;
import br.sp.gov.itu.fatec.backend.exceptions.AddressNotFoundException;
import br.sp.gov.itu.fatec.backend.exceptions.InvalidPatchFieldException;
import br.sp.gov.itu.fatec.backend.repositories.AddressRepository;

@Service
public class AddressService {
  @Autowired
  private AddressRepository addressRepository;

  public List<Address> getAll() {
    return addressRepository.findAll();
  }

  public Address getById(Long id) {
    return addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
  }

  public Address save(Address address) {
    return addressRepository.save(address);
  }

  public Address update(Long id, Address newAddress) {
    Address address = getById(id);

    address.setCity(newAddress.getCity());
    address.setComplement(newAddress.getComplement());
    address.setCountry(newAddress.getCountry());
    address.setNeighborhood(newAddress.getNeighborhood());
    address.setNumber(newAddress.getNumber());
    address.setState(newAddress.getState());
    address.setStreet(newAddress.getStreet());
    address.setZipCode(newAddress.getZipCode());

    return addressRepository.save(address);
  }

  public void parcialUpdate(Long id, Map<String, Object> fields) {
    Address address = getById(id);

    fields.forEach((field, value) -> {
      switch (field) {
        case "number":
          address.setNumber((String) value);
          break;
        case "street":
          address.setStreet((String) value);
          break;
        case "neighborhood":
          address.setNeighborhood((String) value);
          break;
        case "complement":
          address.setComplement((String) value);
          break;
        case "city":
          address.setCity((String) value);
          break;
        case "state":
          address.setState((String) value);
          break;
        case "country":
          address.setCountry((String) value);
          break;
        case "zipCode":
          address.setZipCode((String) value);
          break;
        default:
          throw new InvalidPatchFieldException(field);
      }
    });

    addressRepository.save(address);
  }

  public void delete(Long id) {
    getById(id);
    addressRepository.deleteById(id);
  }
}
