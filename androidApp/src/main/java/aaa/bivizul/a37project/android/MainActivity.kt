package aaa.bivizul.a37project.android

import aaa.bivizul.a37project.domain.util.checkHowdoenet
import aaa.bivizul.a37project.domain.util.getHowdoedlg
import aaa.bivizul.a37project.ui.howdoewidget.Howdoeibl
import aaa.bivizul.a37project.ui.root.RootComponent
import aaa.bivizul.a37project.ui.root.RootContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.defaultComponentContext

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0x920765A3),
            background = Color(0xE4242304),
            secondary = Color(0x9FE70E0E),
            onPrimary = Color(0xFFCFCFCF),
            onBackground = Color(0xFFCFCFCF),
        )
    } else {
        lightColors(
            primary = Color(0x920693F0),
            background = Color(0xE4E9E617),
            secondary = Color(0x9FE70E0E),
            onPrimary = Color(0xFF181818),
            onBackground = Color(0xFF000000),
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(18.dp),
        large = RoundedCornerShape(28.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkHowdoenet(this)) {
            val root = RootComponent(
                componentContext = defaultComponentContext(),
                context = this@MainActivity
            )
            setContent {
                MyApplicationTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Howdoeibl()
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.background)
                        )
                        RootContent(rootModel = root)
                    }
                }
            }
        } else {
            getHowdoedlg(this)
        }
    }
}

