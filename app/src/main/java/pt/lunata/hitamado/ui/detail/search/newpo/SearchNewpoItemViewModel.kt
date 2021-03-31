package pt.lunata.hitamado.ui.detail.search.newpo

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.newpo.NewpoEntity

class SearchNewpoItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemsNewpo(context: Context): LiveData<List<NewpoEntity>> =
        sjtRepository.getResponseNewpo(context)
}