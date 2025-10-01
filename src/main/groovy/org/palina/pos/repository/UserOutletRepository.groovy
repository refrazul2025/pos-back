package org.palina.pos.repository

import org.palina.pos.model.UserOutletId
import org.palina.pos.model.UserOutletModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserOutletRepository extends JpaRepository<UserOutletModel, UserOutletId>{

    UserOutletModel findByIdUserId(Long userId)
    UserOutletModel findByIdOutletId(Long outletId)
}