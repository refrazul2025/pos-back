package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "outlet")
class OutletModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id

    @Column
    private String name

    @Column
    private String prefix

    @Column(name = "create_at")
    private LocalDateTime createAt

    @Column(name = "update_at")
    private LocalDateTime updateAt

}
