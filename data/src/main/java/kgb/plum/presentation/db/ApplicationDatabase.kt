package kgb.plum.presentation.db

import androidx.room.Database
import androidx.room.RoomDatabase
import kgb.plum.presentation.db.dao.BasketDao
import kgb.plum.presentation.db.dao.LikeDao
import kgb.plum.presentation.db.dao.PurchaseDao
import kgb.plum.presentation.db.endtity.BasketProductEntity
import kgb.plum.presentation.db.endtity.LikeProductEntity
import kgb.plum.presentation.db.endtity.PurchaseProductEntity

@Database(entities = [
    PurchaseProductEntity::class,
    LikeProductEntity::class,
    BasketProductEntity::class
    ],
    version = 1
)
abstract class ApplicationDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "ApplicationDatabase.db"
    }

    abstract fun purchaseDao() : PurchaseDao

    abstract fun likeDao() : LikeDao

    abstract fun basketDao() : BasketDao
}