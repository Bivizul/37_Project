@file:Suppress("DEPRECATION")

package aaa.bivizul.a37project.domain.util

import aaa.bivizul.a37project.domain.util.Howdoecon.HOWDOEACTIVITY
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*
import kotlin.coroutines.CoroutineContext

actual val howdoeUiDispatcher: CoroutineContext = Dispatchers.Main

actual val howdoeIoDispatcher: CoroutineContext = Dispatchers.IO

actual fun getHowdoemm(): String {
    val manfachowdoe = android.os.Build.MANUFACTURER
    val modelhowdoe = android.os.Build.MODEL
    return "$manfachowdoe $modelhowdoe"
}

actual fun getHowdoesim(howdoecon: Any): String {
    val context = howdoecon as Context
    val telmanhowdoe = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telmanhowdoe.simCountryIso
}

actual fun getHowdoeid(howdoecon: Any): String {
    val context = howdoecon as Context
    val sharedPreferences = context.getSharedPreferences("appprefhowdoe", Context.MODE_PRIVATE)
    var howdoeid = sharedPreferences.getString("howdoe_key", "nohowdoe") ?: "nohowdoe"
    if (howdoeid == "nohowdoe") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        howdoeid = datetime + randomNum
        sharedPreferences.edit().putString("howdoe_key", howdoeid).apply()
    }
    return howdoeid
}

actual fun getHowdoel(): String {
    return Locale.getDefault().language
}

actual fun getHowdoet(): String {
    val howdoetz: String = SimpleDateFormat("z", Locale.getDefault()).format(
        Calendar.getInstance(
            TimeZone.getTimeZone("GMT"),
            Locale.getDefault()
        ).time
    ).replace("GMT", "")
    val howdoezone = if (howdoetz.contains(":")) howdoetz else "default"
    return howdoezone
}

actual fun getHowdoedlg(howdoecon: Any) {
    val context = howdoecon as Context
    val activity = howdoecon as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Sorry, error connect complete")
        setMessage("Please try again later, push exit")
        setPositiveButton("Exit") { _, _ ->
            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

@SuppressLint("MissingPermission")
actual fun checkHowdoenet(howdoecon: Any): Boolean {
    val context = howdoecon as Context
    val conmanhowdoe =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netinfhowdoe = conmanhowdoe.activeNetworkInfo
    return netinfhowdoe != null && netinfhowdoe.isConnected
}

actual fun sigHowdoeoff() {
    OneSignal.disablePush(true)
}

actual fun getHowdoeact(howdoeact: Any, howdoeurl: String) {
    val activity = howdoeact as Activity
    val howdoec = Class.forName(HOWDOEACTIVITY)
    val howdoei = Intent(activity, howdoec)
    val put = howdoei.putExtra(Howdoecon.HOWDOEKOR, howdoeurl)
    activity.startActivity(put)
}