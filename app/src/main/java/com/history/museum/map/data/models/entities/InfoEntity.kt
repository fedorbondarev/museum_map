package com.history.museum.map.data.models.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoEntity(val id: Long, val header: String, val content: String) : Parcelable
