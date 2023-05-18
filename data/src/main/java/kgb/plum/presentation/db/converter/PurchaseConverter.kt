package kgb.plum.presentation.db.converter

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import kgb.plum.domain.model.Category
import kgb.plum.domain.model.Price
import kgb.plum.domain.model.Shop

class PurchaseConverter {
    private val gson = GsonBuilder().create()

    @TypeConverter
    fun fromPrice(value: Price) : String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toPrice(value: String) : Price {
        return gson.fromJson(value, Price::class.java)
    }

    @TypeConverter
    fun fromCategory(value: Category) : String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCategory(value: String) : Category {
        return gson.fromJson(value, Category::class.java)
    }

    @TypeConverter
    fun fromShop(value: Shop) : String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toShop(value: String) : Shop {
        return gson.fromJson(value, Shop::class.java)
    }
}