package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class InvDetailAppend(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("sisa_bayar")
	val sisaBayar: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("jumlah_terbayar")
	val jumlahTerbayar: String? = null,

	@field:SerializedName("id_divisi")
	val idDivisi: Int? = null,

	@field:SerializedName("kurs")
	val kurs: Any? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("invoice_number")
	val invoiceNumber: String? = null,

	@field:SerializedName("uid_data")
	val uidData: String? = null
)