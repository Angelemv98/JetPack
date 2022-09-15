package com.example.ecrecycler.ui

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecrecycler.DetailsActivity
import com.example.ecrecycler.R

class ScreenRecycler {
    @Preview
    @Composable
    fun AppRecycler() {
        listasdeusuario(RepositoryUsers.listUsers)
    }

    @Composable
    fun listasdeusuario(userslist: List<UsersRecycler>) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 2.dp, bottom = 2.dp)
                    .fillMaxWidth()
            ) {
                items(userslist) {
                    cardvista(it)
                }
            }
        }
    }

    @Composable
    fun cardvista(datosUsuarios: UsersRecycler) {
        val ctx = LocalContext.current
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    Toast
                        .makeText(
                            ctx,
                            "Has clickeado sobre el card de \n ${datosUsuarios.nameUser}",
                            Toast.LENGTH_LONG
                        )
                        .show()
                    val intent = Intent(ctx, DetailsActivity::class.java)
                    intent.putExtra("NameUser", datosUsuarios.nameUser)
                    ctx.startActivity(intent)
                })
                .padding(horizontal = 5.dp, vertical = 5.dp)
                .background(color = Color.White),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, Color.Blue)
        ) {
            Row() {
                Imagen(R.drawable.ic_ekko)
                Column() {
                    Titulo(datosUsuarios.nameUser)
                    Texto(datosUsuarios.textSecundary)
                }
                ImagenFinal(R.drawable.ic_favorite)
            }
        }
    }
}

@Composable
fun Imagen(ruta: Int) {
    Image(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
        painter = painterResource(id = ruta),
        contentDescription = R.string.app_name.toString(),
        alignment = Alignment.TopStart
    )
}

@Composable
fun ImagenFinal(ruta: Int) {
    Image(
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(100.dp))),
        painter = painterResource(id = ruta),
        contentDescription = R.string.app_name.toString(),
        alignment = Alignment.TopEnd
    )
}

@Composable
fun Titulo(Titulo: String) {
    Text(
        text = Titulo,
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .width(230.dp)
            .padding(0.dp, 10.dp, 0.dp, 0.dp)
    )
}

@Composable
fun Texto(texto: String) {
    Text(
        text = texto,
        style = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .width(230.dp)
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
    )
}
