package pt.lunata.hitamado.ui.detail.search.airline

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.airline.AirlineEntity
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.model.airline.operational.TotalEntity

class SearchAirlineItemViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getItemAirline(context: Context): LiveData<List<AirlineEntity>> =
        sjtRepository.getResponseAirline(context)

    fun getItemAirlineOperational(context: Context): LiveData<PagedList<DataItem>> =
        sjtRepository.getResponseOperationalAirline(context)

    fun getSearchItemAirline(context: Context,mpoId:String):LiveData<DataItem> = sjtRepository.getResponseSearchAirline(context, mpoId)

    fun getItemTotal(context: Context):LiveData<TotalEntity> = sjtRepository.getResponseTotalItemAirline(context)
}