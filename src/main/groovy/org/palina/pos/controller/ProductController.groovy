package org.palina.pos.controller

import org.palina.pos.dto.GeneralResponseDto
import org.palina.pos.dto.ProductDto
import org.palina.pos.use_case.producto.AddNewProductUseCase
import org.palina.pos.use_case.producto.ListProductUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/product")
class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final AddNewProductUseCase addNewProductUseCase
    private final ListProductUseCase listProductUseCase

    ProductController(AddNewProductUseCase addNewProductUseCase, ListProductUseCase listProductUseCase) {
        this.addNewProductUseCase = addNewProductUseCase
        this.listProductUseCase = listProductUseCase
    }

    @ResponseBody
    @PostMapping("save")
    ResponseEntity<GeneralResponseDto> save(@RequestBody ProductDto req) {
        log.info("save req {}", req)
        def response = addNewProductUseCase.execute(req)
        def res = null

        if(!response.advertencias()){
            res = new ResponseEntity<GeneralResponseDto>(response, HttpStatus.OK)
        }else {
            res = new ResponseEntity<GeneralResponseDto>(response, HttpStatus.BAD_REQUEST)
        }
        log.info("... save res {}", res)
        return res
    }

    @ResponseBody
    @GetMapping("list/{outletId}")
    ResponseEntity<GeneralResponseDto> list(@PathVariable("outletId") Long outletId){
        log.info("list req {}", outletId)
        def res = new ResponseEntity<GeneralResponseDto>(listProductUseCase.execute(outletId), HttpStatus.OK)
        log.info("... list res {}", res)
        return res
    }
}
