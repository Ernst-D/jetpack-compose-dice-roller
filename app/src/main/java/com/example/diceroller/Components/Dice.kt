package com.example.diceroller.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.R

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    Column (modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        var result by remember {
            mutableIntStateOf(1)
        }

        Image(painter = painterResource(id = R.drawable.dice_1), contentDescription ="Roll: $result")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            println("Increment roll")
            result++
        }) {
            Text(stringResource(id = R.string.dice_text)+" $result")
        }
    }
}

@Preview(name = "dice-with-btn-and-image-preview", showBackground = true)
@Composable
fun DiceWithButtonAndImagePreview(modifier: Modifier = Modifier){
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center))
}