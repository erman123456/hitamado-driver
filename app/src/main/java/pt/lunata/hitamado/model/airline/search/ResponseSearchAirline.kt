package pt.lunata.hitamado.model.airline.search

import pt.lunata.hitamado.model.airline.operational.DataItem
import com.google.gson.annotations.SerializedName

data class ResponseSearchAirline(

	@field:SerializedName("data")
	val data: DataItem? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)

data class Data(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("po_master_number")
	val mpoNumber:String?=null,

	@field:SerializedName("quantity_est")
	val quantityEst:String?=null,

	@field:SerializedName("collie_est")
	val collieEst:String?=null,

	@field:SerializedName("airport_name")
	val airportName:String?=null
)
