package com.bitsnbytes.productlist.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Schema(
        name = "cateogry",
        description = "it hold cateogry information along with their product"


)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CateogryDto {

    private Long id;
    private String name;
    private List<ProductDto> products;

}
