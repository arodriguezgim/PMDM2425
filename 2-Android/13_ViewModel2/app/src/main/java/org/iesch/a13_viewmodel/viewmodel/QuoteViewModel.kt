package org.iesch.a13_viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.iesch.a13_viewmodel.model.QuoteModel
import org.iesch.a13_viewmodel.model.QuoteProvider

//Para convertir esta clase en ViewModel ha de extender de ViewModel
class QuoteViewModel : ViewModel() {

    // 1 Encapsulamos el model que queremos en un LiveData. Ha de ser Mutable porque su valor va a ir cambiando.
    val quoteModel = MutableLiveData<QuoteModel>()
    // 2 Este quoteModel va a ir cambiando con esta funcion, que va a ser llamada desde la activity
    fun randomQuote() {
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }
}