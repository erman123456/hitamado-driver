package pt.lunata.hitamado.ui.delegasi.search.office

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.newpo.NewpoEntity

class SearchDelegasiOfficeViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemDelegasiOffice(context: Context): LiveData<List<NewpoEntity>> =
        sjtRepository.getResponseDelegasiOffice(context)
}