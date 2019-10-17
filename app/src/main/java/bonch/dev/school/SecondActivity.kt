package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var mainText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mainText = findViewById(R.id.main_text_view)

        val counterValue = intent.getIntExtra("TAP_KEY",0)
        val stateValue = intent.getBooleanExtra("TAP_STATE", true)
        val text = intent.getStringExtra("TEXT")
        mainText.text = "$counterValue счастливых котиков \nСостояние индикатора: $stateValue \n$text"
    }
}
