package com.bitsnbytes.productlist.mapper;

import com.bitsnbytes.productlist.dto.ProductDto;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.entity.Product;

public class ProductMapper {



    public static ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()

        );

    }
    public  static  Product toProductEntity(ProductDto productDto, Category category){
        Product product=new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);

        return product;

    }
}
