package com.example.diceroller

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.diceroller.Components.DiceWithButtonAndImage
import com.example.diceroller.ui.theme.DiceRollerTheme
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class DiceRollerComposeTest {
    @get:Rule
    val composeTestRule = createComposeRule();

    @Test
    fun testRunAppAndTapRollBtn(){
        composeTestRule.setContent {
            DiceRollerTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceWithButtonAndImage(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center))
                }
            }
        }

        composeTestRule.onNodeWithText("Roll", substring = true).performClick()
        composeTestRule.onNodeWithText("Roll", substring = true).assert(hasText("Roll", substring = true))
    }

    @Test
    fun testBaseCounter() {
        val myCounter = mutableStateOf(0) // State that can cause recompositions
        var lastSeenValue = 0 // Used to track recompositions
        composeTestRule.setContent {
            Text(myCounter.value.toString())
            lastSeenValue = myCounter.value
        }
        myCounter.value = 1 // The state changes, but there is no recomposition

        composeTestRule.waitForIdle()
        // Passes because the assertion triggers recomposition
        composeTestRule.onNodeWithText("1").assertExists()
        // Fails because nothing triggered a recomposition
        assertTrue(lastSeenValue == 1)
    }
}