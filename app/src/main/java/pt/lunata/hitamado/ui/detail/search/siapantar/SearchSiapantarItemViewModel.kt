package pt.lunata.hitamado.ui.detail.search.siapantar

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity

class SearchSiapantarItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemSiapAntar(context: Context): LiveData<List<SiapAntarEntity>> =
        sjtRepository.getResponseSiapAntar(context)

    fun getItemSiapAntarDriver(context: Context): LiveData<List<SiapAntarEntity>> =
        sjtRepository.getResponseSiapAntarDriver(context)
}