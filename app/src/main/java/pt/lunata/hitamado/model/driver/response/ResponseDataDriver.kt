package pt.lunata.hitamado.model.driver.response

import com.google.gson.annotations.SerializedName

data class ResponseDataDriver(

	@field:SerializedName("driver")
	val driver: List<DriverItem?>? = null
)