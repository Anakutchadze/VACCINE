package com.example.firebaserecyclerviewkotlin.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.firebaserecyclerviewkotlin.R
import com.example.firebaserecyclerviewkotlin.User
import com.example.firebaserecyclerviewkotlin.User2
import com.example.firebaserecyclerviewkotlin.databinding.FragmentDashboardBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.microedition.khronos.egl.EGLDisplay

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private lateinit var vacname : EditText
    private lateinit var vacsurname : EditText
    private lateinit var vacaddress : EditText
    private lateinit var vacid : EditText
    private lateinit var vacvac : EditText
    private lateinit var vacbtn : Button
    private lateinit var database : DatabaseReference
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vacname = view.findViewById(R.id.vacname)
        vacsurname = view.findViewById(R.id.vacsurname)
        vacaddress = view.findViewById(R.id.vacadd)
        vacid = view.findViewById(R.id.vacid)
        vacvac = view.findViewById(R.id.vacvac)
        vacbtn = view.findViewById(R.id.vacbtn)



        vacbtn.setOnClickListener {
            var name = vacname.text.toString()
            var surname = vacsurname.text.toString()
            var address = vacaddress.text.toString()
            var vacid = vacid.text.toString()
            var vac = vacvac.text.toString()

            if (name.isEmpty()) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (surname.isEmpty()) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input surname", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (address.isEmpty()) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (vac.isEmpty()) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input vaccine name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (vacid.isEmpty()) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input your ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (vacid.length !=11) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input your correct ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (address.length < 6) {
                Toast.makeText(this@DashboardFragment.requireActivity(), "input correct address", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else
                database= FirebaseDatabase.getInstance().getReference("Reserved Users")
                database.child(vacid).setValue(User2(name, surname, vac, address))
        }







    }
}
