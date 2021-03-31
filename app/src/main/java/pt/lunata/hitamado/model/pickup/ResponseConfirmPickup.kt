package pt.lunata.hitamado.model.pickup

import com.google.gson.annotations.SerializedName

data class ResponseConfirmPickup(

	@field:SerializedName("confirmed")
	val confirmed: Boolean? = null
)
