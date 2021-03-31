package pt.lunata.hitamado.ui.detail.siapantar.headdriver

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.driver.entity.DriverEntity
import pt.lunata.hitamado.model.siapantar.ResponsePostSiapantar

class DetailSiapAntarHeadViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getListDriver(context: Context): LiveData<List<DriverEntity>> =
        sjtRepository.getDataDriver(context)

    fun postSiapAntar(
        context: Context,
        mpoId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<ResponsePostSiapantar> =
        sjtRepository.getResponsePostSiapantar(context, mpoId, driverUid, description)
}