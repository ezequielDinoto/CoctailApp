package android.com.coctel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    //   lateinit var binding : ActivityMainBinding

    //private  val viewModel by viewModels<MainViewModel>{VMFactory(RepoImpl(DataSource()))}//inyecta dependencias
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        // val view = binding.root
        setContentView(R.layout.activity_main)
        //  setContentView(view)

        navController = findNavController(R.id.nav_host_fragment)// rs el fragment que esta en el activity_main
        NavigationUI.setupActionBarWithNavController(this, navController)

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}