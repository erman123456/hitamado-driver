package pt.lunata.hitamado.ui.delegasi

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.newpo.NewpoEntity
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity

class DelegasiViewModel@ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemDelegasiPickup(context: Context): LiveData<List<NewpoEntity>> =
        sjtRepository.getResponseDelegasiPickup(context)

    fun getItemDelegasiOffice(context: Context): LiveData<List<NewpoEntity>> =
        sjtRepository.getResponseDelegasiOffice(context)

    fun getItemDelegasiDeliverAirline(context: Context): LiveData<List<SiapAntarEntity>> =
        sjtRepository.getResponseDelegasiDeliverAirline(context)
}