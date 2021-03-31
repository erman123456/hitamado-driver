package pt.lunata.hitamado.model.pickup

import com.google.gson.annotations.SerializedName

data class ResponseContinuePickup(
    @field:SerializedName("success")
    val success: Boolean? = null
)