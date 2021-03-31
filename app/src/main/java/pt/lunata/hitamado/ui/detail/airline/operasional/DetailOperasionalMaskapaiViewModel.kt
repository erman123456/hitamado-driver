package pt.lunata.hitamado.ui.detail.airline.operasional

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.airline.operational.ResponseSentOperational

class DetailOperasionalMaskapaiViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun postCompletedAirline(
        context: Context,
        uid: String,
        weightLini: String,
        collieLini: String,
        weightLini2: String,
        collieLini2: String
    ): LiveData<ResponseSentOperational> =
        sjtRepository.postCompletedAirline(context, uid, weightLini, collieLini,weightLini2,collieLini2)

    fun postCompletedAirline2(
        context: Context,
        uid: String,
        weightLini: String,
        collieLini: String
    ): LiveData<ResponseSentOperational> =
        sjtRepository.postCompletedAirline2(context, uid, weightLini, collieLini)
}