package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class PaymentAppend(

	@field:SerializedName("id_term")
	val idTerm: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)