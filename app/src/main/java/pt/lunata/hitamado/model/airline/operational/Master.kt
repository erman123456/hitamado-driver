package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class Master(

	@field:SerializedName("current_page")
	val currentPage: Int = 1,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("last_page")
	val lastPage: Int? = null,

	@field:SerializedName("total")
	val total:Int?=null
)