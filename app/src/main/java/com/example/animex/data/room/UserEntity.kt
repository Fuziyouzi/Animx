package com.example.animex.data.room

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.*
import com.example.animex.domain.models.User
import com.example.animex.domain.models.UserSignUp
import java.io.ByteArrayOutputStream

@Entity(
    tableName = "accounts",
    indices = [
        Index("email", unique = true)
    ]
)
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val nickname: String,
    @ColumnInfo(collate = ColumnInfo.NOCASE) val email: String,
    val password: String,
    val image: Bitmap?
//    val favoritesAnime: ArrayList<String>
) {

    fun toAccount(): User = User(
        id = id,
        nickname = nickname,
        email = email,
        image = image
    )

    companion object {
        fun fromLoginData(login: UserSignUp): UserEntity = UserEntity(
            id = 0,
            email = login.email,
            nickname = login.nickname,
            password = login.password,
            image = null
        )
    }

}
class Converter{

    @TypeConverter
    fun fromBitmap(bitmap: Bitmap?): ByteArray{
        val output = ByteArrayOutputStream()
        bitmap?.compress(Bitmap.CompressFormat.PNG, 100, output)
        return output.toByteArray()
    }

    @TypeConverter
    fun fromByteArray(byteArray: ByteArray): Bitmap?{
        return BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.size)
    }
}