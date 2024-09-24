package fr.hbvt.springboot.service;

import fr.hbvt.springboot.exception.CustomEntityNotFoundException;
import fr.hbvt.springboot.repository.AddressRepository;
import fr.hbvt.springboot.entity.Address;
import fr.hbvt.springboot.dto.AddressDto;
import fr.hbvt.springboot.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressService implements ServiceListInterface<Address, Long, AddressDto, AddressDto>{
   
    private final AddressRepository addressRepository;
    
    @Override
    public Address create(AddressDto addressDto) {
    return addressRepository.saveAndFlush(objectFromDto(new Address(),addressDto));
    }
    
    @Override
    public Address update(AddressDto addressDto, Long id) {
    Address address = objectFromDto(findById(id), addressDto);
    address.setId(id);
    addressRepository.flush();
    return address;
    }

    @Override
    public void delete(Long id) {
    addressRepository.deleteById(id);
    }
    
    @Override
    public Address findById(Long id) {
    return addressRepository.findById(id).orElseThrow(CustomEntityNotFoundException::new);
    }
    
    @Override
    public List<Address> list() {
    return addressRepository.findAll();
    }
    
    private Address objectFromDto(Address address,AddressDto addressDto) {
   
    //Faire les xxx.set(xxx.get());
    return address;
    }
}
