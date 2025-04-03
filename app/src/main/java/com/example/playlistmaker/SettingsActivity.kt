package com.example.playlistmaker

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.core.content.ContextCompat
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val buttonBack: ImageView = findViewById(R.id.back)

        buttonBack.setOnClickListener {
            finish()
        }
        val switch = findViewById<SwitchMaterial>(R.id.switchDarkTheme)

        switch.setOnCheckedChangeListener { _, isChecked ->
            // Получаем цвета из ресурсов
            val thumbColor = if (isChecked) {
                ContextCompat.getColor(this, R.color.switchBackgroundDark)
            } else {
                ContextCompat.getColor(this, R.color.switchThumbUnchecked)
            }

            val trackColor = if (isChecked) {
                ContextCompat.getColor(this, R.color.switchThumbChecked)
            } else {
                ContextCompat.getColor(this, R.color.switchBackgroundLight)
            }

            // Применяем цвета
            switch.thumbTintList = ColorStateList.valueOf(thumbColor)
            switch.trackTintList = ColorStateList.valueOf(trackColor)
        }
    }
}
