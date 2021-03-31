package pt.lunata.hitamado.ui.detail.siapantar.driver

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.siapantar.ConfirmSiapAntarEntity
import pt.lunata.hitamado.model.siapantar.ContinueSiapAntarEntity

class DetailSiapAntarDriverViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun postArrivedSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmSiapAntarEntity> =
        sjtRepository.postResponseArrivedSiapAntar(context, poHouseId)

    fun postContinueSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinueSiapAntarEntity> =
        sjtRepository.postResponseContinueSiapAntar(context, poHouseId)

    fun postDelegasiSiapAntar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> =
        sjtRepository.postResponseDelegasiSiapAntar(context, poHouseId, driverUid, description)
}