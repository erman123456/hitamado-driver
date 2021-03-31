package pt.lunata.hitamado.model.deliverairline

import com.google.gson.annotations.SerializedName

data class ResponseContinueDeliverAirline(
    @field:SerializedName("error")
    val error: Boolean? = null,
    @field:SerializedName("message")
    val message: String? = null
)