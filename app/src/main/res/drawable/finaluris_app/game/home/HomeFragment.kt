package com.example.finaluris_app.game.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finaluris_app.MyAdapter
import com.example.finaluris_app.R
import com.example.finaluris_app.User
import com.example.finaluris_app.databinding.FragmentHomeBinding
import com.google.firebase.database.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        userRecyclerview = view.findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this@HomeFragment.requireActivity())
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()
        getUserData()
    }

        private fun getUserData() {

            dbref = FirebaseDatabase.getInstance().getReference("Vaccines")

            dbref.addValueEventListener(object : ValueEventListener{

                override fun onDataChange(snapshot: DataSnapshot) {

                    if (snapshot.exists()){

                        for (userSnapshot in snapshot.children){


                            val user = userSnapshot.getValue(User::class.java)
                            userArrayList.add(user!!)

                        }

                        userRecyclerview.adapter = MyAdapter(userArrayList)


                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@HomeFragment.requireActivity(), "oi", Toast.LENGTH_SHORT).show()
                }


            })

        }
    }