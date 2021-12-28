package com.cdpete.meditationcomposeui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cdpete.MeditationComposeUI.R
import com.cdpete.meditationcomposeui.ui.theme.ButtonBlue
import com.cdpete.meditationcomposeui.ui.theme.DarkerButtonBlue
import com.cdpete.meditationcomposeui.ui.theme.DeepBlue
import com.cdpete.meditationcomposeui.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ) {
        Column {
            GreetingSection()
            OptionSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression", "Hungry"))
        }
    }
}

@Composable
fun GreetingSection(
    name: String = "Chayapam S."
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h2
            )
            Text(
                text = "We wish you have a good day",
                style = MaterialTheme.typography.body1
            )
        }

        Icon(
            painterResource(id = R.drawable.ic_search),
            contentDescription = "Search"
        )
    }
}

@Composable
fun OptionSection(chips: List<String>) {
    var checkedIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(count = chips.size) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        end = 15.dp,
                        bottom = 15.dp
                    )
                    .clickable {
                        checkedIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (checkedIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(16.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}