package org.palina.pos.model

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_outlet")
class UserOutletModel {

    @EmbeddedId
    UserOutletId id = new UserOutletId()

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    UserModel user

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("outletId")
    OutletModel outlet

    @Column(length = 50)
    String role

    @Column(name = "assigned_at")
    LocalDateTime assignedAt = LocalDateTime.now()

}