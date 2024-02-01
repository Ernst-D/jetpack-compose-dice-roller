package com.example.diceroller.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.R

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    Column (modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.dice_1), contentDescription = "Dice")
        Button(onClick = { /*TODO*/ }) {
            Text(stringResource(id = R.string.dice_text))
        }
    }
}

@Preview(name = "dice-with-btn-and-image-preview", showBackground = true)
@Composable
fun DiceWithButtonAndImagePreview(modifier: Modifier = Modifier){
    DiceWithButtonAndImage(
        modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize())
}