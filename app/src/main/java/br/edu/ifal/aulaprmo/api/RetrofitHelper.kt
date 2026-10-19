package br.edu.ifal.aulaprmo.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitHelper {

    private val client = Retrofit.Builder()
        .baseUrl("https://brasilapi.com.br/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val addressApi = client.create(AddressApi::class.java)
}