package android.com.coctel.ui.viewmodel

import android.com.coctel.domain.Repo
import android.com.coctel.vo.Resource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel (private val repo: Repo):ViewModel() {

    val fetchTragosList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getTragosList())

        }catch (e: Exception){

        }
    }


}
