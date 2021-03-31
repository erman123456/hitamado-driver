package pt.lunata.hitamado.data.remote.page

import androidx.paging.DataSource
import pt.lunata.hitamado.model.airline.operational.DataItem
import javax.inject.Inject

class OperationalPageFactory @Inject constructor(private val operationalPageDataSource: OperationalPageDataSource) :
    DataSource.Factory<Int, DataItem>() {
    override fun create(): DataSource<Int, DataItem> {
        return operationalPageDataSource
    }
}