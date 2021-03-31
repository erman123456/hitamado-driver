package pt.lunata.hitamado.model.delegasi

import com.google.gson.annotations.SerializedName

data class ResponseDelegasi(
    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("error")
    val error: Boolean? = null

)