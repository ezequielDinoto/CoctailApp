package android.com.coctel.ui.viewmodel

import android.com.coctel.domain.Repo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class VMFactory(private val  repo: Repo) :ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repo::class.java).newInstance(repo)

    }
}