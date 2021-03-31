package pt.lunata.hitamado.ui.detail.pickup.driver

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.pickup.ConfirmEntity
import pt.lunata.hitamado.model.pickup.ContinuePickupEntity

class DetailStatusPickupDriverViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun postConfirmPickup(context: Context, poHouseId: String?): LiveData<ConfirmEntity> =
        sjtRepository.getResponseConfirm(context, poHouseId)

    fun postArrivedToCustomer(context: Context, poHouseId: String?): LiveData<ConfirmEntity> =
        sjtRepository.postResponseArrivedToCustomer(context, poHouseId)

    fun postContinuePickup(context: Context, poHouseId: String?): LiveData<ContinuePickupEntity> =
        sjtRepository.postResponseContinuePickup(context, poHouseId)

    fun postDelegasiPickup(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> =
        sjtRepository.postResponseDelegasiPickup(context, poHouseId, driverUid, description)
}