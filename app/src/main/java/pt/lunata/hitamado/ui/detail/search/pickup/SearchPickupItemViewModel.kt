package pt.lunata.hitamado.ui.detail.search.pickup

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.pickup.PickupEntity

class SearchPickupItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemPickup(context: Context): LiveData<List<PickupEntity>> =
        sjtRepository.getResponsePickup(context)

    fun getItemDriverPickup(context: Context): LiveData<List<PickupEntity>> =
        sjtRepository.getResponseDriverPickup(context)
}