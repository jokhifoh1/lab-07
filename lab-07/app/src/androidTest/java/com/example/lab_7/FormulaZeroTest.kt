package com.example.lab_7

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_drivers_clear_drivers_and_return_home() {
        // navigate to driver screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name 1
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Hazel Campbell")

        // add driver name 1
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // enter driver name 2
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Abram Hindle")

        // add driver name 2
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver 1 appears
        composeTestRule
            .onNodeWithText("Hazel Campbell")
            .assertExists()

        // verify driver 2 appears
        composeTestRule
            .onNodeWithText("Abram Hindle")
            .assertExists()

        // clear drivers from screen
        composeTestRule
            .onNodeWithTag("driverClearButton")
            .performClick()

        // verify drivers disappear
        composeTestRule
            .onNodeWithTag("driverList")
            .onChildren()
            .assertCountEquals(0)

        // return to home screen
        composeTestRule
            .onNodeWithTag("driverBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}