package aaa.bivizul.a37project.ui.howdoewidget

import aaa.bivizul.a37project.domain.util.Howdoecon
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage

@Composable
actual fun Howdoeibl() {

    val howdoeorient = LocalConfiguration.current.orientation
    val howdoeImgModel = when (howdoeorient) {
        Configuration.ORIENTATION_PORTRAIT -> Howdoecon.HOWDOEBV
        else -> Howdoecon.HOWDOEBH
    }

    AsyncImage(
        model = howdoeImgModel,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
    )

}