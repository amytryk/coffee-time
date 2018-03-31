package com.logos.converter;

import com.logos.dto.ShipingDTO;
import com.logos.entity.Shipping;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Anzhelika on 12/25/2016.
 */
@Component
public class ShippingToDTOConverter implements Converter<Shipping, ShipingDTO> {

    @Override
    public ShipingDTO convert(Shipping shipping) {
        ShipingDTO shipingDTO = new ShipingDTO();

        shipingDTO.setId(shipping.getId());
        shipingDTO.setName(shipping.getName());
        shipingDTO.setPhone(shipping.getPhone());

        return shipingDTO;
    }
}
