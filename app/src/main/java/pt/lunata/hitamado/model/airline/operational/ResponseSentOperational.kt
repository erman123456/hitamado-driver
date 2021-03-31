package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class ResponseSentOperational(
    @field:SerializedName("error")
    val Error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)