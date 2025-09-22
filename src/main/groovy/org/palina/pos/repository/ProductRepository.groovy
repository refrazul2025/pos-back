package org.palina.pos.repository

import org.palina.pos.model.OutletModel
import org.palina.pos.model.ProductModel
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository extends JpaRepository<ProductModel,String>{

    ProductModel findByCodeAndOutlet(String code, OutletModel outlet)

}
