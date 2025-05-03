package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.CateogryDto;
import com.bitsnbytes.productlist.entity.Category;

public class CateogryMapper {

    public static CateogryDto toCateogryDto(Category category){
        if(category==null){
            return null;
        }
        CateogryDto cateogryDto=new CateogryDto();
        cateogryDto.setId(category.getId());
        cateogryDto.setName(category.getName());
        cateogryDto.setProducts(category.getProducts().stream().map(ProductMapper::toProductDto).toList());
        return cateogryDto;
    }
    public static Category toCateogryEntity(CateogryDto cateogryDto){
        Category category=new Category();
        category.setName(cateogryDto.getName());
        return category;

    }
}
