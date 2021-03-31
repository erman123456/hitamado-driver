package pt.lunata.hitamado.data.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {
        var gson = GsonBuilder()
            .setLenient()
            .create()
        private fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        }
        fun getApiService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://crm.hitamado.com/api")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(provideOkHttpClient())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}