package com.example.finaluris_app.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.*
import com.example.firebaserecyclerviewkotlin.R
import com.google.firebase.auth.FirebaseAuth

class FragmentReset : Fragment(R.layout.fragment_reset) {

    private lateinit var resetEmail : EditText
    private lateinit var sendReset : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        resetEmail = view.findViewById(R.id.reset_email)
        sendReset = view.findViewById(R.id.reset_btn)
        val navController = findNavController(view)
        super.onViewCreated(view, savedInstanceState)
        sendReset.setOnClickListener{
            val email = resetEmail.text.toString()

            if(email.isEmpty()){
                Toast.makeText(this@FragmentReset.requireActivity(), "Enter email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@FragmentReset.requireActivity(), "Check your email", Toast.LENGTH_SHORT).show()
                        val login = FragmentResetDirections.actionFragmentResetToFragmentLogin()
                        navController.navigate(login)

                    }
                    else {
                        Toast.makeText(this@FragmentReset.requireActivity(), "Account not found", Toast.LENGTH_SHORT).show()
                    }


                }


        }
    }


}