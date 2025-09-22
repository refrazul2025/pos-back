package org.palina.pos.service

import org.palina.pos.model.UserModel
import org.palina.pos.repository.UserRespository
import org.springframework.stereotype.Service

@Service
class UserService {

    private UserRespository userRespository

    UserModel create(UserModel user){
        return userRespository.save()
    }

    UserModel findByUserName(String userName){
        return userRespository.findByUsername(userName)
    }
}
