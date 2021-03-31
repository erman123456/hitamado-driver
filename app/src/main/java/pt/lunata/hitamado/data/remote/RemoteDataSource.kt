package pt.lunata.hitamado.data.remote

import android.content.Context
import android.util.Log
import android.widget.Toast
import pt.lunata.hitamado.data.api.ApiConfig
import pt.lunata.hitamado.model.airline.ResponseAirline
import pt.lunata.hitamado.model.airline.operational.Master
import pt.lunata.hitamado.model.airline.operational.ResponseAirlineOperational
import pt.lunata.hitamado.model.airline.operational.ResponseSentOperational
import pt.lunata.hitamado.model.airline.search.ResponseSearchAirline
import pt.lunata.hitamado.model.delegasi.ResponseDelegasi
import pt.lunata.hitamado.model.deliverairline.ResponseConfirmDeliverAirline
import pt.lunata.hitamado.model.deliverairline.ResponseContinueDeliverAirline
import pt.lunata.hitamado.model.deliverairline.ResponseDeliverAirline
import pt.lunata.hitamado.model.driver.response.ResponseDataDriver
import pt.lunata.hitamado.model.driver.response.ResponseSpecificDataUser
import pt.lunata.hitamado.model.login.ResponseLogin
import pt.lunata.hitamado.model.logout.ResponseLogout
import pt.lunata.hitamado.model.newpo.ResponseNewPo
import pt.lunata.hitamado.model.newpo.ResponsePostNewpo
import pt.lunata.hitamado.model.office.ResponseConfirmOffice
import pt.lunata.hitamado.model.office.ResponseContinueOffice
import pt.lunata.hitamado.model.office.ResponseOffice
import pt.lunata.hitamado.model.pickup.ResponseConfirmPickup
import pt.lunata.hitamado.model.pickup.ResponseContinuePickup
import pt.lunata.hitamado.model.pickup.ResponsePickup
import pt.lunata.hitamado.model.siapantar.ResponseConfirmSiapantar
import pt.lunata.hitamado.model.siapantar.ResponseContinueSiapAntar
import pt.lunata.hitamado.model.siapantar.ResponsePostSiapantar
import pt.lunata.hitamado.model.siapantar.ResponseSiapAntar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class RemoteDataSource {

    fun doLogin(
        email: String,
        password: String,
        deviceId: String,
        callback: LoadResponseLoginCallback
    ) {
        val clientLogin = ApiConfig.getApiService().loginUser(email, password, deviceId)
        clientLogin.enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                callback.onGetResponseLogin(response.body())
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.d("fail", t.message.toString())
            }

        })
    }
    fun doLogout(context: Context,callback:LoadResponseLogoutCallback){
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        val firebase=preference.getString("FIREBASE",null)
        if (token != null){
            token = "Bearer" + " " + token
            val clientLogout = ApiConfig.getApiService().logoutUser(token,firebase)
            clientLogout.enqueue(object :Callback<ResponseLogout>{
                override fun onResponse(
                    call: Call<ResponseLogout>,
                    response: Response<ResponseLogout>
                ) {
                    callback.onGetResponseLogout(response.body())
                }

                override fun onFailure(call: Call<ResponseLogout>, t: Throwable) {
                    Toast.makeText(context,"Gagal terhubung ke Server..",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
    fun postNewPo(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponsePostNewpoCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPostNewpo =
                ApiConfig.getApiService().postNewPo(token, poHouseId, driverUid, description)
            clientPostNewpo.enqueue(object : Callback<ResponsePostNewpo> {
                override fun onResponse(
                    call: Call<ResponsePostNewpo>,
                    response: Response<ResponsePostNewpo>
                ) {
                    callback.onGetResponsePostNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponsePostNewpo>, t: Throwable) {
                    Log.d("gagal2", t.message.toString())
                }

            })
        }
    }

    fun postDelegasiOfficeHead(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponsePostNewpoCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPostNewpo = ApiConfig.getApiService()
                .postOfficeDelegasiHead(token, poHouseId, driverUid, description)
            clientPostNewpo.enqueue(object : Callback<ResponsePostNewpo> {
                override fun onResponse(
                    call: Call<ResponsePostNewpo>,
                    response: Response<ResponsePostNewpo>
                ) {
                    callback.onGetResponsePostNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponsePostNewpo>, t: Throwable) {
                    Log.d("gagal2", t.message.toString())
                }

            })
        }
    }

    fun postDelegasiSiapAntarHead(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponsePostNewpoCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPostNewpo = ApiConfig.getApiService()
                .postSiapAntarDelegasiHead(token, poHouseId, driverUid, description)
            clientPostNewpo.enqueue(object : Callback<ResponsePostNewpo> {
                override fun onResponse(
                    call: Call<ResponsePostNewpo>,
                    response: Response<ResponsePostNewpo>
                ) {
                    callback.onGetResponsePostNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponsePostNewpo>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postDelegasiDeliverAirlineHead(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponsePostNewpoCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPostNewpo = ApiConfig.getApiService()
                .postDeliverAirlineDelegasiHead(token, poHouseId, driverUid, description)
            clientPostNewpo.enqueue(object : Callback<ResponsePostNewpo> {
                override fun onResponse(
                    call: Call<ResponsePostNewpo>,
                    response: Response<ResponsePostNewpo>
                ) {
                    callback.onGetResponsePostNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponsePostNewpo>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getDataNewpo(context: Context, callbak: LoadResponseNewpoCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientNewpo = ApiConfig.getApiService().getNewpoHouse(token)
            clientNewpo.enqueue(object : Callback<ResponseNewPo> {
                override fun onResponse(
                    call: Call<ResponseNewPo>,
                    response: Response<ResponseNewPo>
                ) {
                    callbak.onGetResponseNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponseNewPo>, t: Throwable) {
                    Log.d("gagal", t.message.toString())
                }
            })
        }
    }

    fun getDataDriver(context: Context, callback: LoadResponseDriverCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDriver = ApiConfig.getApiService().getDriver(token)
            clientDriver.enqueue(object : Callback<ResponseDataDriver> {
                override fun onResponse(
                    call: Call<ResponseDataDriver>,
                    response: Response<ResponseDataDriver>
                ) {
                    callback.onGetDataDriver(response.body())
                }

                override fun onFailure(call: Call<ResponseDataDriver>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getDataUser(context: Context, callback: LoadResponseUserCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        val uid = preference.getString("UserId", null)
        if (token != null && uid != null) {
            token = "Bearer" + " " + token
            val clientUser = ApiConfig.getApiService().getDataUser(token, uid)
            clientUser.enqueue(object : Callback<ResponseSpecificDataUser> {
                override fun onResponse(
                    call: Call<ResponseSpecificDataUser>,
                    response: Response<ResponseSpecificDataUser>
                ) {
                    callback.onGetDataUser(response.body())
                }

                override fun onFailure(call: Call<ResponseSpecificDataUser>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke server", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    fun getAllDataPickup(context: Context, callback: LoadResponsePickupCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPickup = ApiConfig.getApiService().getPuckupCustomer(token)
            clientPickup.enqueue(object : Callback<ResponsePickup> {
                override fun onResponse(
                    call: Call<ResponsePickup>,
                    response: Response<ResponsePickup>
                ) {
                    callback.onGetResponsePickup(response.body())
                }

                override fun onFailure(call: Call<ResponsePickup>, t: Throwable) {
                    Log.d("gagal", t.message.toString())
                }
            })
        }
    }

    fun getDataDriverPickup(context: Context, callback: LoadResponseDriverPickupCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        var uid = preference.getString("UserId", null)
        if (token != null && uid != null) {
            token = "Bearer" + " " + token
            val clientPickup = ApiConfig.getApiService().getDriverPickupCusstomer(token, uid)
            clientPickup.enqueue(object : Callback<ResponsePickup> {
                override fun onResponse(
                    call: Call<ResponsePickup>,
                    response: Response<ResponsePickup>
                ) {
                    callback.onGetResponseDriverPickup(response.body())
                }

                override fun onFailure(call: Call<ResponsePickup>, t: Throwable) {
                    Log.d("gagal", t.message.toString())
                }
            })
        }
    }

    fun getResponseConfirm(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseConfirmPickupCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientConfirmPickup = ApiConfig.getApiService().confirmPickup(token, poHouseId)
            clientConfirmPickup.enqueue(object : Callback<ResponseConfirmPickup> {
                override fun onResponse(
                    call: Call<ResponseConfirmPickup>,
                    response: Response<ResponseConfirmPickup>
                ) {
                    callback.onGetResponseConfirmPickup(response.body())
                }

                override fun onFailure(call: Call<ResponseConfirmPickup>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postConfirmArrivedcustomer(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseConfirmSentOfficeCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientConfirmPickup =
                ApiConfig.getApiService().confirmArrivedPickup(token, poHouseId)
            clientConfirmPickup.enqueue(object : Callback<ResponseConfirmPickup> {
                override fun onResponse(
                    call: Call<ResponseConfirmPickup>,
                    response: Response<ResponseConfirmPickup>
                ) {
                    callback.onGetResponseConfirmSentOffice(response.body())
                }

                override fun onFailure(call: Call<ResponseConfirmPickup>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postDelegasiPickup(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponseDelegasiCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDelegasiPickup = ApiConfig.getApiService()
                .postDelegasiPickup(token, poHouseId, driverUid, description)
            clientDelegasiPickup.enqueue(object : Callback<ResponseDelegasi> {
                override fun onResponse(
                    call: Call<ResponseDelegasi>,
                    response: Response<ResponseDelegasi>
                ) {
                    callback.onGetResponseDelegasi(response.body())
                }

                override fun onFailure(call: Call<ResponseDelegasi>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })

        }
    }

    fun getResponseOffice(context: Context, callback: LoadResponseSentToOfficeCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientOffice = ApiConfig.getApiService().getArrivedOfficeHeadDriver(token)
            clientOffice.enqueue(object : Callback<ResponseOffice> {
                override fun onResponse(
                    call: Call<ResponseOffice>,
                    response: Response<ResponseOffice>
                ) {
                    callback.onGetResponseSentToOffice(response.body())
                }

                override fun onFailure(call: Call<ResponseOffice>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getResponseOfficeDriver(context: Context, callback: LoadResponseSentToOfficeCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        var uid = preference.getString("UserId", null)
        if (token != null && uid != null) {
            token = "Bearer" + " " + token
            val clientOffice = ApiConfig.getApiService().getArrivedOfficeDriver(token, uid)
            clientOffice.enqueue(object : Callback<ResponseOffice> {
                override fun onResponse(
                    call: Call<ResponseOffice>,
                    response: Response<ResponseOffice>
                ) {
                    callback.onGetResponseSentToOffice(response.body())
                }

                override fun onFailure(call: Call<ResponseOffice>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postConfirmContinuePickup(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseContinuePickupCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientContinuePickup =
                ApiConfig.getApiService().postContinueProcessPickup(token, poHouseId)
            clientContinuePickup.enqueue(object : Callback<ResponseContinuePickup> {
                override fun onResponse(
                    call: Call<ResponseContinuePickup>,
                    response: Response<ResponseContinuePickup>
                ) {
                    Log.d("tes4", response.body()?.success.toString())
                    callback.onGetResponseContinuePickup(response.body())
                }

                override fun onFailure(call: Call<ResponseContinuePickup>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postArrivedOffice(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseConfirmArrivedOfficeCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientConfirmOffice =
                ApiConfig.getApiService().confirmArrivedOffice(token, poHouseId)
            clientConfirmOffice.enqueue(object : Callback<ResponseConfirmOffice> {
                override fun onResponse(
                    call: Call<ResponseConfirmOffice>,
                    response: Response<ResponseConfirmOffice>
                ) {
                    callback.onGetResponseArrivedOffice(response.body())
                }

                override fun onFailure(call: Call<ResponseConfirmOffice>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

    }

    fun postConfirmContinueOffice(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseContinueOfficeCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientContinueOffice =
                ApiConfig.getApiService().postContinueProcessOffice(token, poHouseId)
            clientContinueOffice.enqueue(object : Callback<ResponseContinueOffice> {
                override fun onResponse(
                    call: Call<ResponseContinueOffice>,
                    response: Response<ResponseContinueOffice>
                ) {
                    callback.onGetResponseContinueOffice(response.body())
                }

                override fun onFailure(call: Call<ResponseContinueOffice>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponseDelegasiCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDelegasiPickup = ApiConfig.getApiService()
                .postDelegasiOffice(token, poHouseId, driverUid, description)
            clientDelegasiPickup.enqueue(object : Callback<ResponseDelegasi> {
                override fun onResponse(
                    call: Call<ResponseDelegasi>,
                    response: Response<ResponseDelegasi>
                ) {
                    callback.onGetResponseDelegasi(response.body())
                }

                override fun onFailure(call: Call<ResponseDelegasi>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })

        }
    }

    fun getResponseSiapAntar(context: Context, callback: LoadResponseSiapAntarCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientSiapAntar = ApiConfig.getApiService().getSiapAntar(token)
            clientSiapAntar.enqueue(object : Callback<ResponseSiapAntar> {
                override fun onResponse(
                    call: Call<ResponseSiapAntar>,
                    response: Response<ResponseSiapAntar>
                ) {
                    callback.onGetResponseSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponseSiapAntar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getResponseSiapantarDriver(context: Context, callback: LoadResponseSiapAntarCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        var uid = preference.getString("UserId", null)
        if (token != null && uid != null) {
            token = "Bearer" + " " + token
            val clientSiapAntar = ApiConfig.getApiService().getSiapAntarDriver(token, uid)
            clientSiapAntar.enqueue(object : Callback<ResponseSiapAntar> {
                override fun onResponse(
                    call: Call<ResponseSiapAntar>,
                    response: Response<ResponseSiapAntar>
                ) {
                    callback.onGetResponseSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponseSiapAntar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }

    fun postArrivedSiapAntar(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseConfirmArrivedSiapAntarCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientConfirmSiapantar =
                ApiConfig.getApiService().confirmArrivedSiapAntar(token, poHouseId)
            clientConfirmSiapantar.enqueue(object : Callback<ResponseConfirmSiapantar> {
                override fun onResponse(
                    call: Call<ResponseConfirmSiapantar>,
                    response: Response<ResponseConfirmSiapantar>
                ) {
                    callback.onGetResponseArrivedSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponseConfirmSiapantar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

    }

    fun postConfirmContinueSiapAntar(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseContinueSiapAntarCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientContinueSiapAntar =
                ApiConfig.getApiService().postContinueProcessSiapAntar(token, poHouseId)
            clientContinueSiapAntar.enqueue(object : Callback<ResponseContinueSiapAntar> {
                override fun onResponse(
                    call: Call<ResponseContinueSiapAntar>,
                    response: Response<ResponseContinueSiapAntar>
                ) {
                    callback.onGetResponseContinueSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponseContinueSiapAntar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postSiapantar(
        context: Context,
        mpoId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponsePostSiapAntarCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPostSiapantar =
                ApiConfig.getApiService().postSiapAntar(token, mpoId, driverUid, description)
            clientPostSiapantar.enqueue(object : Callback<ResponsePostSiapantar> {
                override fun onResponse(
                    call: Call<ResponsePostSiapantar>,
                    response: Response<ResponsePostSiapantar>
                ) {
                    callback.onGetResponsePostSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponsePostSiapantar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun postDelegasiSiapAntar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponseDelegasiCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDelegasiSiapantar = ApiConfig.getApiService()
                .postDelegasiSiapantar(token, poHouseId, driverUid, description)
            clientDelegasiSiapantar.enqueue(object : Callback<ResponseDelegasi> {
                override fun onResponse(
                    call: Call<ResponseDelegasi>,
                    response: Response<ResponseDelegasi>
                ) {
                    callback.onGetResponseDelegasi(response.body())
                }

                override fun onFailure(call: Call<ResponseDelegasi>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getResponseDeliverAirline(context: Context, callback: LoadResponseDeliverAirlineCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientSiapAntar = ApiConfig.getApiService().getDeliverAirline(token)
            clientSiapAntar.enqueue(object : Callback<ResponseDeliverAirline> {
                override fun onResponse(
                    call: Call<ResponseDeliverAirline>,
                    response: Response<ResponseDeliverAirline>
                ) {
                    callback.onGetResponseDeliverAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseDeliverAirline>, t: Throwable) {
                    Log.d("cekError",t.message.toString())
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getResponseDeliverAirlineDriver(
        context: Context,
        callback: LoadResponseDeliverAirlineCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        var uid = preference.getString("UserId", null)
        if (token != null && uid != null) {
            token = "Bearer" + " " + token
            val clientSiapAntar = ApiConfig.getApiService().getDeliverAirlineDriver(token, uid)
            clientSiapAntar.enqueue(object : Callback<ResponseDeliverAirline> {
                override fun onResponse(
                    call: Call<ResponseDeliverAirline>,
                    response: Response<ResponseDeliverAirline>
                ) {
                    callback.onGetResponseDeliverAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseDeliverAirline>, t: Throwable) {
                    Log.d("cekLah", t.message.toString())
                }

            })
        }
    }

    fun postArrivedDeliverAirline(
        context: Context,
        poHouseId: String?,
        callback: LoadResponseConfirmArrivedDeliverAirlineCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientConfirmDeliverAirline =
                ApiConfig.getApiService().confirmArrivedMaskapai(token, poHouseId)
            clientConfirmDeliverAirline.enqueue(object : Callback<ResponseConfirmDeliverAirline> {
                override fun onResponse(
                    call: Call<ResponseConfirmDeliverAirline>,
                    response: Response<ResponseConfirmDeliverAirline>
                ) {
                    callback.onGetResponseArrivedDeliverAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseConfirmDeliverAirline>, t: Throwable) {
                    Log.d("cekLagi", t.message.toString())
                }

            })

        }
    }

    fun postContinueDeliverAirline(
        context: Context,
        mpoId: String?,
        callback: LoadResponseContinueDeliverAirlineCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        var uid = preference.getString("UserId", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientContinueDeliverAirline =
                ApiConfig.getApiService().postContinueArrivedMaskapai(token, uid, mpoId)
            clientContinueDeliverAirline.enqueue(object : Callback<ResponseContinueDeliverAirline> {
                override fun onResponse(
                    call: Call<ResponseContinueDeliverAirline>,
                    response: Response<ResponseContinueDeliverAirline>
                ) {
                    callback.onGetResponseContinueDeliverAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseContinueDeliverAirline>, t: Throwable) {
                    Log.d("gagalLa", t.message.toString())
                }

            })


        }
    }

    fun postDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?,
        callback: LoadResponseDelegasiCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDelegasiDeliverAirline = ApiConfig.getApiService()
                .postDelegasiDeliverAirline(token, poHouseId, driverUid, description)
            clientDelegasiDeliverAirline.enqueue(object : Callback<ResponseDelegasi> {
                override fun onResponse(
                    call: Call<ResponseDelegasi>,
                    response: Response<ResponseDelegasi>
                ) {
                    callback.onGetResponseDelegasi(response.body())
                }

                override fun onFailure(call: Call<ResponseDelegasi>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getAllDataDelegasiPickup(context: Context, callback: LoadResponseNewpoCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPickup = ApiConfig.getApiService().getResponseDelegasiPickup(token)
            clientPickup.enqueue(object : Callback<ResponseNewPo> {
                override fun onResponse(
                    call: Call<ResponseNewPo>,
                    response: Response<ResponseNewPo>
                ) {
                    callback.onGetResponseNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponseNewPo>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getAllDataDelegasiOffice(context: Context, callback: LoadResponseNewpoCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPickup = ApiConfig.getApiService().getResponseDelegasiOffice(token)
            clientPickup.enqueue(object : Callback<ResponseNewPo> {
                override fun onResponse(
                    call: Call<ResponseNewPo>,
                    response: Response<ResponseNewPo>
                ) {
                    callback.onGetResponseNewpo(response.body())
                    Log.d("salah", response.body()?.house?.size.toString())
                }

                override fun onFailure(call: Call<ResponseNewPo>, t: Throwable) {
                    Log.d("salah", t.message.toString())
                }

            })
        }
    }

    fun getAllDataDelegasiSiapantar(context: Context, callback: LoadResponseNewpoCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientPickup = ApiConfig.getApiService().getResponseDelegasiSiapantar(token)
            clientPickup.enqueue(object : Callback<ResponseNewPo> {
                override fun onResponse(
                    call: Call<ResponseNewPo>,
                    response: Response<ResponseNewPo>
                ) {
                    callback.onGetResponseNewpo(response.body())
                }

                override fun onFailure(call: Call<ResponseNewPo>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getAllDataDelegasiDeliverAirline(
        context: Context,
        callback: LoadResponseSiapAntarCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientDeliverAirline =
                ApiConfig.getApiService().getResponseDelegasiDeliverAirline(token)
            clientDeliverAirline.enqueue(object : Callback<ResponseSiapAntar> {
                override fun onResponse(
                    call: Call<ResponseSiapAntar>,
                    response: Response<ResponseSiapAntar>
                ) {
                    callback.onGetResponseSiapAntar(response.body())
                }

                override fun onFailure(call: Call<ResponseSiapAntar>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }


            })
        }
    }

    fun getResponseAirline(context: Context, callback: LoadResponseAirlineCallback) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientAirline = ApiConfig.getApiService().getAirline(token)
            clientAirline.enqueue(object : Callback<ResponseAirline> {
                override fun onResponse(
                    call: Call<ResponseAirline>,
                    response: Response<ResponseAirline>
                ) {
                    callback.onGetResponseAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseAirline>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    fun getResponseAirlineOperational(
        context: Context,
        page: Int = 1,
        callback: LoadResponseAirlineOperationalCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientAirline = ApiConfig.getApiService().getAirlineOperational(token, page = page)
            clientAirline.enqueue(object : Callback<ResponseAirlineOperational> {
                override fun onResponse(
                    call: Call<ResponseAirlineOperational>,
                    response: Response<ResponseAirlineOperational>
                ) {
                    Log.d("Tes", response.body()?.master?.data?.size.toString())
                    callback.onGetResponseAirlineOperational(response.body()?.master)
                }

                override fun onFailure(call: Call<ResponseAirlineOperational>, t: Throwable) {
                    Log.d("gaga", t.message.toString())
                }

            })
        }
    }
    fun getResponseTotalAirlineOperational(
        context: Context,
        callback: LoadResponseAirlineOperationalCallback
    ){
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null){
            token = "Bearer" + " " + token
            val clientAirline = ApiConfig.getApiService().getAirlineOperational(token)
            clientAirline.enqueue(object : Callback<ResponseAirlineOperational> {
                override fun onResponse(
                    call: Call<ResponseAirlineOperational>,
                    response: Response<ResponseAirlineOperational>
                ) {
                    Log.d("Tes", response.body()?.master?.data?.size.toString())
                    callback.onGetResponseAirlineOperational(response.body()?.master)
                }

                override fun onFailure(call: Call<ResponseAirlineOperational>, t: Throwable) {
                    Log.d("gaga", t.message.toString())
                }

            })
        }
    }

    fun postCompletedAirline(
        context: Context,
        uid: String,
        weightLini: String,
        collieLini: String,
        weightLini2: String,
        collieLini2: String,
        callback: LoadResponseCompletedAirlineCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientCompletedAirline = ApiConfig.getApiService()
                .postCompletedAirline(token, uid, weightLini.toDouble(), collieLini.toDouble(),weightLini2.toDouble(),collieLini2.toDouble())
            clientCompletedAirline.enqueue(object : Callback<ResponseSentOperational> {
                override fun onResponse(
                    call: Call<ResponseSentOperational>,
                    response: Response<ResponseSentOperational>
                ) {
                    callback.onGetResponseCompletedAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseSentOperational>, t: Throwable) {
                    Log.d("gaga", t.message.toString())
                }

            })

        }
    }

    fun postCompletedAirline2(
        context: Context,
        uid: String,
        weightLini: String,
        collieLini: String,
        callback: LoadResponseCompletedAirlineCallback
    ) {
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null) {
            token = "Bearer" + " " + token
            val clientCompletedAirline = ApiConfig.getApiService()
                .postCompletedAirline2(token, uid, weightLini.toDouble(), collieLini.toDouble())
            clientCompletedAirline.enqueue(object : Callback<ResponseSentOperational> {
                override fun onResponse(
                    call: Call<ResponseSentOperational>,
                    response: Response<ResponseSentOperational>
                ) {
                    callback.onGetResponseCompletedAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseSentOperational>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })

        }
    }

    fun searchAirline(context: Context,mpoId: String?,callback:LoadResponseSearchAirline){
        val preference = context.getSharedPreferences("APP", Context.MODE_PRIVATE)
        var token = preference.getString("TOKEN", null)
        if (token != null){
            token = "Bearer" + " " + token
            val clientSearchAirline=ApiConfig.getApiService().searchMpoAirline(token,mpoId)
            clientSearchAirline.enqueue(object :Callback<ResponseSearchAirline>{
                override fun onResponse(
                    call: Call<ResponseSearchAirline>,
                    response: Response<ResponseSearchAirline>
                ) {
                    callback.onGetResponseSearchAirline(response.body())
                }

                override fun onFailure(call: Call<ResponseSearchAirline>, t: Throwable) {
                    Toast.makeText(context, "Gagal Terhubung ke Server..", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }
    }

    interface LoadResponseLoginCallback {
        fun onGetResponseLogin(loginResponse: ResponseLogin?)
    }

    interface LoadResponseLogoutCallback{
        fun onGetResponseLogout(logoutResponse:ResponseLogout?)
    }

    interface LoadResponsePostNewpoCallback {
        fun onGetResponsePostNewpo(responsePostNewpo: ResponsePostNewpo?)
    }

    interface LoadResponseNewpoCallback {
        fun onGetResponseNewpo(responseNewpo: ResponseNewPo?)
    }

    interface LoadResponseDriverCallback {
        fun onGetDataDriver(responseDriver: ResponseDataDriver?)
    }

    interface LoadResponseUserCallback {
        fun onGetDataUser(responseUser: ResponseSpecificDataUser?)
    }

    interface LoadResponsePickupCallback {
        fun onGetResponsePickup(responsePickup: ResponsePickup?)
    }

    interface LoadResponseDriverPickupCallback {
        fun onGetResponseDriverPickup(responsePickup: ResponsePickup?)
    }

    interface LoadResponseConfirmPickupCallback {
        fun onGetResponseConfirmPickup(responseConfirm: ResponseConfirmPickup?)
    }

    interface LoadResponseConfirmSentOfficeCallback {
        fun onGetResponseConfirmSentOffice(responseConfirm: ResponseConfirmPickup?)
    }

    interface LoadResponseDelegasiCallback {
        fun onGetResponseDelegasi(responseDelegasi: ResponseDelegasi?)
    }

    interface LoadResponseSentToOfficeCallback {
        fun onGetResponseSentToOffice(responseOffice: ResponseOffice?)
    }

    interface LoadResponseContinuePickupCallback {
        fun onGetResponseContinuePickup(responseContinuePickup: ResponseContinuePickup?)
    }

    interface LoadResponseConfirmArrivedOfficeCallback {
        fun onGetResponseArrivedOffice(responseConfirmOffice: ResponseConfirmOffice?)
    }

    interface LoadResponseContinueOfficeCallback {
        fun onGetResponseContinueOffice(responseContinueOffice: ResponseContinueOffice?)
    }

    interface LoadResponseSiapAntarCallback {
        fun onGetResponseSiapAntar(responseSiapAntar: ResponseSiapAntar?)
    }

    interface LoadResponseConfirmArrivedSiapAntarCallback {
        fun onGetResponseArrivedSiapAntar(responseConfirmSiapantar: ResponseConfirmSiapantar?)
    }

    interface LoadResponseContinueSiapAntarCallback {
        fun onGetResponseContinueSiapAntar(responseContinueSiapAntar: ResponseContinueSiapAntar?)
    }

    interface LoadResponsePostSiapAntarCallback {
        fun onGetResponsePostSiapAntar(responsePostSiapantar: ResponsePostSiapantar?)
    }

    interface LoadResponseDeliverAirlineCallback {
        fun onGetResponseDeliverAirline(responseDeliverAirline: ResponseDeliverAirline?)
    }

    interface LoadResponseConfirmArrivedDeliverAirlineCallback {
        fun onGetResponseArrivedDeliverAirline(responseConfirmDeliverAirline: ResponseConfirmDeliverAirline?)
    }

    interface LoadResponseContinueDeliverAirlineCallback {
        fun onGetResponseContinueDeliverAirline(responseContinueDeliverAirline: ResponseContinueDeliverAirline?)
    }

    interface LoadResponseAirlineCallback {
        fun onGetResponseAirline(responseAirline: ResponseAirline?)
    }

    interface LoadResponseAirlineOperationalCallback {
        fun onGetResponseAirlineOperational(response: Master?)
    }

    interface LoadResponseCompletedAirlineCallback {
        fun onGetResponseCompletedAirline(response: ResponseSentOperational?)
    }
    interface LoadResponseSearchAirline{
        fun onGetResponseSearchAirline(response:ResponseSearchAirline?)
    }
}