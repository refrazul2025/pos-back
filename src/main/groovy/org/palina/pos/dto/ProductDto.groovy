package org.palina.pos.dto

import com.fasterxml.jackson.annotation.JsonIgnore

import java.time.LocalDateTime

class ProductDto{
    String code
    String description
    String category1
    String category2
    String barcode
    BigDecimal purchasePrice
    BigDecimal salePrice
    Integer currentStock
    Integer unitsAdd
    Integer unitsDelete
    Long outletId

    @JsonIgnore
    LocalDateTime createAt

    @JsonIgnore
    LocalDateTime updateAt
}