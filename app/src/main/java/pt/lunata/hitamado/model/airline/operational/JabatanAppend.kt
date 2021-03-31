package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class JabatanAppend(

	@field:SerializedName("updated_at")
	val updatedAt: Any? = null,

	@field:SerializedName("jabatan")
	val jabatan: String? = null,

	@field:SerializedName("gaji")
	val gaji: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("deleted_at")
	val deletedAt: Any? = null
)