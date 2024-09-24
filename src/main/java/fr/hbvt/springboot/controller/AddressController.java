package fr.hbvt.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hbvt.springboot.dto.AddressDto;
import fr.hbvt.springboot.entity.Address;
import fr.hbvt.springboot.jsonviews.AddressJsonview;
import fr.hbvt.springboot.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/addresss")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @JsonView(AddressJsonview.showAddressSimple.class)
    public List<Address> getAllAddress() {
        return addressService.list();
    }

    @GetMapping("/{id}")
    @JsonView(AddressJsonview.showAddressDetailed.class)
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public Address create(@RequestBody AddressDto addressDto) {
        return addressService.create(addressDto);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        return addressService.update(addressDto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }
}
