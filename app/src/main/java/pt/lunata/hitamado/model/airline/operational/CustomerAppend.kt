package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class CustomerAppend(

	@field:SerializedName("customer_type")
	val customerType: String? = null,

	@field:SerializedName("id_divisi")
	val idDivisi: Int? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id_tipe")
	val idTipe: String? = null,

	@field:SerializedName("alamat")
	val alamat: String? = null,

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("fax")
	val fax: String? = null,

	@field:SerializedName("uid_pegawai")
	val uidPegawai: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("no_telepon")
	val noTelepon: String? = null,

	@field:SerializedName("term_jenis")
	val termJenis: TermJenis? = null
)