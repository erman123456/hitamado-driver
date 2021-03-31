package pt.lunata.hitamado.ui.delegasi.search.pickup

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.newpo.NewpoEntity

class SearchDelegasiPickupViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemDelegasiPickup(context: Context): LiveData<List<NewpoEntity>> =
        sjtRepository.getResponseDelegasiPickup(context)
}