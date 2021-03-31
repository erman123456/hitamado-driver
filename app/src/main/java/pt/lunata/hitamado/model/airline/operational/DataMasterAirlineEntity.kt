package pt.lunata.hitamado.model.airline.operational

data class DataMasterAirlineEntity(
    val total: Int? = null,
    val data: List<DataItemAirlineEntity>? = null,
    val lastPage: Int? = null
)