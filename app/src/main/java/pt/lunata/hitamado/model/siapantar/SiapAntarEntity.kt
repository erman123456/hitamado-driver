package pt.lunata.hitamado.model.siapantar

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SiapAntarEntity(
    val uid: String?,
    val po_master_number: String?,
    val siap_antar: Boolean?,
    val driverName:String?,
    val keteranganDelegasi:String?,
    val dateDelivery:String?,
    val airportCode:String?,
    val smu:String?,
    val itemsPo:List<ItemHouseBelumTibaEntity>?,
    val itemsAllHouse:List<ItemAllHouseEntity>?
) : Parcelable

@Parcelize
data class ItemHouseBelumTibaEntity(
    val uid: String? = null,
    val po_house_number: String? = null
):Parcelable

@Parcelize
data class ItemAllHouseEntity(
    val uid: String? = null,
    val po_house_number: String? = null
):Parcelable