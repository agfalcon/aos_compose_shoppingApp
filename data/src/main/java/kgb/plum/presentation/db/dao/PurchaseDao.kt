package kgb.plum.presentation.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kgb.plum.presentation.db.endtity.PurchaseProductEntity

@Dao
interface PurchaseDao {

    @Query("SELECT * from purchase")
    suspend fun getAll(): List<PurchaseProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: PurchaseProductEntity)

    @Query("DELETE FROM purchase WHERE productId = :id")
    suspend fun delete(id: String)
}