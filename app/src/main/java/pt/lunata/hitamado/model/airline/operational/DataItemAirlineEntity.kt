package pt.lunata.hitamado.model.airline.operational

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItemAirlineEntity(
    val uid: String? = null,
    val poMasterNumber: String? = null
) : Parcelable