package pt.lunata.hitamado.data

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import pt.lunata.hitamado.data.remote.RemoteDataSource
import pt.lunata.hitamado.data.remote.page.OperationalPageDataSource
import pt.lunata.hitamado.data.remote.page.OperationalPageFactory
import pt.lunata.hitamado.model.airline.AirlineEntity
import pt.lunata.hitamado.model.airline.ResponseAirline
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.model.airline.operational.Master
import pt.lunata.hitamado.model.airline.operational.ResponseSentOperational
import pt.lunata.hitamado.model.airline.operational.TotalEntity
import pt.lunata.hitamado.model.airline.search.ResponseSearchAirline
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.delegasi.ResponseDelegasi
import pt.lunata.hitamado.model.deliverairline.*
import pt.lunata.hitamado.model.driver.entity.DriverEntity
import pt.lunata.hitamado.model.driver.entity.JabatanEntity
import pt.lunata.hitamado.model.driver.response.ResponseDataDriver
import pt.lunata.hitamado.model.driver.response.ResponseSpecificDataUser
import pt.lunata.hitamado.model.login.LoginEntity
import pt.lunata.hitamado.model.login.ResponseLogin
import pt.lunata.hitamado.model.logout.ResponseLogout
import pt.lunata.hitamado.model.newpo.NewpoEntity
import pt.lunata.hitamado.model.newpo.NewpoPostEntity
import pt.lunata.hitamado.model.newpo.ResponseNewPo
import pt.lunata.hitamado.model.newpo.ResponsePostNewpo
import pt.lunata.hitamado.model.office.*
import pt.lunata.hitamado.model.pickup.*
import pt.lunata.hitamado.model.pickup.ConfirmEntity
import pt.lunata.hitamado.model.siapantar.*
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SjtRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    SjtDataSource {
    override fun getResponseLogin(
        email: String,
        password: String,
        deviceId: String
    ): LiveData<LoginEntity> {
        val resultLogin = MutableLiveData<LoginEntity>()
        remoteDataSource.doLogin(
            email,
            password,
            deviceId,
            object : RemoteDataSource.LoadResponseLoginCallback {
                override fun onGetResponseLogin(loginResponse: ResponseLogin?) {
                    val dataLogin = LoginEntity(
                        loginResponse?.token,
                        loginResponse?.uid,
                        loginResponse?.jabatan
                    )
                    resultLogin.postValue(dataLogin)
                }
            })
        return resultLogin
    }

    override fun getResponseLogout(context: Context): LiveData<ResponseLogout> {
        val resultLogout=MutableLiveData<ResponseLogout>()
        remoteDataSource.doLogout(context,object :RemoteDataSource.LoadResponseLogoutCallback{
            override fun onGetResponseLogout(logoutResponse: ResponseLogout?) {
                val result=ResponseLogout(
                    logoutResponse?.error,
                    logoutResponse?.message
                )
                resultLogout.postValue(result)
            }
        })
        return resultLogout
    }

    override fun getResponsePostNewPo(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> {
        val resultPostNewpo = MutableLiveData<NewpoPostEntity>()
        remoteDataSource.postNewPo(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponsePostNewpoCallback {
                override fun onGetResponsePostNewpo(responsePostNewpo: ResponsePostNewpo?) {
                    val result = NewpoPostEntity(
                        responsePostNewpo?.success
                    )
                    resultPostNewpo.postValue(result)
                }
            })
        return resultPostNewpo
    }

    override fun getResponseNewpo(context: Context): LiveData<List<NewpoEntity>> {
        val resultDataNewpo = MutableLiveData<List<NewpoEntity>>()
        remoteDataSource.getDataNewpo(context, object : RemoteDataSource.LoadResponseNewpoCallback {
            override fun onGetResponseNewpo(responseNewpo: ResponseNewPo?) {
                if (responseNewpo?.house != null) {
                    var listNewpo = ArrayList<NewpoEntity>()
                    for (response in responseNewpo.house) {
                        val dataNewpo = NewpoEntity(
                            response?.uid,
                            response?.poHouseNumber,
                            response?.mpoNumber,
                            response?.customerName,
                            response?.airportCode,
                            response?.customerAppend?.alamat,
                            response?.customerAppend?.noTelepon,
                            response?.comodityName,
                            response?.marketingName,
                            response?.quantityEst,
                            response?.collieEst.toString(),
                            response?.driverName,
                            response?.keteranganDelegasi
                        )
                        listNewpo.add(dataNewpo)
                    }
                    resultDataNewpo.postValue(listNewpo)
                }
            }
        })
        return resultDataNewpo
    }

    override fun getResponsePostDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> {
        val resultPostNewpo = MutableLiveData<NewpoPostEntity>()
        remoteDataSource.postDelegasiOfficeHead(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponsePostNewpoCallback {
                override fun onGetResponsePostNewpo(responsePostNewpo: ResponsePostNewpo?) {
                    val result = NewpoPostEntity(
                        responsePostNewpo?.success
                    )
                    resultPostNewpo.postValue(result)
                }
            })
        return resultPostNewpo
    }

    override fun getResponseOffice(context: Context): LiveData<List<OfficeEntity>> {
        var listItemsOffice = MutableLiveData<List<OfficeEntity>>()
        remoteDataSource.getResponseOffice(context,
            object : RemoteDataSource.LoadResponseSentToOfficeCallback {
                override fun onGetResponseSentToOffice(responseOffice: ResponseOffice?) {
                    if (responseOffice?.house != null) {
                        var listItems = ArrayList<OfficeEntity>()
                        for (response in responseOffice.house) {
                            val item = OfficeEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.status,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString(),
                                response?.tiba_office.toString(),
                                response?.driverName
                            )
                            listItems.add(item)
                        }
                        listItemsOffice.postValue(listItems)
                    }
                }
            })
        return listItemsOffice
    }

    override fun getResponseOfficeDriver(context: Context): LiveData<List<OfficeEntity>> {
        var listItemsOffice = MutableLiveData<List<OfficeEntity>>()
        remoteDataSource.getResponseOfficeDriver(context,
            object : RemoteDataSource.LoadResponseSentToOfficeCallback {
                override fun onGetResponseSentToOffice(responseOffice: ResponseOffice?) {
                    if (responseOffice?.house != null) {
                        var listItems = ArrayList<OfficeEntity>()
                        for (response in responseOffice.house) {
                            val item = OfficeEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.status,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString(),
                                response?.tiba_office.toString(),
                                response?.driverName
                            )
                            listItems.add(item)
                        }
                        listItemsOffice.postValue(listItems)
                    }
                }
            })
        return listItemsOffice
    }

    override fun getResponsePostSiapantar(
        context: Context,
        mpoId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<ResponsePostSiapantar> {
        val resultPostSiapantar = MutableLiveData<ResponsePostSiapantar>()
        remoteDataSource.postSiapantar(
            context,
            mpoId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponsePostSiapAntarCallback {
                override fun onGetResponsePostSiapAntar(responsePostSiapantar: ResponsePostSiapantar?) {
                    val result = ResponsePostSiapantar(
                        responsePostSiapantar?.error,
                        responsePostSiapantar?.message
                    )
                    resultPostSiapantar.postValue(result)
                }

            })
        return resultPostSiapantar
    }

    override fun getResponseSiapAntar(context: Context): LiveData<List<SiapAntarEntity>> {
        val resultItemsSiapAntar = MutableLiveData<List<SiapAntarEntity>>()
        remoteDataSource.getResponseSiapAntar(context,
            object : RemoteDataSource.LoadResponseSiapAntarCallback {
                override fun onGetResponseSiapAntar(responseSiapAntar: ResponseSiapAntar?) {
                    if (responseSiapAntar?.data != null) {
                        var listItems = ArrayList<SiapAntarEntity>()
                        for (response in responseSiapAntar?.data) {
                            val listPoBelumTiba=ArrayList<ItemHouseBelumTibaEntity>()
                            if (response?.houseBelumTiba!=null){
                                for (itemPo in response.houseBelumTiba){
                                    val item=ItemHouseBelumTibaEntity(
                                        itemPo.uid,
                                        itemPo.po_house_number
                                    )
                                    listPoBelumTiba.add(item)
                                }
                            }
                            val listAllHouse=ArrayList<ItemAllHouseEntity>()
                            if (response?.allHouse!=null){
                                for (itemHouse in response.allHouse){
                                    val item=ItemAllHouseEntity(
                                        itemHouse.uid,
                                        itemHouse.po_house_number
                                    )
                                    listAllHouse.add(item)
                                }
                            }
                            val items = SiapAntarEntity(
                                response?.uid,
                                response?.poMasterNumber,
                                response?.siapAntar,
                                response?.driverName,
                                response?.keteranganDelegasi,
                                response?.tanggalAntarMaskapai.toString(),
                                response?.airportCode,
                                response?.smu.toString(),
                                listPoBelumTiba,
                                listAllHouse
                            )
                            listItems.add(items)
                        }
                        resultItemsSiapAntar.postValue(listItems)
                    }
                }
            })
        return resultItemsSiapAntar
    }

    override fun getResponseSiapAntarDriver(context: Context): LiveData<List<SiapAntarEntity>> {
        val resultItemsSiapAntar = MutableLiveData<List<SiapAntarEntity>>()
        remoteDataSource.getResponseSiapantarDriver(context,
            object : RemoteDataSource.LoadResponseSiapAntarCallback {
                override fun onGetResponseSiapAntar(responseSiapAntar: ResponseSiapAntar?) {
                    if (responseSiapAntar?.data != null) {
                        var listItems = ArrayList<SiapAntarEntity>()
                        for (response in responseSiapAntar?.data) {
                            val listPoBelumTiba=ArrayList<ItemHouseBelumTibaEntity>()
                            if (response?.houseBelumTiba!=null){
                                for (itemPo in response.houseBelumTiba){
                                    val item=ItemHouseBelumTibaEntity(
                                        itemPo.uid,
                                        itemPo.po_house_number
                                    )
                                    listPoBelumTiba.add(item)
                                }
                            }
                            val listAllHouse=ArrayList<ItemAllHouseEntity>()
                            if (response?.allHouse!=null){
                                for (itemHouse in response.allHouse){
                                    val item=ItemAllHouseEntity(
                                        itemHouse.uid,
                                        itemHouse.po_house_number
                                    )
                                    listAllHouse.add(item)
                                }
                            }
                            val items = SiapAntarEntity(
                                response?.uid,
                                response?.poMasterNumber,
                                response?.siapAntar,
                                response?.driverName,
                                response?.keteranganDelegasi,
                                response?.tanggalAntarMaskapai.toString(),
                                response?.airportCode,
                                response?.smu.toString(),
                                listPoBelumTiba,
                                listAllHouse
                            )
                            listItems.add(items)
                        }
                        resultItemsSiapAntar.postValue(listItems)
                    }
                }
            })
        return resultItemsSiapAntar
    }

    override fun getResponsePostDelegasiSiapantar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> {
        val resultPostNewpo = MutableLiveData<NewpoPostEntity>()
        remoteDataSource.postDelegasiSiapAntarHead(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponsePostNewpoCallback {
                override fun onGetResponsePostNewpo(responsePostNewpo: ResponsePostNewpo?) {
                    val result = NewpoPostEntity(
                        responsePostNewpo?.success
                    )
                    resultPostNewpo.postValue(result)
                }
            })
        return resultPostNewpo
    }

    override fun getResponseDeliverAirline(context: Context): LiveData<List<DeliverAirlineEntity>> {
        val resultItemsDeliverAirline = MutableLiveData<List<DeliverAirlineEntity>>()
        remoteDataSource.getResponseDeliverAirline(context,
            object : RemoteDataSource.LoadResponseDeliverAirlineCallback {
                override fun onGetResponseDeliverAirline(responseDeliverAirline: ResponseDeliverAirline?) {
                    if (responseDeliverAirline?.data != null) {
                        var listItems = ArrayList<DeliverAirlineEntity>()
                        for (response in responseDeliverAirline.data) {
                            val item = DeliverAirlineEntity(
                                response?.uid,
                                response?.poMasterNumber,
                                response?.driverName,
                                response?.tanggalAntarMaskapai,
                                response?.airportCode,
                                response?.smu.toString(),
                                response?.quantityEst,
                                response?.collieEst.toString()
                            )
                            listItems.add(item)
                        }
                        resultItemsDeliverAirline.postValue(listItems)
                    }
                }
            })
        return resultItemsDeliverAirline
    }

    override fun getResponseDeliverAirlineDriver(context: Context): LiveData<List<DeliverAirlineEntity>> {
        val resultItemsDeliverAirline = MutableLiveData<List<DeliverAirlineEntity>>()
        remoteDataSource.getResponseDeliverAirlineDriver(context,
            object : RemoteDataSource.LoadResponseDeliverAirlineCallback {
                override fun onGetResponseDeliverAirline(responseDeliverAirline: ResponseDeliverAirline?) {
                    if (responseDeliverAirline?.data != null) {
                        var listItems = ArrayList<DeliverAirlineEntity>()
                        for (response in responseDeliverAirline.data) {
                            val item = DeliverAirlineEntity(
                                response?.uid,
                                response?.poMasterNumber,
                                response?.driverName,
                                response?.tanggalAntarMaskapai,
                                response?.airportCode,
                                response?.smu.toString(),
                                response?.quantityEst,
                                response?.collieEst.toString()
                            )
                            listItems.add(item)
                        }
                        resultItemsDeliverAirline.postValue(listItems)
                    }
                }
            })
        return resultItemsDeliverAirline
    }

    override fun getResponsePostDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity> {
        val resultPosDeliverAirline = MutableLiveData<NewpoPostEntity>()
        remoteDataSource.postDelegasiDeliverAirlineHead(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponsePostNewpoCallback {
                override fun onGetResponsePostNewpo(responsePostNewpo: ResponsePostNewpo?) {
                    val result = NewpoPostEntity(
                        responsePostNewpo?.success
                    )
                    resultPosDeliverAirline.postValue(result)
                }
            })
        return resultPosDeliverAirline
    }

    override fun getDataDriver(context: Context): LiveData<List<DriverEntity>> {
        val resultDataDriver = MutableLiveData<List<DriverEntity>>()
        remoteDataSource.getDataDriver(context,
            object : RemoteDataSource.LoadResponseDriverCallback {
                override fun onGetDataDriver(responseDriver: ResponseDataDriver?) {
                    var listDriver = ArrayList<DriverEntity>()
                    if (responseDriver?.driver != null) {
                        for (response in responseDriver.driver) {
                            val jabatanEntity = JabatanEntity(
                                response?.jabatanAppend?.updatedAt,
                                response?.jabatanAppend?.jabatan,
                                response?.jabatanAppend?.gaji,
                                response?.jabatanAppend?.createdAt,
                                response?.jabatanAppend?.id,
                                response?.jabatanAppend?.deletedAt
                            )
                            val driverItem = DriverEntity(
                                jabatanEntity,
                                response?.noEmergency1,
                                response?.mulaiKerja,
                                response?.idAgama,
                                response?.createdAt,
                                response?.noWa,
                                response?.nominalBpjsKetenagakerjaan,
                                response?.idOffice,
                                response?.nominalBpjsKesehatan,
                                response?.idJabatan,
                                response?.uid,
                                response?.nik,
                                response?.password,
                                response?.nominalNpwp,
                                response?.idJk,
                                response?.updatedAt,
                                response?.nominalMakan,
                                response?.idPegawai,
                                response?.noNpwp,
                                response?.email,
                                response?.tanggalLahir,
                                response?.idDivisi,
                                response?.gaji,
                                response?.noBpjsKetenagakerjaan,
                                response?.ikatanNoEmergency1,
                                response?.deletedAt,
                                response?.alamat,
                                response?.noKontak,
                                response?.nama,
                                response?.foto
                            )
                            listDriver.add(driverItem)
                        }
                        resultDataDriver.postValue(listDriver)
                    }
                }
            })
        return resultDataDriver
    }

    override fun getDataUser(context: Context): LiveData<DriverEntity> {
        val resultDataUser = MutableLiveData<DriverEntity>()
        remoteDataSource.getDataUser(context, object : RemoteDataSource.LoadResponseUserCallback {
            override fun onGetDataUser(responseUser: ResponseSpecificDataUser?) {
                if (responseUser?.specificDriverData != null) {
                    val jabatanEntity = JabatanEntity(
                        responseUser?.specificDriverData.jabatanAppend?.updatedAt,
                        responseUser?.specificDriverData.jabatanAppend?.jabatan,
                        responseUser?.specificDriverData.jabatanAppend?.gaji,
                        responseUser?.specificDriverData.jabatanAppend?.createdAt,
                        responseUser?.specificDriverData.jabatanAppend?.id,
                        responseUser?.specificDriverData.jabatanAppend?.deletedAt
                    )
                    val userItem = DriverEntity(
                        jabatanEntity,
                        responseUser?.specificDriverData.noEmergency1,
                        responseUser?.specificDriverData.mulaiKerja,
                        responseUser?.specificDriverData.idAgama,
                        responseUser?.specificDriverData.createdAt,
                        responseUser?.specificDriverData.noWa,
                        responseUser?.specificDriverData.nominalBpjsKetenagakerjaan,
                        responseUser?.specificDriverData.idOffice,
                        responseUser?.specificDriverData.nominalBpjsKesehatan,
                        responseUser?.specificDriverData.idJabatan,
                        responseUser?.specificDriverData.uid,
                        responseUser?.specificDriverData.nik,
                        responseUser?.specificDriverData.password,
                        responseUser?.specificDriverData.nominalNpwp,
                        responseUser?.specificDriverData.idJk,
                        responseUser?.specificDriverData.updatedAt,
                        responseUser?.specificDriverData.nominalMakan,
                        responseUser?.specificDriverData.idPegawai,
                        responseUser?.specificDriverData.noNpwp,
                        responseUser?.specificDriverData.email,
                        responseUser?.specificDriverData.tanggalLahir,
                        responseUser?.specificDriverData.idDivisi,
                        responseUser?.specificDriverData.gaji,
                        responseUser?.specificDriverData.noBpjsKetenagakerjaan,
                        responseUser?.specificDriverData.ikatanNoEmergency1,
                        responseUser?.specificDriverData.deletedAt,
                        responseUser?.specificDriverData.alamat,
                        responseUser?.specificDriverData.noKontak,
                        responseUser?.specificDriverData.nama,
                        responseUser?.specificDriverData.foto
                    )
                    resultDataUser.postValue(userItem)
                }
            }
        })
        return resultDataUser
    }

    override fun getResponsePickup(context: Context): LiveData<List<PickupEntity>> {
        val resultDataPickup = MutableLiveData<List<PickupEntity>>()
        remoteDataSource.getAllDataPickup(context,
            object : RemoteDataSource.LoadResponsePickupCallback {
                override fun onGetResponsePickup(responsePickup: ResponsePickup?) {
                    if (responsePickup?.house != null) {
                        var listPickup = ArrayList<PickupEntity>()
                        for (response in responsePickup.house) {
                            val dataPickup = PickupEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.status,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.tiba_customer.toString(),
                                response?.pickUpOffice,
                                response?.collieEst.toString(),
                                response?.driverName
                            )
                            listPickup.add(dataPickup)
                        }
                        resultDataPickup.postValue(listPickup)
                    }
                }
            })
        return resultDataPickup
    }

    override fun getResponseDriverPickup(context: Context): LiveData<List<PickupEntity>> {
        val resultDataPickup = MutableLiveData<List<PickupEntity>>()
        remoteDataSource.getDataDriverPickup(context,
            object : RemoteDataSource.LoadResponseDriverPickupCallback {
                override fun onGetResponseDriverPickup(responsePickup: ResponsePickup?) {
                    if (responsePickup?.house != null) {
                        var listPickup = ArrayList<PickupEntity>()
                        for (response in responsePickup.house) {

                            val dataPickup = PickupEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.status,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.tiba_customer.toString(),
                                response?.pickUpOffice,
                                response?.collieEst.toString(),
                                response?.driverName
                            )
                            listPickup.add(dataPickup)
                        }
                        resultDataPickup.postValue(listPickup)
                    }
                }
            })
        return resultDataPickup
    }

    override fun getResponseConfirm(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmEntity> {
        val resultConfirmPickup = MutableLiveData<ConfirmEntity>()
        remoteDataSource.getResponseConfirm(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseConfirmPickupCallback {
                override fun onGetResponseConfirmPickup(responseConfirm: ResponseConfirmPickup?) {
                    val result = ConfirmEntity(
                        responseConfirm?.confirmed
                    )
                    resultConfirmPickup.postValue(result)
                }
            })
        return resultConfirmPickup
    }

    override fun postResponseArrivedToCustomer(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmEntity> {
        val resultConfirmArrived = MutableLiveData<ConfirmEntity>()
        remoteDataSource.postConfirmArrivedcustomer(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseConfirmSentOfficeCallback {
                override fun onGetResponseConfirmSentOffice(responseConfirm: ResponseConfirmPickup?) {
                    val result = ConfirmEntity(
                        responseConfirm?.confirmed
                    )
                    resultConfirmArrived.postValue(result)
                }
            })
        return resultConfirmArrived
    }

    override fun postResponseContinuePickup(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinuePickupEntity> {
        val resultContinuePickup = MutableLiveData<ContinuePickupEntity>()
        remoteDataSource.postConfirmContinuePickup(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseContinuePickupCallback {
                override fun onGetResponseContinuePickup(responseContinuePickup: ResponseContinuePickup?) {
                    val result = ContinuePickupEntity(
                        responseContinuePickup?.success
                    )
                    resultContinuePickup.postValue(result)
                }
            })
        return resultContinuePickup
    }

    override fun postResponseDelegasiPickup(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> {
        val resultDelegasiPickup = MutableLiveData<DelegasiEntity>()
        remoteDataSource.postDelegasiPickup(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponseDelegasiCallback {
                override fun onGetResponseDelegasi(responseDelegasi: ResponseDelegasi?) {
                    val result = DelegasiEntity(
                        responseDelegasi?.success,
                        responseDelegasi?.error
                    )
                    resultDelegasiPickup.postValue(result)
                }
            })
        return resultDelegasiPickup
    }

    override fun postArrivedAtOffice(
        context: Context,
        poHouseId: String?
    ): LiveData<pt.lunata.hitamado.model.office.ConfirmEntity> {
        val resultArrivedOffice = MutableLiveData<pt.lunata.hitamado.model.office.ConfirmEntity>()
        remoteDataSource.postArrivedOffice(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseConfirmArrivedOfficeCallback {
                override fun onGetResponseArrivedOffice(responseConfirmOffice: ResponseConfirmOffice?) {
                    val result = pt.lunata.hitamado.model.office.ConfirmEntity(
                        responseConfirmOffice?.success
                    )
                    resultArrivedOffice.postValue(result)
                }
            })
        return resultArrivedOffice
    }

    override fun postResponseContinueOffice(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinueOfficeEntity> {
        val resultContinueOffice = MutableLiveData<ContinueOfficeEntity>()
        remoteDataSource.postConfirmContinueOffice(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseContinueOfficeCallback {
                override fun onGetResponseContinueOffice(responseContinueOffice: ResponseContinueOffice?) {
                    val result = ContinueOfficeEntity(
                        responseContinueOffice?.success
                    )
                    resultContinueOffice.postValue(result)
                }
            })
        return resultContinueOffice
    }

    override fun postResponseDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> {
        val resultDelegasiOffice = MutableLiveData<DelegasiEntity>()
        remoteDataSource.postDelegasiOffice(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponseDelegasiCallback {
                override fun onGetResponseDelegasi(responseDelegasi: ResponseDelegasi?) {
                    val result = DelegasiEntity(
                        responseDelegasi?.success,
                        responseDelegasi?.error
                    )
                    resultDelegasiOffice.postValue(result)
                }
            })
        return resultDelegasiOffice
    }

    override fun postResponseArrivedSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmSiapAntarEntity> {
        val resultArrivedSiapAntar = MutableLiveData<ConfirmSiapAntarEntity>()
        remoteDataSource.postArrivedSiapAntar(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseConfirmArrivedSiapAntarCallback {
                override fun onGetResponseArrivedSiapAntar(responseConfirmSiapantar: ResponseConfirmSiapantar?) {
                    val result = ConfirmSiapAntarEntity(
                        responseConfirmSiapantar?.success
                    )
                    resultArrivedSiapAntar.postValue(result)
                }
            })
        return resultArrivedSiapAntar
    }

    override fun postResponseContinueSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinueSiapAntarEntity> {
        val resultContinueSiapAntar = MutableLiveData<ContinueSiapAntarEntity>()
        remoteDataSource.postConfirmContinueSiapAntar(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseContinueSiapAntarCallback {
                override fun onGetResponseContinueSiapAntar(responseContinueSiapAntar: ResponseContinueSiapAntar?) {
                    val result = ContinueSiapAntarEntity(
                        responseContinueSiapAntar?.success
                    )
                    resultContinueSiapAntar.postValue(result)
                }
            })
        return resultContinueSiapAntar
    }

    override fun postResponseDelegasiSiapAntar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> {
        val resultDelegasiOffice = MutableLiveData<DelegasiEntity>()
        remoteDataSource.postDelegasiSiapAntar(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponseDelegasiCallback {
                override fun onGetResponseDelegasi(responseDelegasi: ResponseDelegasi?) {
                    val result = DelegasiEntity(
                        responseDelegasi?.success,
                        responseDelegasi?.error
                    )
                    resultDelegasiOffice.postValue(result)
                }
            })
        return resultDelegasiOffice
    }

    override fun postArrivedDeliverAirline(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmDeliverAirlineEntity> {
        val resultArriveDeliverAirline = MutableLiveData<ConfirmDeliverAirlineEntity>()
        remoteDataSource.postArrivedDeliverAirline(
            context,
            poHouseId,
            object : RemoteDataSource.LoadResponseConfirmArrivedDeliverAirlineCallback {
                override fun onGetResponseArrivedDeliverAirline(responseConfirmDeliverAirline: ResponseConfirmDeliverAirline?) {
                    val result = ConfirmDeliverAirlineEntity(
                        responseConfirmDeliverAirline?.success
                    )
                    resultArriveDeliverAirline.postValue(result)
                }
            })
        return resultArriveDeliverAirline
    }

    override fun postResponseContinueDeliverAirline(
        context: Context,
        mpoId: String?
    ): LiveData<ContinueDeliverAirlineEntity> {
        val resultContinueDeliverAirline = MutableLiveData<ContinueDeliverAirlineEntity>()
        remoteDataSource.postContinueDeliverAirline(
            context,
            mpoId,
            object : RemoteDataSource.LoadResponseContinueDeliverAirlineCallback {
                override fun onGetResponseContinueDeliverAirline(responseContinueDeliverAirline: ResponseContinueDeliverAirline?) {
                    val result = ContinueDeliverAirlineEntity(
                        responseContinueDeliverAirline?.error,
                        responseContinueDeliverAirline?.message
                    )
                    resultContinueDeliverAirline.postValue(result)
                }
            })
        return resultContinueDeliverAirline
    }

    override fun postResponseDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity> {
        val resultDelegasiDeliverAirline = MutableLiveData<DelegasiEntity>()
        remoteDataSource.postDelegasiDeliverAirline(
            context,
            poHouseId,
            driverUid,
            description,
            object : RemoteDataSource.LoadResponseDelegasiCallback {
                override fun onGetResponseDelegasi(responseDelegasi: ResponseDelegasi?) {
                    val result = DelegasiEntity(
                        responseDelegasi?.success,
                        responseDelegasi?.error
                    )
                    resultDelegasiDeliverAirline.postValue(result)
                }
            })
        return resultDelegasiDeliverAirline
    }

    override fun postCompletedAirline(
        context: Context,
        uid: String,
        weighLini: String,
        collieLini: String,
        weighLini2: String,
        collieLini2: String
    ): LiveData<ResponseSentOperational> {
        val resultResponse = MutableLiveData<ResponseSentOperational>()
        remoteDataSource.postCompletedAirline(
            context,
            uid,
            weighLini,
            collieLini,
            weighLini2,
            collieLini2,
            object : RemoteDataSource.LoadResponseCompletedAirlineCallback {
                override fun onGetResponseCompletedAirline(response: ResponseSentOperational?) {
                    val result = ResponseSentOperational(
                        response?.Error,
                        response?.message
                    )
                    resultResponse.postValue(result)
                }
            })
        return resultResponse
    }

    override fun postCompletedAirline2(
        context: Context,
        uid: String,
        weighLini: String,
        collieLini: String
    ): LiveData<ResponseSentOperational> {
        val resultResponse = MutableLiveData<ResponseSentOperational>()
        remoteDataSource.postCompletedAirline2(
            context,
            uid,
            weighLini,
            collieLini,
            object : RemoteDataSource.LoadResponseCompletedAirlineCallback {
                override fun onGetResponseCompletedAirline(response: ResponseSentOperational?) {
                    val result = ResponseSentOperational(
                        response?.Error,
                        response?.message
                    )
                    resultResponse.postValue(result)
                }
            })
        return resultResponse
    }

    override fun getResponseDelegasiPickup(context: Context): LiveData<List<NewpoEntity>> {
        val resultDataPickup = MutableLiveData<List<NewpoEntity>>()
        remoteDataSource.getAllDataDelegasiPickup(context,
            object : RemoteDataSource.LoadResponseNewpoCallback {
                override fun onGetResponseNewpo(responseNewPo: ResponseNewPo?) {
                    if (responseNewPo?.house != null) {
                        var listPickup = ArrayList<NewpoEntity>()
                        for (response in responseNewPo.house) {
                            val dataNewpo = NewpoEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString(),
                                response?.driverName,
                                response?.keteranganDelegasi
                            )
                            listPickup.add(dataNewpo)
                        }
                        resultDataPickup.postValue(listPickup)
                    }
                }
            })
        return resultDataPickup
    }

    override fun getResponseDelegasiOffice(context: Context): LiveData<List<NewpoEntity>> {
        val resultDataOffice = MutableLiveData<List<NewpoEntity>>()
        remoteDataSource.getAllDataDelegasiOffice(context,
            object : RemoteDataSource.LoadResponseNewpoCallback {
                override fun onGetResponseNewpo(responseNewPo: ResponseNewPo?) {
                    if (responseNewPo?.house != null) {
                        var listOffice = ArrayList<NewpoEntity>()
                        for (response in responseNewPo.house) {
                            val dataNewpo = NewpoEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString(),
                                response?.driverName,
                                response?.keteranganDelegasi
                            )
                            listOffice.add(dataNewpo)
                        }
                        resultDataOffice.postValue(listOffice)
                    }
                }
            })
        return resultDataOffice
    }

    override fun getResponseDelegasiSiapantar(context: Context): LiveData<List<NewpoEntity>> {
        val resultDataSiapantar = MutableLiveData<List<NewpoEntity>>()
        remoteDataSource.getAllDataDelegasiSiapantar(context,
            object : RemoteDataSource.LoadResponseNewpoCallback {
                override fun onGetResponseNewpo(responseNewPo: ResponseNewPo?) {
                    if (responseNewPo?.house != null) {
                        var listSiapantar = ArrayList<NewpoEntity>()
                        for (response in responseNewPo.house) {
                            val dataNewpo = NewpoEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString(),
                                response?.driverName,
                                response?.keteranganDelegasi
                            )
                            listSiapantar.add(dataNewpo)
                        }
                        resultDataSiapantar.postValue(listSiapantar)
                    }
                }
            })
        return resultDataSiapantar
    }

    override fun getResponseDelegasiDeliverAirline(context: Context): LiveData<List<SiapAntarEntity>> {
        val resultDataDeliverAirline = MutableLiveData<List<SiapAntarEntity>>()
        remoteDataSource.getAllDataDelegasiDeliverAirline(context,
            object : RemoteDataSource.LoadResponseSiapAntarCallback {
                override fun onGetResponseSiapAntar(responseSiapAntar: ResponseSiapAntar?) {
                    if (responseSiapAntar?.data != null) {
                        var listDeliverAirline = ArrayList<SiapAntarEntity>()
                        for (response in responseSiapAntar.data) {
                            val listPoBelumTiba=ArrayList<ItemHouseBelumTibaEntity>()
                            if (response?.houseBelumTiba!=null){
                                for (itemPo in response.houseBelumTiba){
                                    val item=ItemHouseBelumTibaEntity(
                                        itemPo.uid,
                                        itemPo.po_house_number
                                    )
                                    listPoBelumTiba.add(item)
                                }
                            }
                            val listAllHouse=ArrayList<ItemAllHouseEntity>()
                            if (response?.allHouse!=null){
                                for (itemHouse in response.allHouse){
                                    val item=ItemAllHouseEntity(
                                        itemHouse.uid,
                                        itemHouse.po_house_number
                                    )
                                    listAllHouse.add(item)
                                }
                            }
                            val dataSiapantar = SiapAntarEntity(
                                response?.uid,
                                response?.poMasterNumber,
                                response?.siapAntar,
                                response?.driverName,
                                response?.keteranganDelegasi,
                                response?.tanggalAntarMaskapai.toString(),
                                response?.airportCode,
                                response?.smu.toString(),
                                listPoBelumTiba,
                                listAllHouse
                            )
                            listDeliverAirline.add(dataSiapantar)
                        }
                        resultDataDeliverAirline.postValue(listDeliverAirline)
                    }
                }
            })
        return resultDataDeliverAirline
    }

    override fun getResponseAirline(context: Context): LiveData<List<AirlineEntity>> {
        var listItemsAirline = MutableLiveData<List<AirlineEntity>>()
        remoteDataSource.getResponseAirline(context,
            object : RemoteDataSource.LoadResponseAirlineCallback {
                override fun onGetResponseAirline(responseAirline: ResponseAirline?) {
                    if (responseAirline?.house != null) {
                        var listItems = ArrayList<AirlineEntity>()
                        for (response in responseAirline.house) {
                            val item = AirlineEntity(
                                response?.uid,
                                response?.poHouseNumber,
                                response?.mpoNumber,
                                response?.status,
                                response?.customerName,
                                response?.airportCode,
                                response?.customerAppend?.alamat,
                                response?.customerAppend?.noTelepon,
                                response?.comodityName,
                                response?.marketingName,
                                response?.quantityEst,
                                response?.collieEst.toString()
                            )
                            listItems.add(item)
                        }
                        listItemsAirline.postValue(listItems)
                    }
                }
            })
        return listItemsAirline
    }

    override fun getResponseOperationalAirline(context: Context): LiveData<PagedList<DataItem>> {
        val operationalPageDataSource =
            OperationalPageDataSource(remoteDataSource = remoteDataSource, context = context)
        val factory = OperationalPageFactory(operationalPageDataSource)
        val dataBuilder = LivePagedListBuilder<Int, DataItem>(factory, ConfigClass().createConfig())
        val data = dataBuilder.setFetchExecutor(Executors.newFixedThreadPool(5)).build()
        Log.d("tesLagi", data.value?.size.toString())
        return data
    }

    override fun getResponseTotalItemAirline(context: Context): LiveData<TotalEntity> {
        val itemMaster=MutableLiveData<TotalEntity>()
        remoteDataSource.getResponseTotalAirlineOperational(context,object :RemoteDataSource.LoadResponseAirlineOperationalCallback{
            override fun onGetResponseAirlineOperational(response: Master?) {
                val data=TotalEntity(
                    response?.total
                )
                itemMaster.postValue(data)
            }
        })
        return itemMaster
    }

    override fun getResponseSearchAirline(
        context: Context,
        mpoId: String?
    ): LiveData<DataItem> {
        val resultDataSearch=MutableLiveData<DataItem>()
        remoteDataSource.searchAirline(context,mpoId,object :RemoteDataSource.LoadResponseSearchAirline{
            override fun onGetResponseSearchAirline(response: ResponseSearchAirline?) {
                if (response?.data!=null){
                    val data=DataItem(
                        response.data.uid,
                        response.data.maskapai,
                        response.data.poMasterNumber,
                        response.data.quantityEst,
                        response.data.collieEst
                    )
                    resultDataSearch.postValue(data)
                }
            }
        })
        return resultDataSearch
    }
}