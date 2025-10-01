package org.palina.pos.model

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "outlet")
class OutletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column
    String name

    @Column
    String prefix

    @Column(name = "create_at")
    LocalDateTime createAt

    @Column(name = "update_at")
    LocalDateTime updateAt

    // Relación con la tabla intermedia
    @OneToMany(mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserOutletModel> users = new HashSet<>()
}
