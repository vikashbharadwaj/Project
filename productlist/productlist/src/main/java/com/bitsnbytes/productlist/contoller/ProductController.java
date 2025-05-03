package com.bitsnbytes.productlist.contoller;

import com.bitsnbytes.productlist.dto.ProductDto;
import com.bitsnbytes.productlist.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "product Rest api crud operation",
        description = "create read update delete operation for product api"
)
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    //getAll
    @Operation(
            summary = "featch all product",
            description = "Restapi to all product"

    )
    @GetMapping
    public List<ProductDto> getAllProduct(){
        return productService.getAllProduct();
    }
    @Operation(
            summary = "featch  product by product id",
            description = "Restapi to all product"

    )
    //getbyid
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable  Long id){
      return   productService.getProductById(id);
    }
    @Operation(
            summary = "save  product by product id",
            description = "Restapi to all product"

    )
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
   @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
      return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);

    }
    @Operation(
            summary = "update product by product id",
            description = "Restapi to all product"

    )
    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
       return productService.updateProduct(id,productDto);
    }
    @Operation(
            summary = "delete product by product id",
            description = "Restapi to all product"

    )
    //delete
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
       return productService.deleteProduct(id);
    }
}
