package org.palina.pos.dto

class SaleDetailDto{

    private Long id
    private Long idSlale
    private String productCode
    private Integer quantity
    private BigDecimal unitPrice
    private BigDecimal subtotal

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    Long getIdSlale() {
        return idSlale
    }

    void setIdSlale(Long idSlale) {
        this.idSlale = idSlale
    }

    String getProductCode() {
        return productCode
    }

    void setProductCode(String productCode) {
        this.productCode = productCode
    }

    Integer getQuantity() {
        return quantity
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity
    }

    BigDecimal getUnitPrice() {
        return unitPrice
    }

    void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice
    }

    BigDecimal getSubtotal() {
        return subtotal
    }

    void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal
    }
}