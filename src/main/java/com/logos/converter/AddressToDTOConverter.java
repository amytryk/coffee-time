package com.logos.converter;

import com.logos.dto.AddressDTO;
import com.logos.entity.Address;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Anzhelika on 12/25/2016.
 */
@Component
public class AddressToDTOConverter implements Converter<Address, AddressDTO> {

    @Override
    public AddressDTO convert(Address address) {
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setPostalCode(address.getPostalCode());
        addressDTO.setCountry(address.getCountry().getIsoCode());

        StringBuilder fullAddress = new StringBuilder();

        if (address.getStreet() != null) {
            fullAddress.append(address.getStreet()).append(", ");
        }

        if (address.getCity() != null) {
            fullAddress.append(address.getCity()).append(", ");
        }

        if (address.getPostalCode() != 0) {
            fullAddress.append(address.getPostalCode()).append(", ");
        }

        if (address.getCountry() != null) {
            fullAddress.append(address.getCountry().getIsoCode());
        }

        addressDTO.setFullAddress(fullAddress.toString());

        return addressDTO;
    }
}
