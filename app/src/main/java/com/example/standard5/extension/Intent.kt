package com.example.standard5.extension

import android.app.Activity
import android.os.Parcelable

inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) =
    lazy { intent.getParcelableExtra<T>(key) }