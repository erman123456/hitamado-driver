package pt.lunata.hitamado.ui.detail.office.driver

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.office.ConfirmEntity
import pt.lunata.hitamado.model.office.ContinueOfficeEntity

class DetailDriverOfficeViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun postArrivedOffice(context: Context, poHouseId: String?): LiveData<ConfirmEntity> =
        sjtRepository.postArrivedAtOffice(context, poHouseId)

    fun postContinueOffice(context: Context, poHouseId: String?): LiveData<ContinueOfficeEntity> =
        sjtRepository.postResponseContinueOffice(context, poHouseId)

    fun postDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> =
        sjtRepository.postResponseDelegasiOffice(context, poHouseId, driverUid, description)
}