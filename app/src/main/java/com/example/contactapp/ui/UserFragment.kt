package com.example.contactapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapp.R
import com.example.contactapp.data.model.User
import com.example.contactapp.databinding.FragmentUserBinding
import com.example.contactapp.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()
    private lateinit var binding: FragmentUserBinding
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListeners()
        setObservers()

        viewModel.handleIntent(UserIntent.InitAdapter)
    }

    private fun setListeners() {
        binding.userListProgressBar.setVisible(true)
    }

    private fun setObservers() {
        viewModel.run {
            state.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is UserState.DisplayUsers -> onSuccess(state.response)
                    is UserState.DisplayError -> onError()
                }
            }
        }
    }


    private fun onSuccess(response: List<User>) {
        binding.userListProgressBar.setVisible(false)

        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.users = response
    }

    private fun onError() {
        val message = getString(R.string.error)

        binding.userListProgressBar.setVisible(false)
        binding.recyclerView.setVisible(false)

        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }
}