package pt.lunata.hitamado.model.airline

import com.google.gson.annotations.SerializedName

data class ResponseAirline(
    @field:SerializedName("house")
    val house: List<HouseItem?>? = null
)

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
    val updatedAt: Any? = null,

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

data class DroptoAppend(

    @field:SerializedName("drop_code")
    val dropCode: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("drop_name")
    val dropName: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null
)

data class PickupAppend(

    @field:SerializedName("drop_code")
    val dropCode: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("drop_name")
    val dropName: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null
)

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

data class FreightAppend(

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
    val createdAt: Any? = null,

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
    val deletedAt: Any? = null,

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

data class HouseItem(

    @field:SerializedName("pick_up_office")
    val pickUpOffice: Boolean? = null,

    @field:SerializedName("dijemput_ke_customer")
    val status: Boolean? = null,

    @field:SerializedName("customer_append")
    val customerAppend: CustomerAppend? = null,

    @field:SerializedName("charge_type")
    val chargeType: String? = null,

    @field:SerializedName("po_house_number")
    val poHouseNumber: String? = null,

    @field:SerializedName("invoice_category")
    val invoiceCategory: Any? = null,

    @field:SerializedName("kode_project")
    val kodeProject: String? = null,

    @field:SerializedName("sub_total_tax")
    val subTotalTax: Int? = null,

    @field:SerializedName("uid_airport")
    val uidAirport: String? = null,

    @field:SerializedName("taxes")
    val taxes: Boolean? = null,

    @field:SerializedName("payment_total")
    val paymentTotal: Int? = null,

    @field:SerializedName("delivery_estimation")
    val deliveryEstimation: String? = null,

    @field:SerializedName("airport_append")
    val airportAppend: AirportAppend? = null,

    @field:SerializedName("comodity_name_append")
    val comodityNameAppend: ComodityNameAppend? = null,

    @field:SerializedName("alias_address")
    val aliasAddress: Any? = null,

    @field:SerializedName("total_penjualan_notax_item_only")
    val totalPenjualanNotaxItemOnly: Int? = null,

    @field:SerializedName("uid_category")
    val uidCategory: String? = null,

    @field:SerializedName("collie_deal")
    val collieDeal: Int? = null,

    @field:SerializedName("charge_all")
    val chargeAll: Boolean? = null,

    @field:SerializedName("mpo_name")
    val mpoNumber: String? = null,

    @field:SerializedName("invoice_locked")
    val invoiceLocked: Boolean? = null,

    @field:SerializedName("port_load_name")
    val portLoadName: String? = null,

    @field:SerializedName("cost_if_both")
    val costIfBoth: Any? = null,

    @field:SerializedName("uid_comodity")
    val uidComodity: String? = null,

    @field:SerializedName("mpo_append")
    val mpoAppend: Any? = null,

    @field:SerializedName("marketing_append")
    val marketingAppend: MarketingAppend? = null,

    @field:SerializedName("registred_at")
    val registredAt: Int? = null,

    @field:SerializedName("uid_master_po")
    val uidMasterPo: Any? = null,

    @field:SerializedName("port_destiny_name")
    val portDestinyName: String? = null,

    @field:SerializedName("airport_code")
    val airportCode: String? = null,

    @field:SerializedName("cost_total_self")
    val costTotalSelf: Int? = null,

    @field:SerializedName("uid_delivery")
    val uidDelivery: String? = null,

    @field:SerializedName("freight_name")
    val freightName: String? = null,

    @field:SerializedName("cost_total_self_and_child")
    val costTotalSelfAndChild: Int? = null,

    @field:SerializedName("id_unit")
    val idUnit: String? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("address_destiny")
    val addressDestiny: String? = null,

    @field:SerializedName("comodity_name")
    val comodityName: String? = null,

    @field:SerializedName("child_cost")
    val childCost: Int? = null,

    @field:SerializedName("unit_name")
    val unitName: String? = null,

    @field:SerializedName("tax_if_both")
    val taxIfBoth: Any? = null,

    @field:SerializedName("airport_name")
    val airportName: String? = null,

    @field:SerializedName("comodity_unit")
    val comodityUnit: String? = null,

    @field:SerializedName("unit_append")
    val unitAppend: UnitAppend? = null,

    @field:SerializedName("marketing_name")
    val marketingName: String? = null,

    @field:SerializedName("quantity_est")
    val quantityEst: String? = null,

    @field:SerializedName("total_penjualan_tax_item_only")
    val totalPenjualanTaxItemOnly: Int? = null,

    @field:SerializedName("urutan_invoice")
    val urutanInvoice: Int? = null,

    @field:SerializedName("invoice_status")
    val invoiceStatus: Boolean? = null,

    @field:SerializedName("make_invoice")
    val makeInvoice: Boolean? = null,

    @field:SerializedName("child")
    val child: Int? = null,

    @field:SerializedName("uid_parrent")
    val uidParrent: Any? = null,

    @field:SerializedName("dropto_append")
    val droptoAppend: DroptoAppend? = null,

    @field:SerializedName("activity_time_diff_for_humans")
    val activityTimeDiffForHumans: String? = null,

    @field:SerializedName("tax_total")
    val taxTotal: Int? = null,

    @field:SerializedName("cost_estimation")
    val costEstimation: Int? = null,

    @field:SerializedName("cost_comodity")
    val costComodity: String? = null,

    @field:SerializedName("total_if_both")
    val totalIfBoth: Any? = null,

    @field:SerializedName("freight_append")
    val freightAppend: FreightAppend? = null,

    @field:SerializedName("pickup_estimation")
    val pickupEstimation: String? = null,

    @field:SerializedName("lock_date")
    val lockDate: Any? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("total_penjualan_tax")
    val totalPenjualanTax: Int? = null,

    @field:SerializedName("pickup_append")
    val pickupAppend: PickupAppend? = null,

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("tanggal_antar_maskapai")
    val tanggalAntarMaskapai: Any? = null,

    @field:SerializedName("quantity_total")
    val quantityTotal: Int? = null,

    @field:SerializedName("is_deleted")
    val isDeleted: Boolean? = null,

    @field:SerializedName("collie_est")
    val collieEst: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("collie_total")
    val collieTotal: Int? = null,

    @field:SerializedName("uid_customer")
    val uidCustomer: String? = null,

    @field:SerializedName("receiver_name")
    val receiverName: String? = null,

    @field:SerializedName("lock_date_unparsed")
    val lockDateUnparsed: Any? = null,

    @field:SerializedName("quantity_acumulation")
    val quantityAcumulation: Int? = null,

    @field:SerializedName("port_load_append")
    val portLoadAppend: Any? = null,

    @field:SerializedName("uid_pegawai")
    val uidPegawai: String? = null,

    @field:SerializedName("comodity_unit_append")
    val comodityUnitAppend: ComodityUnitAppend? = null,

    @field:SerializedName("cost")
    val cost: String? = null,

    @field:SerializedName("charge")
    val charge: String? = null,

    @field:SerializedName("pickup_name")
    val pickupName: String? = null,

    @field:SerializedName("port_destiny_append")
    val portDestinyAppend: Any? = null,

    @field:SerializedName("invoice_number_tax")
    val invoiceNumberTax: String? = null,

    @field:SerializedName("quantity_show")
    val quantityShow: String? = null,

    @field:SerializedName("alias_name")
    val aliasName: Any? = null,

    @field:SerializedName("quantity_deal")
    val quantityDeal: String? = null,

    @field:SerializedName("child_append")
    val childAppend: List<Any?>? = null,

    @field:SerializedName("information")
    val information: String? = null,

    @field:SerializedName("customer_name")
    val customerName: String? = null,

    @field:SerializedName("invoice_number_notax")
    val invoiceNumberNotax: String? = null,

    @field:SerializedName("total_penjualan_notax")
    val totalPenjualanNotax: Int? = null,

    @field:SerializedName("ke_maskapai")
    val ke_maskapai: Any? = null
)

data class UnitAppend(

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

data class ComodityUnitAppend(

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

data class TermJenis(

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

data class CountryAppend(

    @field:SerializedName("country")
    val country: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

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
