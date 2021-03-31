package pt.lunata.hitamado.model.siapantar

import com.google.gson.annotations.SerializedName

data class ResponsePostSiapantar(
    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)