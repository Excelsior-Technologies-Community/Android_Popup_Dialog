package com.ext.android_popup_dialog

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.ext.android_popupdialog.DialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var dialogBuilder: DialogBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.BLACK
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                0, // no light icons
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        }

        dialogBuilder = DialogBuilder(this)
        setupDialogButtons()
    }

    private fun setupDialogButtons() {

        findViewById<Button>(R.id.btnDefaultProgress).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.DEFAULT_PROGRESS,
                message = "Loading data...",
                messageColor = Color.BLUE
            )
            it.postDelayed({ dialogBuilder.dismissDialog() }, 3000)
        }

        findViewById<Button>(R.id.btnLottieProgress).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.LOTTIE_PROGRESS,
                message = "Processing...",
                messageColor = Color.MAGENTA
            )
            it.postDelayed({ dialogBuilder.dismissDialog() }, 3000)
        }

        findViewById<Button>(R.id.btnStandardDialog).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.STANDARD,
                title = "Standard Dialog",
                message = "This is a standard dialog with two buttons. What would you like to do?",
                positiveText = "Accept",
                negativeText = "Decline",

                onPositive = { Toast.makeText(this, "Accepted", Toast.LENGTH_SHORT).show() },
                onNegative = { Toast.makeText(this, "Declined", Toast.LENGTH_SHORT).show() }
            )
        }

        findViewById<Button>(R.id.btnIOSDialog).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.IOS_STYLE,
                title = "iOS Style Alert",
                message = "This dialog mimics iOS alert style.",
                positiveText = "OK",
                negativeText = "Cancel",
positiveButtonColor = Color.TRANSPARENT,
                negativeButtonColor = Color.TRANSPARENT

            )
        }

        findViewById<Button>(R.id.btnDefaultAlert).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.DEFAULT_ALERT,
                title = "Important Alert",
                message = "Please read this information carefully.",
                positiveText = "Got it",
                positiveButtonColor = Color.parseColor("#FF9800")

            )
        }

        findViewById<Button>(R.id.btnErrorDialog).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.ERROR,
                title = "Error!",
                message = "Something went wrong. Please try again.",
                positiveText = "OK",
                positiveButtonColor =Color.RED

            )
        }

        findViewById<Button>(R.id.btnWarningDialog).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.WARNING,
                title = "Warning!",
                message = "This action cannot be undone.",
                positiveText = "Proceed",
                negativeText = "Cancel",
                positiveButtonColor =Color.parseColor("#FF9800"),
                negativeButtonColor = Color.parseColor("#E0E0E0")


            )
        }

        findViewById<Button>(R.id.btnSuccessDialog).setOnClickListener {
            dialogBuilder.showCustomDialog(
                type = DialogBuilder.DialogType.SUCCESS,
                title = "Hooray!",
                message = "Operation completed successfully!",
                positiveText = "Great!",
                positiveButtonColor =Color.parseColor("#4CAF50")

            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        dialogBuilder.dismissDialog()
    }
}
