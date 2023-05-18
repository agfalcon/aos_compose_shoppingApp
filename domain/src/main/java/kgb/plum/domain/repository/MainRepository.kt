package kgb.plum.domain.repository

import kgb.plum.domain.model.Product

interface MainRepository {
    fun getProductList() : List<Product>
}