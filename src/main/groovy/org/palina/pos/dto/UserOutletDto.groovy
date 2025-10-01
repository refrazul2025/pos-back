package org.palina.pos.dto

class UserOutletDto {

    private Long userId
    private Long outletId
    private String role

    Long getUserId() {
        return userId
    }

    void setUserId(Long userId) {
        this.userId = userId
    }

    Long getOutletId() {
        return outletId
    }

    void setOutletId(Long outletId) {
        this.outletId = outletId
    }

    String getRole() {
        return role
    }

    void setRole(String role) {
        this.role = role
    }
}
