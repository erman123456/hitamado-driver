package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class DroptoAppend(

	@field:SerializedName("drop_code")
	val dropCode: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("drop_name")
	val dropName: String? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)