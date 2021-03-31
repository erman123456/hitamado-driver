package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class ResponseAirlineOperational(

	@field:SerializedName("master")
	val master: Master? = null
)