package com.example.finaluris_app.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firebaserecyclerviewkotlin.R
import com.google.firebase.auth.FirebaseAuth

class FragmentChange : Fragment(R.layout.fragment_change) {
    private lateinit var oldPass : EditText
    private lateinit var newPass : EditText
    private lateinit var changePass : Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        oldPass = view.findViewById(R.id.oldPassword)
        newPass = view.findViewById(R.id.newPassword)
        changePass = view.findViewById(R.id.user_change_btn)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


        changePass.setOnClickListener{

            val newPassword = oldPass.text.toString()
            val oldPassword = newPass.text.toString()
            if (newPassword.isEmpty() || newPassword.length < 6) {
                Toast.makeText(this@FragmentChange.requireContext(), "Enter new valid password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (oldPassword==newPassword) {
                Toast.makeText(this@FragmentChange.requireContext(), "Old and new Password cannot be same", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (oldPassword.isEmpty()) {
                Toast.makeText(this@FragmentChange.requireContext(), "Enter password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@FragmentChange.requireContext(), "Password updated", Toast.LENGTH_SHORT).show()
                    }

                    else {
                        Toast.makeText(this@FragmentChange.requireContext(), "Password couldn't be changed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
