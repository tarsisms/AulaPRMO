package br.edu.ifal.aulaprmo.api

import br.edu.ifal.aulaprmo.domain.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AddressApi {

    @GET("cep/v1/{cep}")
    fun findByCep(@Path("cep") cep : String): Call<Address>

    @GET("cep/v1/{cep}")
    suspend fun findByCepCoroutine(@Path("cep") cep : String): Address



}