package com.example.finaluris_app.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.firebaserecyclerviewkotlin.R

public class FragmentResetDirections private constructor() {
  public companion object {
    public fun actionFragmentResetToFragmentLogin(): NavDirections =
        ActionOnlyNavDirections(R.id.action_fragmentReset_to_fragmentLogin)
  }
}
