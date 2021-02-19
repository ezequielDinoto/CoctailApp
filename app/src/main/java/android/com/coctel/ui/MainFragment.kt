package android.com.coctel.ui

import android.com.coctel.R
import android.com.coctel.data.model.DataSource
import android.com.coctel.data.model.Drink
import android.com.coctel.domain.RepoImp
import android.com.coctel.ui.viewmodel.MainAdapter
import android.com.coctel.ui.viewmodel.MainViewModel
import android.com.coctel.ui.viewmodel.VMFactory
import android.com.coctel.vo.Resource
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainAdapter.OnTragoClickListener {
    private val viewModel by viewModels<MainViewModel> { VMFactory(RepoImp(DataSource())) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        viewModel.fetchTragosList.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    progressBar.visibility = View.GONE
                    rv_tragos.adapter = MainAdapter(requireContext(), result.data, this)

                }
                is Resource.Failure -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Ocurrio un error al ttaer los datos ${result.exception}", Toast.LENGTH_SHORT).show()
                }
                }
            })
        }



    override fun onTragoClick(drink: Drink) {
        val bundle=Bundle()
        bundle.putParcelable("drink",drink)//@Parcelabe en Drink
        findNavController().navigate(R.id.action_mainFragment_to_detailFragment,bundle)//me lleva a los detallea de ese trago
    }



        private fun setupRecyclerView(){
            rv_tragos.layoutManager = LinearLayoutManager(requireContext())
            rv_tragos.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        }

}