package pt.lunata.hitamado.model.logout

import com.google.gson.annotations.SerializedName

data class ResponseLogout(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)
