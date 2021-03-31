package pt.lunata.hitamado.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pt.lunata.hitamado.data.SjtRepository
import pt.lunata.hitamado.model.login.LoginEntity

class LoginViewModel @ViewModelInject constructor(private val sjtRepository: SjtRepository) :
    ViewModel() {
    fun doLogin(email: String, password: String, deviceId: String): LiveData<LoginEntity> =
        sjtRepository.getResponseLogin(email, password, deviceId)
}