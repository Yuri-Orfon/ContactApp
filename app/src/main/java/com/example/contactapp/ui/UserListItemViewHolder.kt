package com.example.contactapp.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.R
import com.example.contactapp.data.model.User
import com.example.contactapp.databinding.ListItemUserBinding
import com.example.contactapp.utils.insertImage

class UserListItemViewHolder(
    private val binding: ListItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        binding.run {
            name.text = user.name
            username.text = user.userName

            insertImage(
                image = user.img,
                error = R.drawable.ic_round_account_circle,
                imageView = picture
            )
        }
    }
}