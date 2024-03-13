package com.prateek.reelapp.data.repository

import android.util.Log
import com.prateek.reelapp.util.FetchData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import org.json.JSONObject
import java.net.SocketTimeoutException

open class BaseRepository {

    suspend fun <T : Any> executeNetworkRequest(call: suspend () -> Response<T>): Flow<FetchData<T>> = flow {
        Log.i("NetworkRequest", "Emitting Loading State for network call $call")
        emit(FetchData.Loading())
        try {
            val response = call()

            Log.d("NetworkRequest", "${response.isSuccessful} \n ${response.body().toString()} \n ${response.errorBody().toString()} \n ${response.message()}")

            if (response.isSuccessful && response.body() != null) {
                val body = response.body()
                Log.i("NetworkRequest", "Emitting Success State for network call $call, Success Body is $body")
                emit(FetchData.Success(body!!))
            } else if (response.isSuccessful && response.body() == null) {
                Log.i("NetworkRequest", "Emitting Unknown Error State for network call $call response code is ${response.code()} but the response body is empty")
                emit(FetchData.UnknownError())
            } else if (response.errorBody() != null) {
                Log.i("NetworkRequest", "Emitting Known Error State for network call $call, Response code is ${response.code()} and Error is ${response.message()} ")
                val jsonObject = JSONObject(response.errorBody()!!.string())
                emit(FetchData.KnownError(jsonObject.get("message") as String))
            } else {
                Log.i("NetworkRequest", "Emitting Unknown Error State for network call $call, Response code is ${response.code()}, ELSE case")
                emit(FetchData.UnknownError())
            }
        } catch (e: SocketTimeoutException) {
            Log.i("NetworkRequest", "Emitting Known Error for network call $call, Exception is ${e.stackTrace}")
            e.printStackTrace()
            emit(FetchData.KnownError("Please check your internet connectivity"))
        } catch (e: Exception) {
            Log.i("NetworkRequest", "Emitting Unknown Error for network call $call, Exception is ${e.stackTrace}")
            e.printStackTrace()
            emit(FetchData.UnknownError())
        }
    }

    suspend fun <T : Any> executeDatabaseOperation(databaseCall: suspend () -> T): Flow<FetchData<T>> = flow {
        Log.i("DatabaseRequest", "Emitting Loading State for database operation")
        emit(FetchData.Loading())
        try {
            val result = databaseCall()
            Log.i("DatabaseRequest", "Emitting Success State for database operation")
            emit(FetchData.Success(result))
        } catch (e: Exception) {
            Log.i("DatabaseRequest", "Emitting Unknown Error for database operation, Exception is ${e.stackTrace}")
            e.printStackTrace()
            emit(FetchData.UnknownError())
        }
    }

}
