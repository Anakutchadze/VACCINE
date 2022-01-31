package com.example.firebaserecyclerviewkotlin.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserecyclerviewkotlin.MyAdapter
import com.example.firebaserecyclerviewkotlin.R
import com.example.firebaserecyclerviewkotlin.User
import com.google.firebase.database.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerview : RecyclerView
    private lateinit var userArrayList : ArrayList<User>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        userRecyclerview = view.findViewById(R.id.userList)
        userRecyclerview.layoutManager = LinearLayoutManager(this@HomeFragment.requireActivity())
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<User>()
        getUserData()

    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Vaccines")

        dbref.addValueEventListener(object : ValueEventListener {

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
                Toast.makeText(this@HomeFragment.requireActivity(), "input information", Toast.LENGTH_SHORT).show()
            }
        })

    }
}