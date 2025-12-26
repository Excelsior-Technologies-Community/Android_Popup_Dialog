# **Android Popup Dialog Library**

---
DialogBuilder is a flexible and easy-to-use Android dialog library that allows you to show multiple types of dialogs (Progress, Standard, iOS-style, Alert, Error, Warning, Success) with full customization for colors, icons, and text sizes—all without modifying the library itself.

---

## ✨ **Features**

- Multiple dialog types:

    - Default Progress

    - Lottie Progress

    - Standard Dialog

    - iOS-style Dialog

    - Alert Dialog

    - Error Dialog

    - Warning Dialog

    - Success Dialog

- Customizable:

    - Title text and color

    - Message text, color, and font size

    - Positive and negative button text and color

    - Optional icons for alert, error, and success dialogs

    - Optional Lottie animations for progress dialogs

    - Easy to use in any Activity or Fragment






  ---

# **Preview**
---
<p align="center">
  <img src="https://github.com/user-attachments/assets/4b943fe5-0d30-43ce-8f67-3f4340ab2fff"
       alt="Demo GIF"
       width="200">



</p>


## ⚡ **Installation**

**Step 1:** Add JitPack repository to your root build.gradle:

```gradle
maven { url = uri("https://jitpack.io") }
```

**Step 2:** Add the dependency in your app `build.gradle` (example if hosted on JitPack):  

```gradle
dependencies {
	        	        implementation 'com.github.Excelsior-Technologies-Community:Android_Popup_Dialog:1.0.0'


}
```


## ⚡ **Usage**

1. Add in XML

```
  <Button
            android:id="@+id/btnDefaultProgress"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginBottom="8dp"
            android:backgroundTint="#2196F3"
            android:text="Default Progress Dialog"
            android:textAllCaps="false" />


```



## **2. Setup in Activity**

**1. Initialize DialogBuilder**

```
private lateinit var dialogBuilder: DialogBuilder

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    // Initialize the DialogBuilder
    dialogBuilder = DialogBuilder(this)
}


```
**2. Show Dialogs**

```
// Default Progress Dialog
dialogBuilder.showCustomDialog(
    type = DialogBuilder.DialogType.DEFAULT_PROGRESS,
    message = "Loading data..."
)

// Lottie Progress Dialog
dialogBuilder.showCustomDialog(
    type = DialogBuilder.DialogType.LOTTIE_PROGRESS,
    message = "Processing..."
)

// Standard Dialog
dialogBuilder.showCustomDialog(
    type = DialogBuilder.DialogType.STANDARD,
    title = "Standard Dialog",
    message = "This is a standard dialog with two buttons.",
    positiveText = "Accept",
    negativeText = "Decline",
    onPositive = { /* handle accept */ },
    onNegative = { /* handle decline */ }
)

// iOS Style Dialog
dialogBuilder.showCustomDialog(
    type = DialogBuilder.DialogType.IOS_STYLE,
    title = "iOS Style Alert",
    message = "This mimics iOS alerts.",
    positiveText = "OK",
    negativeText = "Cancel",
    positiveButtonColor = Color.TRANSPARENT,   // Use default XML style
    negativeButtonColor = Color.TRANSPARENT
)

// Error Dialog with custom color
dialogBuilder.showCustomDialog(
    type = DialogBuilder.DialogType.ERROR,
    title = "Error!",
    message = "Something went wrong.",
    positiveText = "OK",
    positiveButtonColor = Color.RED
)



```

## ✨ **showCustomDialog() Function Parameters**

```
fun showCustomDialog(
    type: DialogType,                   // Type of dialog (DEFAULT_PROGRESS, LOTTIE_PROGRESS, STANDARD, IOS_STYLE, ERROR, WARNING, SUCCESS, DEFAULT_ALERT)
    title: String = "",                 // Dialog title text
    message: String = "",               // Dialog message text
    iconResId: Int? = null,             // Optional icon drawable resource
    titleColor: Int = Color.BLACK,      // Title text color
    messageColor: Int = Color.DKGRAY,   // Message text color
    messageFontSize: Float? = null,     // Optional message font size in SP
    positiveText: String = "OK",        // Positive button text
    negativeText: String? = null,       // Optional negative button text
    positiveButtonColor: Int = Color.parseColor("#2196F3"), // Positive button color
    negativeButtonColor: Int = Color.GRAY,                  // Negative button color
    cancelable: Boolean = true,         // Dialog cancellable flag
    onPositive: (() -> Unit)? = null,   // Callback for positive button
    onNegative: (() -> Unit)? = null    // Callback for negative button
): Dialog



```



## **📄 License**

**MIT License**  
```
Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```



  
