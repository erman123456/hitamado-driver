package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class ComodityAppend(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)