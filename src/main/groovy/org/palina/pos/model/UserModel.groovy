package org.palina.pos.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

import java.time.LocalDateTime

@Entity
@Table(name = "users")
class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id

    @Column(nullable = false, unique = true)
    String username

    @Column(nullable = false)
    String password

    @Column(nullable = false)
    String email

    @Column(name = "created_at")
    LocalDateTime createdAt

    @Column(name = "updated_at")
    LocalDateTime updatedAt
}
