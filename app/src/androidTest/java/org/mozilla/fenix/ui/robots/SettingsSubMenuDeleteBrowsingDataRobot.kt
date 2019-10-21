/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

@file:Suppress("TooManyFunctions")

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers

/**
 * Implementation of Robot Pattern for the settings search sub menu.
 */
class SettingsSubMenuDeleteBrowsingDataRobot {
    fun verifyOpenTabs() = assertOpenTabs()
    fun verifyOpenTabsCount() = assertOpenTabsCount()
    fun verifyBrowsingHistory() = assertBrowsingHistory()
    fun verifyBrowsingHistoryCount() = assertBrowsingHistoryCount()
    fun verifyCollections() = assertCollections()
    fun verifyCollectionsCount() = assertCollectionsCount()
    fun verifyCookies() = assertCookies()
    fun verifyCookiesDescription() = assertCookiesDescription()
    fun verifyCached() = assertCached()
    fun verifyCachedDescription() = assertCachedDescription()
    fun verifySitePermissions() = assertSitePermissions()
    fun verifyDeleteBrowsingDataButton() = assertDeleteBrowsingDataButton()

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        fun goBack(interact: SettingsRobot.() -> Unit): SettingsRobot.Transition {
            mDevice.waitForIdle()
            goBackButton().perform(ViewActions.click())

            SettingsRobot().interact()
            return SettingsRobot.Transition()
        }
    }
}

private fun assertOpenTabs() {
    onView(ViewMatchers.withText("Open Tabs"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertOpenTabsCount() {
    onView(ViewMatchers.withText("0 tabs"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertBrowsingHistory() {
    onView(ViewMatchers.withText("Browsing history and site data"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertBrowsingHistoryCount() {
    onView(ViewMatchers.withText("0 addresses"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCollections() {
    onView(ViewMatchers.withText("Collections"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCollectionsCount() {
    onView(ViewMatchers.withText("0 collections"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCookies() {
    onView(ViewMatchers.withText("Cookies"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCookiesDescription() {
    onView(ViewMatchers.withText("You'll be logged out of most sites"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCached() {
    onView(ViewMatchers.withText("Cached images and files"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertCachedDescription() {
    onView(ViewMatchers.withText("Frees up storage space"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertSitePermissions() {
    onView(ViewMatchers.withText("Site permissions"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun assertDeleteBrowsingDataButton() {
    onView(ViewMatchers.withText("Delete browsing data"))
        .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

private fun goBackButton() =
    onView(CoreMatchers.allOf(ViewMatchers.withContentDescription("Navigate up")))
