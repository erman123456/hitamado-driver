package pt.lunata.hitamado.ui.delegasi.search.deliverairline

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity

class SearchDelegasiDeliverAirlineViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemDelegasiDeliverAirline(context: Context): LiveData<List<SiapAntarEntity>> =
        sjtRepository.getResponseDelegasiDeliverAirline(context)
}