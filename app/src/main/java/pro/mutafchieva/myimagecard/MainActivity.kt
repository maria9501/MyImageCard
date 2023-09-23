package pro.mutafchieva.myimagecard

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.mutafchieva.myimagecard.ui.theme.MyImageCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var painter = painterResource(id = R.drawable.card_background)
            ImageCard(painter = painter, descrContent ="bacground with flowers" , title ="Maria Mutafchieva, Android Developer" , modifier = Modifier)
        }
    }

    @Composable
    fun ImageCard(
        painter: Painter,
        descrContent: String,
        title: String,
        modifier: Modifier
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.Gray)){
            Card(modifier= modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(30.dp,30.dp,30.dp,30.dp),
            elevation =  CardDefaults.cardElevation(5.dp)
        ) {
                Row(Modifier.background(color = Color.DarkGray)) {
                    Box(Modifier.fillMaxWidth(0.5f)) {
                        Image(
                            painter = painter,
                            contentDescription = descrContent,
                            contentScale = ContentScale.Crop
                        )
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Text(
                                text = title,
                                style = TextStyle(color = Color.Red, fontSize = 20.sp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start=6.dp)
                        .background(Color.Magenta),
                        contentAlignment = Alignment.BottomEnd) {
                        Text(
                            text = "Find more from me in Github",
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 12.sp,
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(15.dp)
                        )
                    }
                }
            }
        }
    }

//    fun Modifier.rightBorder(strokeWidth: Dp, color: Color) = composed(
//        factory = {
//            val density = LocalDensity.current
//            val strokeWidthPx = density.run { strokeWidth.toPx() }
//
//            Modifier.drawBehind {
//                val width = size.width
//                val height = size.height - strokeWidthPx/2
//
//                drawLine(
//                    color = color,
//                    start = Offset(x = 0f, y = height),
//                    end = Offset(x = width , y = height),
//                    strokeWidth = strokeWidthPx
//                )
//            }
//        }
//    )

    @Preview
    @Composable
    fun preview(){

    }
}
