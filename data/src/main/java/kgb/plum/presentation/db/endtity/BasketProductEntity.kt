package kgb.plum.presentation.db.endtity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kgb.plum.domain.model.Category
import kgb.plum.domain.model.Price
import kgb.plum.domain.model.Product
import kgb.plum.domain.model.Shop
import kgb.plum.presentation.db.converter.BasketConverter


@Entity(tableName = "basket")
@TypeConverters(BasketConverter::class)
data class BasketProductEntity(
    @PrimaryKey
    val productId: String,
    val productName: String,
    val imageUrl: String,
    val price: Price,
    val category: Category,
    val shop: Shop,
    val isNew: Boolean,
    val isFreeShipping: Boolean,
)

fun BasketProductEntity.toDomainModel() : Product {
    return Product(
        productId = productId,
        productName = productName,
        imageUrl = imageUrl,
        price = price,
        category = category,
        shop = shop,
        isNew = isNew,
        isFreeShipping = isFreeShipping
    )
}
