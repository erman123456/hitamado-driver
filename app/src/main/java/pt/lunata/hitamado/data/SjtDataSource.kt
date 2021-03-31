package pt.lunata.hitamado.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import pt.lunata.hitamado.model.airline.AirlineEntity
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.model.airline.operational.ResponseSentOperational
import pt.lunata.hitamado.model.airline.operational.TotalEntity
import pt.lunata.hitamado.model.delegasi.DelegasiEntity
import pt.lunata.hitamado.model.deliverairline.ConfirmDeliverAirlineEntity
import pt.lunata.hitamado.model.deliverairline.ContinueDeliverAirlineEntity
import pt.lunata.hitamado.model.deliverairline.DeliverAirlineEntity
import pt.lunata.hitamado.model.driver.entity.DriverEntity
import pt.lunata.hitamado.model.login.LoginEntity
import pt.lunata.hitamado.model.logout.ResponseLogout
import pt.lunata.hitamado.model.newpo.NewpoEntity
import pt.lunata.hitamado.model.newpo.NewpoPostEntity
import pt.lunata.hitamado.model.office.ContinueOfficeEntity
import pt.lunata.hitamado.model.office.OfficeEntity
import pt.lunata.hitamado.model.pickup.ConfirmEntity
import pt.lunata.hitamado.model.pickup.ContinuePickupEntity
import pt.lunata.hitamado.model.pickup.PickupEntity
import pt.lunata.hitamado.model.siapantar.ConfirmSiapAntarEntity
import pt.lunata.hitamado.model.siapantar.ContinueSiapAntarEntity
import pt.lunata.hitamado.model.siapantar.ResponsePostSiapantar
import pt.lunata.hitamado.model.siapantar.SiapAntarEntity

interface SjtDataSource {
    fun getResponseLogin(email: String, password: String, deviceId: String): LiveData<LoginEntity>
    fun getResponseLogout(context: Context):LiveData<ResponseLogout>
    fun getResponsePostNewPo(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity>

    fun getResponseNewpo(context: Context): LiveData<List<NewpoEntity>>
    fun getResponsePostDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity>

    fun getResponseOffice(context: Context): LiveData<List<OfficeEntity>>
    fun getResponseOfficeDriver(context: Context): LiveData<List<OfficeEntity>>
    fun getResponsePostSiapantar(
        context: Context,
        mpoId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<ResponsePostSiapantar>

    fun getResponseSiapAntar(context: Context): LiveData<List<SiapAntarEntity>>
    fun getResponseSiapAntarDriver(context: Context): LiveData<List<SiapAntarEntity>>
    fun getResponsePostDelegasiSiapantar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity>

    fun getResponseDeliverAirline(context: Context): LiveData<List<DeliverAirlineEntity>>
    fun getResponseDeliverAirlineDriver(context: Context): LiveData<List<DeliverAirlineEntity>>
    fun getResponsePostDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<NewpoPostEntity>

    fun getDataDriver(context: Context): LiveData<List<DriverEntity>>
    fun getDataUser(context: Context): LiveData<DriverEntity>
    fun getResponsePickup(context: Context): LiveData<List<PickupEntity>>
    fun getResponseDriverPickup(context: Context): LiveData<List<PickupEntity>>
    fun getResponseConfirm(context: Context, poHouseId: String?): LiveData<ConfirmEntity>
    fun postResponseArrivedToCustomer(context: Context, poHouseId: String?): LiveData<ConfirmEntity>
    fun postResponseContinuePickup(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinuePickupEntity>

    fun postResponseDelegasiPickup(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity>

    fun postArrivedAtOffice(
        context: Context,
        poHouseId: String?
    ): LiveData<pt.lunata.hitamado.model.office.ConfirmEntity>

    fun postResponseContinueOffice(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinueOfficeEntity>

    fun postResponseDelegasiOffice(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity>

    fun postResponseArrivedSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmSiapAntarEntity>

    fun postResponseContinueSiapAntar(
        context: Context,
        poHouseId: String?
    ): LiveData<ContinueSiapAntarEntity>

    fun postResponseDelegasiSiapAntar(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity>

    fun postArrivedDeliverAirline(
        context: Context,
        poHouseId: String?
    ): LiveData<ConfirmDeliverAirlineEntity>

    fun postResponseContinueDeliverAirline(
        context: Context,
        mpoId: String?
    ): LiveData<ContinueDeliverAirlineEntity>

    fun postResponseDelegasiDeliverAirline(
        context: Context,
        poHouseId: String?,
        driverUid: String?,
        description: String?
    ): LiveData<DelegasiEntity>

    fun postCompletedAirline(
        context: Context,
        uid: String,
        weighLini: String,
        collieLini: String,
        weighLini2: String,
        collieLini2: String
    ): LiveData<ResponseSentOperational>

    fun postCompletedAirline2(
        context: Context,
        uid: String,
        weighLini: String,
        collieLini: String
    ): LiveData<ResponseSentOperational>

    fun getResponseDelegasiPickup(context: Context): LiveData<List<NewpoEntity>>
    fun getResponseDelegasiOffice(context: Context): LiveData<List<NewpoEntity>>
    fun getResponseDelegasiSiapantar(context: Context): LiveData<List<NewpoEntity>>
    fun getResponseDelegasiDeliverAirline(context: Context): LiveData<List<SiapAntarEntity>>
    fun getResponseAirline(context: Context): LiveData<List<AirlineEntity>>
    fun getResponseOperationalAirline(context: Context): LiveData<PagedList<DataItem>>
    fun getResponseTotalItemAirline(context: Context):LiveData<TotalEntity>
    fun getResponseSearchAirline(context: Context,mpoId: String?):LiveData<DataItem>
}