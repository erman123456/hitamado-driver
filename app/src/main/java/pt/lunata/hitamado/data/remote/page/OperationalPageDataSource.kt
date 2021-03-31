package pt.lunata.hitamado.data.remote.page

import android.content.Context
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import pt.lunata.hitamado.data.remote.RemoteDataSource
import pt.lunata.hitamado.model.airline.operational.DataItem
import pt.lunata.hitamado.model.airline.operational.Master
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OperationalPageDataSource @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val context: Context
) :
    PageKeyedDataSource<Int, DataItem>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DataItem>
    ) {
        remoteDataSource.getResponseAirlineOperational(
            context = context,
            callback = object : RemoteDataSource.LoadResponseAirlineOperationalCallback {
                override fun onGetResponseAirlineOperational(response: Master?) {
                    response?.data?.let { callback.onResult(it, null, response.currentPage+1) }
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataItem>) {
        if (params.key == -1) return

        remoteDataSource.getResponseAirlineOperational(
            context = context,
            page = params.key,
            callback = object : RemoteDataSource.LoadResponseAirlineOperationalCallback {
                override fun onGetResponseAirlineOperational(response: Master?) {
                    Toast.makeText(context,"Memuat data..",Toast.LENGTH_SHORT).show()
                    response?.data?.let { callback.onResult(it, response.currentPage+1) }
                }
            })
    }
}