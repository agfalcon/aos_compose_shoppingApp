package kgb.plum.presentation.db.endtity

import kgb.plum.domain.model.Category
import kgb.plum.domain.model.Price
import kgb.plum.domain.model.Shop

data class PurchaseProductEntity(
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
)
