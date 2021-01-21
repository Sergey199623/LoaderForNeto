package ru.sergey.netology.i

import retrofit2.Call
import retrofit2.http.GET
import ru.sergey.netology.pojo.DataContainer
import ru.sergey.netology.utils.Constants

interface IApi {
    @get:GET(Constants.API_URL_END)
    val data: Call<DataContainer?>
}