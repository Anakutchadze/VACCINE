package com.example.finaluris_app.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.firebaserecyclerviewkotlin.R

public class FragmentRegisterDirections private constructor() {
  public companion object {
    public fun actionFragmentRegisterToFragmentLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentRegister_to_fragmentLogin)
  }
}
