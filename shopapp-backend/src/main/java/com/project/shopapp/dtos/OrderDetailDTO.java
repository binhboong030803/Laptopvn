package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDTO {

    @JsonProperty("order_id")
    @Min(value = 1,message = "Oder id must be > 0")
    private Long oderId;

    @JsonProperty("product_id")
    @Min(value = 1,message = "Product id must be > 0")
    private Long productId;

    @Min(value = 0,message = "Price id must be >= 0")
    private float price;

    @JsonProperty("number_of_product")
    @Min(value = 1,message = "Number of product id must be > 0")
    private int numberOfProduct;

    @Min(value = 1,message = "Total money id must be > 0")
    @JsonProperty("total_money")
    private float totalMoney;

    private String color;
}
