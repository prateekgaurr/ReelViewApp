package com.prateek.reelapp.util

sealed class FetchData<T : Any> {

    class Loading<T : Any>() : FetchData<T>()
    class Success<T: Any>(val data: T) : FetchData<T>()
    class KnownError<T: Any>(val message: String) : FetchData<T>()
    class UnknownError<T: Any>() : FetchData<T>()

}