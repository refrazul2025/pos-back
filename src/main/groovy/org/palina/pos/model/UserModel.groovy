package org.palina.pos.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.ToString
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
@Table(name = "users")
@ToString
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


    // Relación con la tabla intermedia
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserOutletModel> outlets = new HashSet<>()

}
