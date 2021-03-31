package pt.lunata.hitamado.model.driver.response

import com.google.gson.annotations.SerializedName

data class ResponseSpecificDataUser(
    @field:SerializedName("specific_driver_data")
    val specificDriverData: DriverItem? = null
)