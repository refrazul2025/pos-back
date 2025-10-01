package org.palina.pos.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
class OutletDto{

    @JsonProperty
    private Long id

    @JsonProperty
    private String name

    @JsonProperty
    private String prefix

    @JsonProperty
    private LocalDateTime creteAt

    @JsonProperty
    private LocalDateTime updateAt

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getPrefix() {
        return prefix
    }

    void setPrefix(String prefix) {
        this.prefix = prefix
    }

    LocalDateTime getCreteAt() {
        return creteAt
    }

    void setCreteAt(LocalDateTime creteAt) {
        this.creteAt = creteAt
    }

    LocalDateTime getUpdateAt() {
        return updateAt
    }

    void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt
    }
}