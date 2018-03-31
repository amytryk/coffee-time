package com.logos.converter;

import com.logos.dto.CategoryDTO;
import com.logos.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Anzhelika on 12/26/2016.
 */
@Component
public class CategoryToDTOConverter implements Converter<Category, CategoryDTO> {

    @Override
    public CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());

        return categoryDTO;
    }
}
