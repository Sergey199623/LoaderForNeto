package ru.sergey.netology.model

import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sergey.netology.i.IApi
import ru.sergey.netology.i.IModel
import ru.sergey.netology.i.IPresenter
import ru.sergey.netology.pojo.Data
import ru.sergey.netology.pojo.DataContainer
import ru.sergey.netology.utils.Constants
import java.util.*

class DataModel(private val presenter: IPresenter) : IModel {
    //httpClient.addInterceptor(logging);
    override val data: Unit
        get() {
            Retrofit.Builder()
                    .baseUrl(Constants.API_URL_START)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IApi::class.java)
                    .data
                    .enqueue(object : Callback<DataContainer?> {
                        override fun onResponse(call: Call<DataContainer?>, response: Response<DataContainer?>) {
                            if (response.isSuccessful && response.body() != null && response.body()!!.data != null) {
                                presenter.showData(response.body()!!.data as ArrayList<Data>)
                            } else onFailure(call, Throwable())
                        }

                        override fun onFailure(call: Call<DataContainer?>, t: Throwable) {
                            presenter.showError(Constants.MSG_ERROR)
                        }
                    })
        }
}