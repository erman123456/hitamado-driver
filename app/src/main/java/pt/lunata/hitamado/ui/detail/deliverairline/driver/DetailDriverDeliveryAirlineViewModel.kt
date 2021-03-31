package pt.lunata.hitamado.ui.detail.deliverairline.driver

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.deliverairline.ContinueDeliverAirlineEntity

class DetailDriverDeliveryAirlineViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    /*fun postArrivedDeliverAirline(context: Context,poHouseId: String?):LiveData<ConfirmDeliverAirlineEntity> = sjtRepository.postArrivedDeliverAirline(context, poHouseId)*/
    fun postArrivedDeliverAirline(
        context: Context,
        mpoId: String?
    ): LiveData<ContinueDeliverAirlineEntity> =
        sjtRepository.postResponseContinueDeliverAirline(context, mpoId)

    fun postDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> =
        sjtRepository.postResponseDelegasiDeliverAirline(context, poHouseId, driverUid, description)
}