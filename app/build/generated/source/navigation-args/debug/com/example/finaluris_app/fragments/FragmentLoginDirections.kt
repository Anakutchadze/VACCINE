package com.example.finaluris_app.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.firebaserecyclerviewkotlin.R

public class FragmentLoginDirections private constructor() {
  public companion object {
    public fun actionFragmentLoginToFragmentRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentRegister)

    public fun actionFragmentLoginToFragmentReset(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentLogin_to_fragmentReset)
  }
}
