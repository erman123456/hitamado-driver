package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class ComodityNameAppend(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)