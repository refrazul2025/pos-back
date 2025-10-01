package org.palina.pos.dto

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.ToString

import java.time.LocalDateTime

@ToString
class ProductDto{
    private String code
    private String description
    private String category1
    private String category2
    private String barcode
    private BigDecimal purchasePrice
    private BigDecimal salePrice
    private Integer currentStock
    private Integer unitsAdd
    private Integer unitsDelete
    private Long outletId

    String getCode() {
        return code
    }

    void setCode(String code) {
        this.code = code
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getCategory1() {
        return category1
    }

    void setCategory1(String category1) {
        this.category1 = category1
    }

    String getCategory2() {
        return category2
    }

    void setCategory2(String category2) {
        this.category2 = category2
    }

    String getBarcode() {
        return barcode
    }

    void setBarcode(String barcode) {
        this.barcode = barcode
    }

    BigDecimal getPurchasePrice() {
        return purchasePrice
    }

    void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice
    }

    BigDecimal getSalePrice() {
        return salePrice
    }

    void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice
    }

    Integer getCurrentStock() {
        return currentStock
    }

    void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock
    }

    Integer getUnitsAdd() {
        return unitsAdd
    }

    void setUnitsAdd(Integer unitsAdd) {
        this.unitsAdd = unitsAdd
    }

    Integer getUnitsDelete() {
        return unitsDelete
    }

    void setUnitsDelete(Integer unitsDelete) {
        this.unitsDelete = unitsDelete
    }

    Long getOutletId() {
        return outletId
    }

    void setOutletId(Long outletId) {
        this.outletId = outletId
    }

    LocalDateTime getCreateAt() {
        return createAt
    }

    void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt
    }

    LocalDateTime getUpdateAt() {
        return updateAt
    }

    void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt
    }
    @JsonIgnore
    LocalDateTime createAt

    @JsonIgnore
    LocalDateTime updateAt


}