package pt.lunata.hitamado.model.siapantar

import com.google.gson.annotations.SerializedName


data class ResponseSiapAntar(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)

data class ItemHouseBelumTiba(
    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("po_house_number")
    val po_house_number: String? = null
)

data class ItemAllHouse(
    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("po_house_number")
    val po_house_number: String? = null
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

data class ComodityAppend(

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

data class DataItem(

    @field:SerializedName("invoice_number_notaxes")
    val invoiceNumberNotaxes: Any? = null,

    @field:SerializedName("jangka_kredit")
    val jangkaKredit: Any? = null,

    @field:SerializedName("uid_airport")
    val uidAirport: String? = null,

    @field:SerializedName("taxes")
    val taxes: String? = null,

    @field:SerializedName("uid_employee")
    val uidEmployee: String? = null,

    @field:SerializedName("uid_pegawai_lapangan")
    val uidPegawaiLapangan: Any? = null,

    @field:SerializedName("master_link_to")
    val masterLinkTo: String? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("notify_laut")
    val notifyLaut: Any? = null,

    @field:SerializedName("volume_lini1")
    val volumeLini1: Any? = null,

    @field:SerializedName("payment")
    val payment: String? = null,

    @field:SerializedName("uid_category")
    val uidCategory: Int? = null,

    @field:SerializedName("expedisi")
    val expedisi: Any? = null,

    @field:SerializedName("biaya_import")
    val biayaImport: Any? = null,

    @field:SerializedName("port_load")
    val portLoad: Any? = null,

    @field:SerializedName("invoice_locked")
    val invoiceLocked: Boolean? = null,

    @field:SerializedName("keterangan_pembelian")
    val keteranganPembelian: Any? = null,

    @field:SerializedName("seal_number")
    val sealNumber: Any? = null,

    @field:SerializedName("uid_comodity")
    val uidComodity: String? = null,

    @field:SerializedName("customer_laut")
    val customerLaut: Any? = null,

    @field:SerializedName("tanggal_pembelian")
    val tanggalPembelian: Any? = null,

    @field:SerializedName("registred_at")
    val registredAt: Int? = null,

    @field:SerializedName("consignee")
    val consignee: String? = null,

    @field:SerializedName("bl_number")
    val blNumber: Any? = null,

    @field:SerializedName("asal_import")
    val asalImport: Any? = null,

    @field:SerializedName("peb_number")
    val pebNumber: Any? = null,

    @field:SerializedName("id_unit")
    val idUnit: Int? = null,

    @field:SerializedName("vessel_name")
    val vesselName: Any? = null,

    @field:SerializedName("nomor_faktur")
    val nomorFaktur: Any? = null,

    @field:SerializedName("si_status")
    val siStatus: Boolean? = null,

    @field:SerializedName("lc_number")
    val lcNumber: Any? = null,

    @field:SerializedName("charge_price")
    val chargePrice: Any? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("mbl_number")
    val mblNumber: Any? = null,

    @field:SerializedName("port_destiny")
    val portDestiny: Any? = null,

    @field:SerializedName("etd_date")
    val etdDate: Any? = null,

    @field:SerializedName("weight_lini2")
    val weightLini2: Any? = null,

    @field:SerializedName("weight_lini1")
    val weightLini1: Any? = null,

    @field:SerializedName("customer_import")
    val customerImport: Any? = null,

    @field:SerializedName("dikirim_ke_expedisi")
    val dikirimKeExpedisi: Any? = null,

    @field:SerializedName("receiver_import_udara")
    val receiverImportUdara: Any? = null,

    @field:SerializedName("quantity_act")
    val quantityAct: Any? = null,

    @field:SerializedName("booking_laut_detail")
    val bookingLautDetail: Any? = null,

    @field:SerializedName("contents_description")
    val contentsDescription: Any? = null,

    @field:SerializedName("shipper_laut_detail")
    val shipperLautDetail: Any? = null,

    @field:SerializedName("exrate")
    val exrate: Any? = null,

    @field:SerializedName("quantity_est")
    val quantityEst: String? = null,

    @field:SerializedName("shipper_name")
    val shipperName: String? = null,

    @field:SerializedName("tanggal_tiba_expedisi")
    val tanggalTibaExpedisi: Any? = null,

    @field:SerializedName("invoice_status")
    val invoiceStatus: Any? = null,

    @field:SerializedName("collie_act")
    val collieAct: Any? = null,

    @field:SerializedName("import")
    val jsonMemberImport: Boolean? = null,

    @field:SerializedName("suplier_expedisi")
    val suplierExpedisi: Any? = null,

    @field:SerializedName("temp_required")
    val tempRequired: String? = null,

    @field:SerializedName("shipping_type")
    val shippingType: Any? = null,

    @field:SerializedName("lock_date")
    val lockDate: Any? = null,

    @field:SerializedName("house_belum_tiba")
    val houseBelumTiba: List<ItemHouseBelumTiba>? = null,

    @field:SerializedName("all_house")
    val allHouse:List<ItemAllHouse>?=null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("marketing_import_udara")
    val marketingImportUdara: Any? = null,

    @field:SerializedName("address_destination_laut")
    val addressDestinationLaut: Any? = null,

    @field:SerializedName("notify")
    val notify: String? = null,

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("tanggal_antar_maskapai")
    val tanggalAntarMaskapai: Any? = null,

    @field:SerializedName("invoice_number_taxes")
    val invoiceNumberTaxes: Any? = null,

    @field:SerializedName("collie_est")
    val collieEst: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("closing_time")
    val closingTime: Any? = null,

    @field:SerializedName("tanggal_expedisi")
    val tanggalExpedisi: Any? = null,

    @field:SerializedName("tanggal_sampai_maskapai")
    val tanggalSampaiMaskapai: String? = null,

    @field:SerializedName("lock_date_unparsed")
    val lockDateUnparsed: Any? = null,

    @field:SerializedName("smu")
    val smu: Any? = null,

    @field:SerializedName("do_number")
    val doNumber: Any? = null,

    @field:SerializedName("siap_antar")
    val siapAntar: Boolean? = null,

    @field:SerializedName("consignee_laut")
    val consigneeLaut: Any? = null,

    @field:SerializedName("linked")
    val linked: Boolean? = null,

    @field:SerializedName("no_expedisi")
    val noExpedisi: Any? = null,

    @field:SerializedName("agency")
    val agency: Any? = null,

    @field:SerializedName("collie_lini2")
    val collieLini2: Any? = null,

    @field:SerializedName("collie_lini1")
    val collieLini1: Any? = null,

    @field:SerializedName("shipper_laut")
    val shipperLaut: Any? = null,

    @field:SerializedName("flight_number")
    val flightNumber: Any? = null,

    @field:SerializedName("maskapai")
    val maskapai: Any? = null,

    @field:SerializedName("pickup")
    val pickup: Int? = null,

    @field:SerializedName("po_master_number")
    val poMasterNumber: String? = null,

    @field:SerializedName("booking_laut")
    val bookingLaut: Any? = null,

    @field:SerializedName("is_delete")
    val isDelete: Boolean? = null,

    @field:SerializedName("uid_supir")
    val uidSupir: String? = null,

    @field:SerializedName("project_number")
    val projectNumber: Any? = null,

    @field:SerializedName("special_instruction")
    val specialInstruction: String? = null,

    @field:SerializedName("information")
    val information: Any? = null,

    @field:SerializedName("no_po")
    val noPo: Any? = null,

    @field:SerializedName("shipment_type")
    val shipmentType: Any? = null,

    @field:SerializedName("keterangan_delegasi")
    val keteranganDelegasi:String?=null,

    @field:SerializedName("driver_name")
    val driverName:String?=null,

    @field:SerializedName("airport_code")
    val airportCode: String?=null
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

data class HouseBelumTibaItem(

    @field:SerializedName("pick_up_office")
    val pickUpOffice: Boolean? = null,

    @field:SerializedName("customer_append")
    val customerAppend: CustomerAppend? = null,

    @field:SerializedName("tiba_di_customer")
    val tibaDiCustomer: Boolean? = null,

    @field:SerializedName("charge_type")
    val chargeType: String? = null,

    @field:SerializedName("po_house_number")
    val poHouseNumber: String? = null,

    @field:SerializedName("uid_airport")
    val uidAirport: String? = null,

    @field:SerializedName("taxes")
    val taxes: Boolean? = null,

    @field:SerializedName("delivery_estimation")
    val deliveryEstimation: String? = null,

    @field:SerializedName("airport_append")
    val airportAppend: AirportAppend? = null,

    @field:SerializedName("comodity_name_append")
    val comodityNameAppend: ComodityNameAppend? = null,

    @field:SerializedName("alias_address")
    val aliasAddress: Any? = null,

    @field:SerializedName("uid_category")
    val uidCategory: String? = null,

    @field:SerializedName("collie_deal")
    val collieDeal: Int? = null,

    @field:SerializedName("charge_all")
    val chargeAll: Boolean? = null,

    @field:SerializedName("sampai_maskapai")
    val sampaiMaskapai: Boolean? = null,

    @field:SerializedName("invoice_locked")
    val invoiceLocked: Boolean? = null,

    @field:SerializedName("uid_comodity")
    val uidComodity: String? = null,

    @field:SerializedName("tiba_di_kantor")
    val tibaDiKantor: Boolean? = null,

    @field:SerializedName("mpo_append")
    val mpoAppend: MpoAppend? = null,

    @field:SerializedName("marketing_append")
    val marketingAppend: MarketingAppend? = null,

    @field:SerializedName("registred_at")
    val registredAt: Int? = null,

    @field:SerializedName("uid_master_po")
    val uidMasterPo: String? = null,

    @field:SerializedName("airport_code")
    val airportCode: String? = null,

    @field:SerializedName("uid_delivery")
    val uidDelivery: String? = null,

    @field:SerializedName("id_unit")
    val idUnit: String? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("address_destiny")
    val addressDestiny: String? = null,

    @field:SerializedName("comodity_name")
    val comodityName: String? = null,

    @field:SerializedName("marketing_name")
    val marketingName: String? = null,

    @field:SerializedName("dijemput_ke_customer")
    val dijemputKeCustomer: Boolean? = null,

    @field:SerializedName("quantity_est")
    val quantityEst: String? = null,

    @field:SerializedName("urutan_invoice")
    val urutanInvoice: Int? = null,

    @field:SerializedName("invoice_status")
    val invoiceStatus: Boolean? = null,

    @field:SerializedName("make_invoice")
    val makeInvoice: Boolean? = null,

    @field:SerializedName("uid_parrent")
    val uidParrent: Any? = null,

    @field:SerializedName("pickup_estimation")
    val pickupEstimation: String? = null,

    @field:SerializedName("lock_date")
    val lockDate: Any? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("mpo_name")
    val mpoName: String? = null,

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("tanggal_antar_maskapai")
    val tanggalAntarMaskapai: Any? = null,

    @field:SerializedName("is_deleted")
    val isDeleted: Boolean? = null,

    @field:SerializedName("collie_est")
    val collieEst: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("uid_customer")
    val uidCustomer: String? = null,

    @field:SerializedName("receiver_name")
    val receiverName: String? = null,

    @field:SerializedName("lock_date_unparsed")
    val lockDateUnparsed: Any? = null,

    @field:SerializedName("siap_antar")
    val siapAntar: Boolean? = null,

    @field:SerializedName("uid_pegawai")
    val uidPegawai: String? = null,

    @field:SerializedName("cost")
    val cost: String? = null,

    @field:SerializedName("invoice_number_tax")
    val invoiceNumberTax: String? = null,

    @field:SerializedName("otw_maskapai")
    val otwMaskapai: Boolean? = null,

    @field:SerializedName("alias_name")
    val aliasName: Any? = null,

    @field:SerializedName("quantity_deal")
    val quantityDeal: String? = null,

    @field:SerializedName("information")
    val information: String? = null,

    @field:SerializedName("customer_name")
    val customerName: String? = null,

    @field:SerializedName("invoice_number_notax")
    val invoiceNumberNotax: String? = null
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

data class MpoAppend(

    @field:SerializedName("invoice_number_notaxes")
    val invoiceNumberNotaxes: Any? = null,

    @field:SerializedName("jangka_kredit")
    val jangkaKredit: Any? = null,

    @field:SerializedName("shipper_laut_append")
    val shipperLautAppend: Any? = null,

    @field:SerializedName("uid_airport")
    val uidAirport: String? = null,

    @field:SerializedName("taxes")
    val taxes: Any? = null,

    @field:SerializedName("master_link_to")
    val masterLinkTo: Any? = null,

    @field:SerializedName("cost_total")
    val costTotal: Int? = null,

    @field:SerializedName("inv_detail_append")
    val invDetailAppend: InvDetailAppend? = null,

    @field:SerializedName("price")
    val price: Int? = null,

    @field:SerializedName("container_status")
    val containerStatus: Boolean? = null,

    @field:SerializedName("notify_laut")
    val notifyLaut: Any? = null,

    @field:SerializedName("customer_laut_name")
    val customerLautName: String? = null,

    @field:SerializedName("payment")
    val payment: String? = null,

    @field:SerializedName("uid_category")
    val uidCategory: Int? = null,

    @field:SerializedName("expedisi")
    val expedisi: Any? = null,

    @field:SerializedName("biaya_import")
    val biayaImport: Any? = null,

    @field:SerializedName("registred_at")
    val registredAt: Int? = null,

    @field:SerializedName("consignee")
    val consignee: String? = null,

    @field:SerializedName("bl_number")
    val blNumber: Any? = null,

    @field:SerializedName("asal_import")
    val asalImport: Any? = null,

    @field:SerializedName("vessel_name")
    val vesselName: Any? = null,

    @field:SerializedName("nomor_faktur")
    val nomorFaktur: Any? = null,

    @field:SerializedName("charge_price")
    val chargePrice: Any? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("mbl_number")
    val mblNumber: Any? = null,

    @field:SerializedName("etd_date")
    val etdDate: Any? = null,

    @field:SerializedName("weight_lini2")
    val weightLini2: Any? = null,

    @field:SerializedName("weight_lini1")
    val weightLini1: Any? = null,

    @field:SerializedName("customer_import")
    val customerImport: Any? = null,

    @field:SerializedName("dikirim_ke_expedisi")
    val dikirimKeExpedisi: Any? = null,

    @field:SerializedName("receiver_import_udara")
    val receiverImportUdara: Any? = null,

    @field:SerializedName("airport_name")
    val airportName: String? = null,

    @field:SerializedName("contents_description")
    val contentsDescription: Any? = null,

    @field:SerializedName("marketing_name")
    val marketingName: String? = null,

    @field:SerializedName("laut_tax_total")
    val lautTaxTotal: Int? = null,

    @field:SerializedName("exrate")
    val exrate: Any? = null,

    @field:SerializedName("shipper_append")
    val shipperAppend: ShipperAppend? = null,

    @field:SerializedName("container_completed")
    val containerCompleted: Boolean? = null,

    @field:SerializedName("activity_time_diff_for_humans")
    val activityTimeDiffForHumans: String? = null,

    @field:SerializedName("suplier_expedisi")
    val suplierExpedisi: Any? = null,

    @field:SerializedName("temp_required")
    val tempRequired: String? = null,

    @field:SerializedName("shipping_type")
    val shippingType: Any? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("penjualan_udara_import_tax")
    val penjualanUdaraImportTax: Int? = null,

    @field:SerializedName("city_code")
    val cityCode: String? = null,

    @field:SerializedName("address_destination_laut")
    val addressDestinationLaut: Any? = null,

    @field:SerializedName("notify")
    val notify: String? = null,

    @field:SerializedName("uid")
    val uid: String? = null,

    @field:SerializedName("tanggal_antar_maskapai")
    val tanggalAntarMaskapai: Any? = null,

    @field:SerializedName("invoice_number_taxes")
    val invoiceNumberTaxes: Any? = null,

    @field:SerializedName("container_total_cost_notaxes")
    val containerTotalCostNotaxes: Int? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("closing_time")
    val closingTime: Any? = null,

    @field:SerializedName("tanggal_expedisi")
    val tanggalExpedisi: Any? = null,

    @field:SerializedName("smu")
    val smu: Any? = null,

    @field:SerializedName("do_number")
    val doNumber: Any? = null,

    @field:SerializedName("shipper_laut_name")
    val shipperLautName: String? = null,

    @field:SerializedName("container_vgm")
    val containerVgm: Int? = null,

    @field:SerializedName("laut_fee_total_cost_withtaxes")
    val lautFeeTotalCostWithtaxes: Int? = null,

    @field:SerializedName("customer_laut_append")
    val customerLautAppend: Any? = null,

    @field:SerializedName("consignee_laut")
    val consigneeLaut: Any? = null,

    @field:SerializedName("linked")
    val linked: Boolean? = null,

    @field:SerializedName("container_gross")
    val containerGross: Int? = null,

    @field:SerializedName("no_expedisi")
    val noExpedisi: Any? = null,

    @field:SerializedName("agency")
    val agency: Any? = null,

    @field:SerializedName("collie_lini2")
    val collieLini2: Any? = null,

    @field:SerializedName("kota_assal_append")
    val kotaAssalAppend: Any? = null,

    @field:SerializedName("collie_lini1")
    val collieLini1: Any? = null,

    @field:SerializedName("pickup")
    val pickup: Int? = null,

    @field:SerializedName("comodity_append")
    val comodityAppend: ComodityAppend? = null,

    @field:SerializedName("is_delete")
    val isDelete: Boolean? = null,

    @field:SerializedName("uid_supir")
    val uidSupir: Any? = null,

    @field:SerializedName("if_one_po_house")
    val ifOnePoHouse: String? = null,

    @field:SerializedName("project_number")
    val projectNumber: Any? = null,

    @field:SerializedName("laut_payment_total_withtaxes")
    val lautPaymentTotalWithtaxes: Int? = null,

    @field:SerializedName("information")
    val information: Any? = null,

    @field:SerializedName("no_po")
    val noPo: Any? = null,

    @field:SerializedName("shipper")
    val shipper: String? = null,

    @field:SerializedName("container_total_cost_penjualan_notaxes")
    val containerTotalCostPenjualanNotaxes: Int? = null,

    @field:SerializedName("container_total_cost_penjualan_withtaxes")
    val containerTotalCostPenjualanWithtaxes: Int? = null,

    @field:SerializedName("uid_employee")
    val uidEmployee: String? = null,

    @field:SerializedName("uid_pegawai_lapangan")
    val uidPegawaiLapangan: Any? = null,

    @field:SerializedName("shipper_laut_address")
    val shipperLautAddress: String? = null,

    @field:SerializedName("airport_append")
    val airportAppend: AirportAppend? = null,

    @field:SerializedName("penjualan_udara_import_notax")
    val penjualanUdaraImportNotax: Int? = null,

    @field:SerializedName("laut_payment_total_notaxes")
    val lautPaymentTotalNotaxes: Int? = null,

    @field:SerializedName("cost_self")
    val costSelf: Int? = null,

    @field:SerializedName("volume_lini1")
    val volumeLini1: Any? = null,

    @field:SerializedName("customer_import_append")
    val customerImportAppend: Any? = null,

    @field:SerializedName("port_load")
    val portLoad: Any? = null,

    @field:SerializedName("payment_method")
    val paymentMethod: String? = null,

    @field:SerializedName("invoice_locked")
    val invoiceLocked: Boolean? = null,

    @field:SerializedName("keterangan_pembelian")
    val keteranganPembelian: Any? = null,

    @field:SerializedName("seal_number")
    val sealNumber: Any? = null,

    @field:SerializedName("uid_comodity")
    val uidComodity: String? = null,

    @field:SerializedName("marketing_append")
    val marketingAppend: MarketingAppend? = null,

    @field:SerializedName("customer_laut")
    val customerLaut: Any? = null,

    @field:SerializedName("tanggal_pembelian")
    val tanggalPembelian: Any? = null,

    @field:SerializedName("peb_number")
    val pebNumber: Any? = null,

    @field:SerializedName("airport_code")
    val airportCode: String? = null,

    @field:SerializedName("id_unit")
    val idUnit: Int? = null,

    @field:SerializedName("si_status")
    val siStatus: Boolean? = null,

    @field:SerializedName("lc_number")
    val lcNumber: Any? = null,

    @field:SerializedName("comodity_name")
    val comodityName: String? = null,

    @field:SerializedName("port_destiny")
    val portDestiny: Any? = null,

    @field:SerializedName("unit_name")
    val unitName: String? = null,

    @field:SerializedName("reason_action")
    val reasonAction: List<Any?>? = null,

    @field:SerializedName("payment_append")
    val paymentAppend: PaymentAppend? = null,

    @field:SerializedName("laut_payment_total")
    val lautPaymentTotal: Int? = null,

    @field:SerializedName("quantity_act")
    val quantityAct: Any? = null,

    @field:SerializedName("booking_laut_detail")
    val bookingLautDetail: Any? = null,

    @field:SerializedName("laut_fee_total_cost_notaxes")
    val lautFeeTotalCostNotaxes: Int? = null,

    @field:SerializedName("unit_append")
    val unitAppend: UnitAppend? = null,

    @field:SerializedName("child_status")
    val childStatus: Boolean? = null,

    @field:SerializedName("shipper_laut_detail")
    val shipperLautDetail: Any? = null,

    @field:SerializedName("quantity_est")
    val quantityEst: String? = null,

    @field:SerializedName("shipper_name")
    val shipperName: String? = null,

    @field:SerializedName("tanggal_tiba_expedisi")
    val tanggalTibaExpedisi: Any? = null,

    @field:SerializedName("laut_sub_total_cost_withtaxes")
    val lautSubTotalCostWithtaxes: Int? = null,

    @field:SerializedName("invoice_status")
    val invoiceStatus: Any? = null,

    @field:SerializedName("collie_act")
    val collieAct: Any? = null,

    @field:SerializedName("dropto_append")
    val droptoAppend: DroptoAppend? = null,

    @field:SerializedName("import")
    val jsonMemberImport: Boolean? = null,

    @field:SerializedName("lock_date")
    val lockDate: Any? = null,

    @field:SerializedName("marketing_import_udara")
    val marketingImportUdara: Any? = null,

    @field:SerializedName("po_house_append")
    val poHouseAppend: List<PoHouseAppendItem?>? = null,

    @field:SerializedName("quantity_total")
    val quantityTotal: Int? = null,

    @field:SerializedName("collie_est")
    val collieEst: Int? = null,

    @field:SerializedName("collie_total")
    val collieTotal: Int? = null,

    @field:SerializedName("total_pembelian_laut_fee")
    val totalPembelianLautFee: Int? = null,

    @field:SerializedName("tanggal_sampai_maskapai")
    val tanggalSampaiMaskapai: Any? = null,

    @field:SerializedName("country_name")
    val countryName: String? = null,

    @field:SerializedName("lock_date_unparsed")
    val lockDateUnparsed: Any? = null,

    @field:SerializedName("new_container_total_cost_pembelian")
    val newContainerTotalCostPembelian: Int? = null,

    @field:SerializedName("suhu")
    val suhu: Boolean? = null,

    @field:SerializedName("container_total_cost_withtaxes")
    val containerTotalCostWithtaxes: Int? = null,

    @field:SerializedName("shipper_laut")
    val shipperLaut: Any? = null,

    @field:SerializedName("flight_number")
    val flightNumber: Any? = null,

    @field:SerializedName("pickup_name")
    val pickupName: String? = null,

    @field:SerializedName("maskapai")
    val maskapai: Any? = null,

    @field:SerializedName("po_master_number")
    val poMasterNumber: String? = null,

    @field:SerializedName("container_total_cost_penjualan")
    val containerTotalCostPenjualan: Int? = null,

    @field:SerializedName("booking_laut")
    val bookingLaut: Any? = null,

    @field:SerializedName("container_total_cost_pembelian")
    val containerTotalCostPembelian: Int? = null,

    @field:SerializedName("kota_asal")
    val kotaAsal: String? = null,

    @field:SerializedName("special_instruction")
    val specialInstruction: String? = null,

    @field:SerializedName("total_pembelian_laut")
    val totalPembelianLaut: Int? = null,

    @field:SerializedName("customer_import_name")
    val customerImportName: String? = null,

    @field:SerializedName("new_container_total_cost_penjualan")
    val newContainerTotalCostPenjualan: Int? = null,

    @field:SerializedName("po_house_amount")
    val poHouseAmount: Int? = null,

    @field:SerializedName("shipment_type")
    val shipmentType: Any? = null
)

data class ShipperAppend(

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

data class PickupAppend(

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

data class PoHouseAppendItem(

    @field:SerializedName("pick_up_office")
    val pickUpOffice: Boolean? = null,

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

    @field:SerializedName("invoice_locked")
    val invoiceLocked: Boolean? = null,

    @field:SerializedName("port_load_name")
    val portLoadName: String? = null,

    @field:SerializedName("cost_if_both")
    val costIfBoth: Any? = null,

    @field:SerializedName("uid_comodity")
    val uidComodity: String? = null,

    @field:SerializedName("marketing_append")
    val marketingAppend: MarketingAppend? = null,

    @field:SerializedName("registred_at")
    val registredAt: Int? = null,

    @field:SerializedName("uid_master_po")
    val uidMasterPo: String? = null,

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
    val totalPenjualanNotax: Int? = null
)
