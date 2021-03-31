package pt.lunata.hitamado.model.airline.operational

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataItem(

	@field:SerializedName("uid")
	val uid: String? = null,

	@field:SerializedName("airport_name")
	val maskapai: String? = null,

	@field:SerializedName("po_master_number")
	val poMasterNumber: String? = null,

	@field:SerializedName("quantity_est")
	val quantityEst:String?=null,

	@field:SerializedName("collie_est")
	val collieEst:String?=null,

	@field:SerializedName("smu")
	val smu:String?=null
) : Parcelable