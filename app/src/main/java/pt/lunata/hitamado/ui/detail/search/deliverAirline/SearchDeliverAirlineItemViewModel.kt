package pt.lunata.hitamado.ui.detail.search.deliverAirline

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity

class SearchDeliverAirlineItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemDeliverAirline(context: Context): LiveData<List<DeliverAirlineEntity>> =
        sjtRepository.getResponseDeliverAirline(context)

    fun getItemDeliverAirlineDriver(context: Context): LiveData<List<DeliverAirlineEntity>> =
        sjtRepository.getResponseDeliverAirlineDriver(context)
}