package android.com.coctel.domain

import android.com.coctel.data.model.Drink
import android.com.coctel.vo.Resource

interface Repo {
    fun getTragosList(): Resource<List<Drink>>
}