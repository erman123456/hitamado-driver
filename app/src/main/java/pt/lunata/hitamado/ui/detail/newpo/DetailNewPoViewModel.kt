package pt.lunata.hitamado.ui.detail.newpo

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.driver.entity.DriverEntity
import pt.lunata.hitamado.model.newpo.NewpoPostEntity

class DetailNewPoViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getListDriver(context: Context): LiveData<List<DriverEntity>> =
        sjtRepository.getDataDriver(context)

    fun postNewpo(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> =
        sjtRepository.getResponsePostNewPo(context, poHouseId, driverUid, description)

    fun postDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> =
        sjtRepository.getResponsePostDelegasiOffice(context, poHouseId, driverUid, description)

    fun postDelegasiSiapantar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> =
        sjtRepository.getResponsePostDelegasiSiapantar(context, poHouseId, driverUid, description)

    fun postDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> = sjtRepository.getResponsePostDelegasiDeliverAirline(
        context,
        poHouseId,
        driverUid,
        description
    )
}