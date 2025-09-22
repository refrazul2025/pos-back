package org.palina.pos.service

import org.palina.pos.dto.OutletDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.mapper.ProductMapper
import org.palina.pos.model.OutletModel
import org.palina.pos.model.ProductModel
import org.palina.pos.repository.OutletRepository
import org.palina.pos.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service


@Service
class ProductService {

    @Autowired
    private ProductRepository productRepository

    @Autowired
    private OutletRepository outletRepository

    ProductDto save(ProductDto product) {
        OutletModel outletModel = outletRepository.findById(product.outletId).get()
        ProductModel productModel = ProductMapper.toModel(product)
        productModel.outlet = outletModel
        return ProductMapper.toDto(productRepository.save(productModel))
    }

    List<ProductDto> list(OutletDto outlet){
        Optional<OutletModel> outletModel = outletRepository.findById(outlet?.id)

        ProductModel productModel = new ProductModel()
        productModel.outlet = outletModel.get()

        Example<ProductModel> example = Example.of(productModel)

        return productRepository.findAll(example)
                .stream()
                .map(ProductMapper::toDto).toList()
    }

    ProductDto update( ProductDto product ){
        Optional<OutletModel> outletModel = outletRepository.findById(product.outletId)
        ProductModel model = productRepository.findByCodeAndOutlet(product.code, outletModel.get())

        if(model.currentStock != product.currentStock){
            model.currentStock = product.currentStock
        }

        return ProductMapper.toDto(productRepository.save(model))
    }

    ProductDto findByName(ProductDto product){
        Optional<OutletModel> outletModel = outletRepository.findById(product.outletId)
        ProductModel model = productRepository.findByCodeAndOutlet(product.code, outletModel.get())

        return ProductMapper.toDto(model)
    }
}
