package android.com.coctel.domain

import android.com.coctel.data.model.DataSource
import android.com.coctel.data.model.Drink
import android.com.coctel.vo.Resource

class RepoImp(private val dataSource: DataSource):Repo {


    override fun getTragosList():Resource<List<Drink>>{
        return dataSource.getTragosList()

    }
}