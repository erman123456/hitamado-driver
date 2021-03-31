package pt.lunata.hitamado.data

import androidx.paging.PagedList

class ConfigClass {
    fun createConfig(): PagedList.Config {
        val configBuilder = PagedList.Config.Builder()
        return configBuilder
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(1)
            .setPrefetchDistance(10)
            .setPageSize(10)
            .build()
    }
}