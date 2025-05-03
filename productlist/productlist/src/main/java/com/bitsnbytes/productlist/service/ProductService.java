package com.bitsnbytes.productlist.service;

import com.bitsnbytes.productlist.dto.ProductDto;
import com.bitsnbytes.productlist.entity.Category;
import com.bitsnbytes.productlist.entity.Product;
import com.bitsnbytes.productlist.mapper.ProductMapper;
import com.bitsnbytes.productlist.repository.CateogryRepository;
import com.bitsnbytes.productlist.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CateogryRepository cateogryRepository;


    public ProductDto createProduct(ProductDto productDto){
      Category category= cateogryRepository.findById(productDto.getCateogryId())
                .orElseThrow(()->new RuntimeException("cateogry not found"));

      //Dto to entity
        Product product=ProductMapper.toProductEntity(productDto,category);
       product= productRepository.save(product);

       //entity to dto
       return ProductMapper.toProductDto(product);
    }
    //get all
    public List<ProductDto>getAllProduct(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDto).toList();
    }
    public ProductDto getProductById(Long id){
      Product product=  productRepository.findById(id)
              .orElseThrow(()->new RuntimeException("product not found"));
      return ProductMapper.toProductDto(product);

    }
    //update
    public ProductDto updateProduct(Long id,ProductDto productDto){
        Product product=  productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("product not found"));
      Category category=  cateogryRepository.findById(productDto.getCateogryId())
                        .orElseThrow(()->new RuntimeException("cateogry not found"));
                   product.setName(productDto.getName());
                   product.setDescription(product.getDescription());
                   product.setPrice(productDto.getPrice());
                   product.setCategory(category);
                   productRepository.save(product);
                   return ProductMapper.toProductDto(product);

    }
    //delete
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "producr"+id+"has been deleted";

    }
}
