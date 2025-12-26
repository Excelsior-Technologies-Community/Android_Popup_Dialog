package com.ext.android_popupdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DialogBuilder(private val context: Context) {

    private var dialog: Dialog? = null

    // Dialog types
    enum class DialogType {
        DEFAULT_PROGRESS,
        LOTTIE_PROGRESS,
        STANDARD,
        IOS_STYLE,
        DEFAULT_ALERT,
        ERROR,
        WARNING,
        SUCCESS
    }

    /**
     * Show a fully customizable dialog
     */
    fun showCustomDialog(
        type: DialogType,
        title: String = "",
        message: String = "",
        iconResId: Int? = null,                  // Icon drawable
        titleColor: Int = Color.BLACK,
        messageColor: Int = Color.DKGRAY,
        messageFontSize: Float? = null,          // In SP
        positiveText: String = "OK",
        negativeText: String? = null,
        positiveButtonColor: Int = Color.parseColor("#2196F3"),
        negativeButtonColor: Int = Color.GRAY,
        cancelable: Boolean = true,
        onPositive: (() -> Unit)? = null,
        onNegative: (() -> Unit)? = null
    ): Dialog {
        dismissDialog()

        val layoutId = when (type) {
            DialogType.DEFAULT_PROGRESS -> R.layout.dialog_progress
            DialogType.LOTTIE_PROGRESS -> R.layout.dialog_lottie_progress
            DialogType.STANDARD -> R.layout.dialog_standard
            DialogType.IOS_STYLE -> R.layout.dialog_ios
            DialogType.DEFAULT_ALERT -> R.layout.dialog_alert
            DialogType.ERROR -> R.layout.dialog_error
            DialogType.WARNING -> R.layout.dialog_warning
            DialogType.SUCCESS -> R.layout.dialog_success
        }

        dialog = Dialog(context).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(layoutId)
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCancelable(cancelable)

            // Set title
            findViewById<TextView>(R.id.tvDialogTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }
            findViewById<TextView>(R.id.tvIOSTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }
            findViewById<TextView>(R.id.tvAlertTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }
            findViewById<TextView>(R.id.tvErrorTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }
            findViewById<TextView>(R.id.tvWarningTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }
            findViewById<TextView>(R.id.tvSuccessTitle)?.apply {
                text = title
                setTextColor(titleColor)
            }

            // Set message
            findViewById<TextView>(R.id.tvDialogMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }
            findViewById<TextView>(R.id.tvIOSMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }
            findViewById<TextView>(R.id.tvAlertMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }
            findViewById<TextView>(R.id.tvErrorMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }
            findViewById<TextView>(R.id.tvWarningMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }
            findViewById<TextView>(R.id.tvSuccessMessage)?.apply {
                text = message
                setTextColor(messageColor)
                messageFontSize?.let { textSize = it }
            }

            // Set icon if provided
            iconResId?.let { res ->
                findViewById<ImageView>(R.id.ivAlertIcon)?.setImageResource(res)
                findViewById<ImageView>(R.id.ivSuccessIcon)?.setImageResource(res)
                findViewById<ImageView>(R.id.ivErrorIcon)?.setImageResource(res)
            }

            // Positive button
            listOf(
                findViewById<Button>(R.id.btnPositive),
                findViewById<Button>(R.id.btnIOSPositive),
                findViewById<Button>(R.id.btnAlertOk),
                findViewById<Button>(R.id.btnErrorOk),
                findViewById<Button>(R.id.btnWarningPositive),
                findViewById<Button>(R.id.btnSuccessOk)
            ).forEach { btn ->
                btn?.apply {
                    visibility = Button.VISIBLE
                    text = positiveText
                    setBackgroundColor(positiveButtonColor)
                    setOnClickListener {
                        onPositive?.invoke()
                        dismiss()
                    }
                }
            }

            // Negative button
            listOf(
                findViewById<Button>(R.id.btnNegative),
                findViewById<Button>(R.id.btnIOSNegative),
                findViewById<Button>(R.id.btnWarningNegative)
            ).forEach { btn ->
                btn?.apply {
                    if (negativeText != null) {
                        visibility = Button.VISIBLE
                        text = negativeText
                        setBackgroundColor(negativeButtonColor)
                        setOnClickListener {
                            onNegative?.invoke()
                            dismiss()
                        }
                    } else {
                        visibility = Button.GONE
                    }
                }
            }

            show()
        }

        return dialog!!
    }

    fun dismissDialog() {
        dialog?.let { if (it.isShowing) it.dismiss() }
        dialog = null
    }
}
