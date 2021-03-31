package pt.lunata.hitamado.model.airline.operational

import com.google.gson.annotations.SerializedName

data class MarketingAppend(

    @field:SerializedName("jabatan_append")
    val jabatanAppend: JabatanAppend? = null,

    @field:SerializedName("no_emergency_1")
    val noEmergency1: String? = null,

    @field:SerializedName("mulai_kerja")
    val mulaiKerja: String? = null,

    @field:SerializedName("id_agama")
    val idAgama: Int? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("no_wa")
    val noWa: String? = null,

    @field:SerializedName("nominal_bpjs_ketenagakerjaan")
    val nominalBpjsKetenagakerjaan: String? = null,

    @field:SerializedName("id_office")
    val idOffice: String? = null,

    @field:SerializedName("nominal_bpjs_kesehatan")
    val nominalBpjsKesehatan: String? = null,

    @field:SerializedName("id_jabatan")
    val idJabatan: Int? = null,

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("nik")
    val nik: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("nominal_npwp")
    val nominalNpwp: String? = null,

    @field:SerializedName("id_jk")
    val idJk: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("nominal_makan")
    val nominalMakan: String? = null,

    @field:SerializedName("id_pegawai")
    val idPegawai: Int? = null,

    @field:SerializedName("no_npwp")
    val noNpwp: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("tanggal_lahir")
    val tanggalLahir: String? = null,

    @field:SerializedName("id_divisi")
    val idDivisi: Int? = null,

    @field:SerializedName("gaji")
    val gaji: Int? = null,

    @field:SerializedName("no_bpjs_ketenagakerjaan")
    val noBpjsKetenagakerjaan: String? = null,

    @field:SerializedName("ikatan_no_emergency_1")
    val ikatanNoEmergency1: String? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null,

    @field:SerializedName("no_kontak")
    val noKontak: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("foto")
    val foto: String? = null,

    @field:SerializedName("user_level")
    val userLevel: Int? = null,

    @field:SerializedName("nominal_transport")
    val nominalTransport: String? = null,

    @field:SerializedName("no_bpjs_kesehatan")
    val noBpjsKesehatan: String? = null,

    @field:SerializedName("uid_atasan")
    val uidAtasan: String? = null
)