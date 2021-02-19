package android.com.coctel.data.model

import android.com.coctel.vo.Resource

class DataSource {

  private  val generateTragosList = listOf(
        Drink("https://cocina-casera.com/wp-content/uploads/2017/11/C%C3%B3ctel-Margarita.jpg","Margarita","Con azucar, vodka y nueces"),
        Drink("https://images.clarin.com/2020/04/07/fernet-con-cola-foto-instagram___N-oobYIWz_340x340__1.jpg", "Fernet", "Fernet con coca y dos hielos")

    )
    fun getTragosList():Resource<List<Drink>>{
        return Resource.Success(generateTragosList)
    }
}