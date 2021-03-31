package pt.lunata.hitamado.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import pt.lunata.hitamado.MainActivity
import pt.lunata.hitamado.R
import com.google.firebase.iid.FirebaseInstanceId
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val preference = this.getSharedPreferences("APP", Context.MODE_PRIVATE)
        val cek = preference.getString("SESSION", null)
        if (cek != "FAILED" && cek != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_login.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_login -> {
                progressbar.visibility = View.VISIBLE

                GlobalScope.launch(Dispatchers.IO) {
                    var deviceId = ""
                    try {
                        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener { instanceIdResult ->
                            deviceId = instanceIdResult.token
                            Log.d("tokenFirebase", "Refreshed token: $deviceId")
                        }
                        delay(1000)
                        withContext(Dispatchers.Main) {
                            viewModel.doLogin(
                                edt_email.text.toString(),
                                edt_password.text.toString(),
                                deviceId
                            ).observe(this@LoginActivity,
                                Observer { response ->
                                    val preference = this@LoginActivity.getSharedPreferences(
                                        "APP",
                                        Context.MODE_PRIVATE
                                    )
                                    preference.edit().putString("FIREBASE",deviceId).apply()
                                    if (response.token != null) {
                                        progressbar.visibility = View.GONE
                                        preference.edit().putString("TOKEN", response.token).apply()
                                        preference.edit().putString("SESSION", "SUCCESS").apply()
                                        preference.edit().putString("UserId", response.uid).apply()
                                        preference.edit().putString("Jabatan", response.jabatan)
                                            .apply()
                                        val intent =
                                            Intent(this@LoginActivity, MainActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        progressbar.visibility = View.GONE
                                        Toast.makeText(
                                            this@LoginActivity,
                                            "Gagal Login. Email / Password Salah!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        preference.edit().putString("SESSION", "FAILED").apply()
                                    }
                                })
                        }
                    } catch (e: Exception) {
                        Log.d("LOG_ASYNC", e.message.toString())
                    }
                }


            }
        }
    }
}