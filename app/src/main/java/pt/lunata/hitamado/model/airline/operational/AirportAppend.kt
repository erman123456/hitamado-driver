package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class AirportAppend(

	@field:SerializedName("negara_id")
	val negaraId: Int? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("kode")
	val kode: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null,

	@field:SerializedName("country_append")
	val countryAppend: CountryAppend? = null
)