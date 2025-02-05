package br.edu.ifal.aulaprmo.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitHelper {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://brasilapi.com.br/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val addressApi = retrofit.create(AddressApi::class.java)
}