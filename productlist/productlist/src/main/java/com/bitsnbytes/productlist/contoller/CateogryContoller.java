package com.bitsnbytes.productlist.contoller;

import com.bitsnbytes.productlist.dto.CateogryDto;
import com.bitsnbytes.productlist.service.CateogryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cateogry")
@AllArgsConstructor
public class CateogryContoller {

    private CateogryService cateogryService;
    @Operation(
            summary = "featch  cateogry by product id",
            description = "Restapi to all cateogry"

    )
     @GetMapping("/getall")
    public List<CateogryDto>getAllCatogry(){
        return cateogryService.getAllCatogry();

    }
    @Operation(
            summary = "save cateogry by product id",
            description = "Restapi to all cateogry"

    )
    @ApiResponse(
            responseCode = "201",
            description = "created"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/post")
    public ResponseEntity<?> createCatogry(@RequestBody CateogryDto cateogryDto){
           CateogryDto saved= cateogryService.createCatogry(cateogryDto);
           return ResponseEntity.status(HttpStatus.CREATED).body(saved);

       // return new ResponseEntity<>(cateogryService.createCatogry(cateogryDto), HttpStatus.CREATED);
    }
    @Operation(
            summary = "featch  cateogry by product id",
            description = "Restapi to all cateogry"

    )
    @GetMapping("/get/{id}")
    public CateogryDto getCatogryById(@PathVariable Long id){
         return  cateogryService.getCatogryById(id);

    }
    @Operation(
            summary = "delete cateogry by product id",
            description = "Restapi to all cateogry"

    )
    @DeleteMapping("/{id}")
    public String deleteCateogry(@PathVariable Long id){
        return cateogryService.deleteCateogry(id);

    }
}
