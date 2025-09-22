package org.palina.pos.repository

import org.palina.pos.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserRespository extends JpaRepository<UserModel,Long>{

    UserModel findByUsername(String username)
}