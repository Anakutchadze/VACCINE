package com.example.firebaserecyclerviewkotlin.ui.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.firebaserecyclerviewkotlin.MainActivity
import com.example.firebaserecyclerviewkotlin.R
import com.google.firebase.auth.FirebaseAuth

class NotificationsFragment : Fragment(R.layout.fragment_settings) {
    private lateinit var changeFragment : Button
    private lateinit var logOutAcc : Button
    private lateinit var btnshop : Button
    private lateinit var btncontacts : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeFragment = view.findViewById(R.id.button)
        logOutAcc= view.findViewById(R.id.button2)
        btnshop= view.findViewById(R.id.shop_btn)
        btncontacts= view.findViewById(R.id.contact)

        val navController = Navigation.findNavController(view)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()

        changeFragment.setOnClickListener {
            val change = NotificationsFragmentDirections.actionNavigationNotificationsToFragmentChange()
            navController.navigate(change)

        }

        logOutAcc.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@NotificationsFragment.requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        btnshop.setOnClickListener {
            val website = "http://bih.ge/"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(website)
            startActivity(intent)
        }

        btncontacts.setOnClickListener {
            val contact = NotificationsFragmentDirections.actionNavigationNotificationsToFragmentContacts()
            navController.navigate(contact)
        }
    }
}

