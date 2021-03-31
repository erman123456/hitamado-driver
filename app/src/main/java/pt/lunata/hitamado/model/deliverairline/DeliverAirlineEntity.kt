package pt.lunata.hitamado.model.deliverairline

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DeliverAirlineEntity(
    val uid: String?,
    val po_master_number: String?,
    val driverName:String?,
    val dateDelivery:String?,
    val airportCode:String?,
    val smu:String?,
    val quantity_est: String?,
    val collie_est: String?
) : Parcelable