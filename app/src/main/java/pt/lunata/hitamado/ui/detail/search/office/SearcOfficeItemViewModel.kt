package pt.lunata.hitamado.ui.detail.search.office

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.office.OfficeEntity

class SearcOfficeItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemOffice(context: Context): LiveData<List<OfficeEntity>> =
        sjtRepository.getResponseOffice(context)

    fun getItemDriverOffice(context: Context): LiveData<List<OfficeEntity>> =
        sjtRepository.getResponseOfficeDriver(context)
}