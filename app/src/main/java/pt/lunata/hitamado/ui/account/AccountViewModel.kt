package pt.lunata.hitamado.ui.account

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.driver.entity.DriverEntity
import pt.lunata.hitamado.model.logout.ResponseLogout

class AccountViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun getDataUser(context: Context): LiveData<DriverEntity> = sjtRepository.getDataUser(context)
    fun doLogout(context: Context):LiveData<ResponseLogout> = sjtRepository.getResponseLogout(context)
}