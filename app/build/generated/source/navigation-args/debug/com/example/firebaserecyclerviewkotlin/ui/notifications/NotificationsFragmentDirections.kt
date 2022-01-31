package com.example.firebaserecyclerviewkotlin.ui.notifications

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.firebaserecyclerviewkotlin.R

public class NotificationsFragmentDirections private constructor() {
  public companion object {
    public fun actionNavigationNotificationsToFragmentContacts(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_notifications_to_fragmentContacts)

    public fun actionNavigationNotificationsToFragmentChange(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_notifications_to_fragmentChange)
  }
}
