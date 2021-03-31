package pt.lunata.hitamado.model.office

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OfficeEntity(
    val uid: String?,
    val po_house_number: String?,
    val mpo_number: String?,
    val status: Boolean?,
    val customer_name: String?,
    val airport_code: String?,
    val customer_alamt: String?,
    val no_telepon: String?,
    val comodity_name: String?,
    val marketing_name: String?,
    val quantity_est: String?,
    val collie_est: String?,
    val tiba_office: String?,
    val driverName: String?
) : Parcelable