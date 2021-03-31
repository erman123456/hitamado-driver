package pt.lunata.hitamado.model.deliverairline

import com.google.gson.annotations.SerializedName

data class ResponseConfirmDeliverAirline(
    @field:SerializedName("success")
    val success: Boolean? = null
)