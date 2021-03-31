package pt.lunata.hitamado.model.newpo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewpoEntity(
    val uid: String?,
    val po_house_number: String?,
    val mpo_number: String?,
    val customer_name: String?,
    val airport_code: String?,
    val customer_alamt: String?,
    val no_telepon: String?,
    val comodity_name: String?,
    val marketing_name: String?,
    val quantity_est: String?,
    val collie_est: String?,
    val driverName:String?,
    val keteranganDelegasi:String?
) : Parcelable