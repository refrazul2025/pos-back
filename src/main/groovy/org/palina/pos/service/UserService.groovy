package org.palina.pos.service

import org.palina.pos.model.UserModel
import org.palina.pos.repository.UserRespository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private UserRespository userRespository

    UserModel create(UserModel user){
        return userRespository.save()
    }

    UserModel findByUserName(String userName){
        return userRespository.findByUsername(userName)
    }

    UserModel findById(Long id){
        Optional<UserModel> oUserModel = userRespository.findById(id)
        if(!oUserModel.isPresent()){
            return null
        }
        return oUserModel.get()
    }
}
