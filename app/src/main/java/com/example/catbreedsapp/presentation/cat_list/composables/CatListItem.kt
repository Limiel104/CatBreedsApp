package com.example.catbreedsapp.presentation.cat_list.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.catbreedsapp.data.model.Cat

@Composable
fun CatListItem(
    cat: Cat,
    onItemClick: (Cat) -> Unit
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(cat) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = cat.name,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if(cat.hypoallergenic == 1) "Hypoallergenic" else "",
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.End,
                modifier = Modifier.align(CenterVertically)
            )
        }
}