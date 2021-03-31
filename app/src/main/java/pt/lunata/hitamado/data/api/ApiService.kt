package pt.lunata.hitamado.data.api

import pt.lunata.hitamado.model.airline.ResponseAirline
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
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("driver-login")
    fun loginUser(
        @Field("email") email: String?,
        @Field("password") password: String?,
        @Field("id_device") deviceId: String
    ): Call<ResponseLogin>

    @FormUrlEncoded
    @POST("logout")
    fun logoutUser(
        @Header("Authorization") token: String?,
        @Field("id_device")tokenFirebase:String?
    ):Call<ResponseLogout>

    @FormUrlEncoded
    @POST("request-jemput-ke-customer")
    fun postNewPo(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponsePostNewpo>

    @FormUrlEncoded
    @POST("request-antar-ke-kantor")
    fun postOfficeDelegasiHead(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponsePostNewpo>

    @FormUrlEncoded
    @POST("request-siap-antar")
    fun postSiapAntarDelegasiHead(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponsePostNewpo>

    @FormUrlEncoded
    @POST("request-ke-maskapai")
    fun postDeliverAirlineDelegasiHead(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponsePostNewpo>

    @FormUrlEncoded
    @POST("delegasi-jemput-ke-customer")
    fun postDelegasiPickup(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponseDelegasi>

    @FormUrlEncoded
    @POST("confirm-jemput-ke-customer")
    fun confirmPickup(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseConfirmPickup>

    @FormUrlEncoded
    @POST("arrived-jemput-ke-customer")
    fun confirmArrivedPickup(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseConfirmPickup>

    @FormUrlEncoded
    @POST("arrived-antar-ke-kantor")
    fun confirmArrivedOffice(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseConfirmOffice>


    @FormUrlEncoded
    @POST("po-house-continue-process-after-jemput-dari-customer")
    fun postContinueProcessPickup(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseContinuePickup>

    @FormUrlEncoded
    @POST("po-house-continue-process-after-antar-ke-kantor")
    fun postContinueProcessOffice(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseContinueOffice>

    @FormUrlEncoded
    @POST("delegasi-antar-ke-kantor")
    fun postDelegasiOffice(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponseDelegasi>

    @FormUrlEncoded
    @POST("arrived-siap-antar")
    fun confirmArrivedSiapAntar(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseConfirmSiapantar>

    @FormUrlEncoded
    @POST("po-house-continue-process-after-siap-antar")
    fun postContinueProcessSiapAntar(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseContinueSiapAntar>

    @FormUrlEncoded
    @POST("mpo-request-antar-ke-maskapai")
    fun postSiapAntar(
        @Header("Authorization") token: String,
        @Field("mpo_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponsePostSiapantar>

    @FormUrlEncoded
    @POST("delegasi-siap-antar")
    fun postDelegasiSiapantar(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponseDelegasi>

    @FormUrlEncoded
    @POST("otw-ke-maskapai")
    fun confirmArrivedMaskapai(
        @Header("Authorization") token: String,
        @Field("po_house_uid") poHouseId: String?
    ): Call<ResponseConfirmDeliverAirline>

    @FormUrlEncoded
    @POST("mpo-sampai-maskapai")
    fun postContinueArrivedMaskapai(
        @Header("Authorization") token: String,
        @Field("driver_uid") driverUid: String?,
        @Field("mpo_uid") mpoId: String?
    ): Call<ResponseContinueDeliverAirline>

    @FormUrlEncoded
    @POST("delegasi-mpo-antar-ke-maskapai")
    fun postDelegasiDeliverAirline(
        @Header("Authorization") token: String,
        @Field("mpo_uid") mpoId: String?,
        @Field("driver_uid") driverUid: String?,
        @Field("description") description: String?
    ): Call<ResponseDelegasi>

    @FormUrlEncoded
    @POST("master-completing-lini1")
    fun postCompletedAirline(
        @Header("Authorization") token: String,
        @Field("uid") uid: String?,
        @Field("weight_lini1") weightLini1: Double?,
        @Field("collie_lini1") collie_lini1: Double?,
        @Field("weight_lini2") weightLini2: Double?,
        @Field("collie_lini2") collie_lini2: Double?
    ): Call<ResponseSentOperational>

    @FormUrlEncoded
    @POST("master-completing-lini2")
    fun postCompletedAirline2(
        @Header("Authorization") token: String,
        @Field("uid") uid: String?,
        @Field("weight_lini2") weightLini2: Double?,
        @Field("collie_lini2") collie_lini2: Double?
    ): Call<ResponseSentOperational>

    @FormUrlEncoded
    @POST("search-master-request-to-be-completed")
    fun searchMpoAirline(
        @Header("Authorization") token: String,
        @Field("po_master_number") mpo_number: String?
    ):Call<ResponseSearchAirline>

    @GET("new-po-house")
    fun getNewpoHouse(@Header("Authorization") token: String): Call<ResponseNewPo>

    @GET("get-specific-driver-data/{uid}")
    fun getDataUser(
        @Header("Authorization") token: String,
        @Path("uid") userId: String
    ): Call<ResponseSpecificDataUser>

    @GET("get-driver-data")
    fun getDriver(@Header("Authorization") token: String): Call<ResponseDataDriver>

    @GET("po-house-jemput-ke-customer")
    fun getPuckupCustomer(@Header("Authorization") token: String): Call<ResponsePickup>

    @GET("po-house-jemput-ke-customer-based-on-driver/{uid}")
    fun getDriverPickupCusstomer(
        @Header("Authorization") token: String,
        @Path("uid") userId: String
    ): Call<ResponsePickup>

    @GET("po-house-antar-ke-kantor")
    fun getArrivedOfficeHeadDriver(@Header("Authorization") token: String): Call<ResponseOffice>

    @GET("po-house-antar-ke-kantor-based-on-driver/{uid}")
    fun getArrivedOfficeDriver(
        @Header("Authorization") token: String,
        @Path("uid") userId: String
    ): Call<ResponseOffice>

    @GET("mpo-siap-antar")
    fun getSiapAntar(@Header("Authorization") token: String): Call<ResponseSiapAntar>

    @GET("po-house-siap-antar-based-on-driver/{uid}")
    fun getSiapAntarDriver(
        @Header("Authorization") token: String,
        @Path("uid") userId: String
    ): Call<ResponseSiapAntar>

    @GET("mpo-ke-maskapai")
    fun getDeliverAirline(@Header("Authorization") token: String): Call<ResponseDeliverAirline>

    @GET("mpo-ke-maskapai-based-on-driver/{uid}")
    fun getDeliverAirlineDriver(
        @Header("Authorization") token: String,
        @Path("uid") userId: String
    ): Call<ResponseDeliverAirline>

    @GET("po-house-sampai-maskapai")
    fun getAirline(@Header("Authorization") token: String): Call<ResponseAirline>

    @GET("master-request-to-be-completed?")
    fun getAirlineOperational(
        @Header("Authorization") token: String,
        @Query("page") page: Int = 1
    ): Call<ResponseAirlineOperational>

    @GET("po-house-delegasi-jemput-ke-customer")
    fun getResponseDelegasiPickup(@Header("Authorization") token: String): Call<ResponseNewPo>

    @GET("po-house-delegasi-antar-ke-kantor")
    fun getResponseDelegasiOffice(@Header("Authorization") token: String): Call<ResponseNewPo>

    @GET("po-house-delegasi-siap-antar")
    fun getResponseDelegasiSiapantar(@Header("Authorization") token: String): Call<ResponseNewPo>

    @GET("mpo-delegated")
    fun getResponseDelegasiDeliverAirline(@Header("Authorization") token: String): Call<ResponseSiapAntar>

}