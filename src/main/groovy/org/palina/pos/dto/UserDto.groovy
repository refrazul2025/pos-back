package org.palina.pos.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class UserDto {

    private Long id
    private String username
    private String email
    private String password

    UserDto() {} // Constructor vacío necesario para Jackson

    UserDto(Long id, String username, String email) {
        this.id = id
        this.username = username
        this.email = email
    }

    @JsonProperty
    Long getId() { return id }

    @JsonProperty
    String getUsername() { return username }

    @JsonProperty
    String getEmail() { return email }

    @JsonProperty
    String getPassword() {
        return password
    }

    void setId(Long id) { this.id = id }
    void setUsername(String username) { this.username = username }
    void setEmail(String email) { this.email = email }



    void setPassword(String password) {
        this.password = password
    }
}
