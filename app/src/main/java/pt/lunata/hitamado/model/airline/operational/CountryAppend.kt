package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class CountryAppend(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("kode")
	val kode: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("mata_uang")
	val mataUang: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)