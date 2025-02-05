package br.edu.ifal.aulaprmo.service

import android.util.Log
import br.edu.ifal.aulaprmo.api.RetrofitHelper
import br.edu.ifal.aulaprmo.domain.Address

class AddressService {

    private val addressApi = RetrofitHelper().addressApi

    suspend fun findByCep(cep: String): Address? {
        try {
            val address = addressApi.findByCepCoroutine(cep)
            return address
        } catch (e : Exception) {
            // NAO FACAM COMO O DUDU
            Log.e("AddressService", "findByCep: ", e)
            return null
        }
    }
}