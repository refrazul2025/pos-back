package org.palina.pos.model

import jakarta.persistence.Embeddable

@Embeddable
class UserOutletId implements Serializable {

    private Long userId;
    private Long outletId;

    UserOutletId() {}

    UserOutletId(Long userId, Long outletId) {
        this.userId = userId;
        this.outletId = outletId;
    }

    // Getters, setters, equals, hashCode
    @Override
    boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserOutletId)) return false;
        UserOutletId that = (UserOutletId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(outletId, that.outletId);
    }

    @Override
    int hashCode() {
        return Objects.hash(userId, outletId);
    }
}
