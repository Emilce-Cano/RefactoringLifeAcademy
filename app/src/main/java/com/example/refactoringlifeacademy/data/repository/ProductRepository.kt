package com.example.refactoringlifeacademy.data.repository

import com.example.refactoringlifeacademy.data.dto.response.ProductTypesResponse
import com.example.refactoringlifeacademy.data.dto.response.ProductsResponse
import com.example.refactoringlifeacademy.data.dto.response.SingleProductResponse
import com.example.refactoringlifeacademy.data.service.ProductServiceImp
import retrofit2.Response

class ProductRepository(private val service: ProductServiceImp = ProductServiceImp()) {

    suspend fun getProducts(): Response<ProductsResponse>{
        return service.getProducts()
    }

    suspend fun getLastUserProduct():Response<SingleProductResponse>{
        return service.getLastUserProduct()
    }

    suspend fun getProductTypes(): Response<ProductTypesResponse>{
        return service.getProductTypes()
    }

    suspend fun getDailyOffer(): Response<SingleProductResponse>{
        return service.getDailyOffer()
    }
}
