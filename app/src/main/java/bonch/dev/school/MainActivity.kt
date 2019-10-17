package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import bonch.dev.school.models.Counter
import org.w3c.dom.Text
import android.R.attr.button
import android.content.Intent
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var counterButton: Button
    private lateinit var indicatorButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText
    private lateinit var lineText: TextView
    private var counter = Counter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()

        counter = if (savedInstanceState == null) {
            Counter()
        } else {
            Counter(savedInstanceState.getInt("TAP_KEY"))
        }

        indicatorButton.setOnClickListener {indicatorButton.isEnabled = false}
        counterButton.setOnClickListener{counter.increment()
        }

        nextActivityButton.setOnClickListener  {
            val intent = Intent(MainActivity@this,SecondActivity::class.java)
            intent.putExtra("TAP_KEY",counter.currentCount)
            intent.putExtra("TAP_STATE",indicatorButton.isEnabled)
            intent.putExtra("TEXT",textField.getText().toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("TAP_KEY", counter.currentCount)
        outState.putBoolean("TAP_STATE",indicatorButton.isEnabled)
        outState.putString("TEXT",textField.getText().toString())

    }

    private fun initializeViews() {
        counterButton = findViewById(R.id.counter_button)
        indicatorButton = findViewById(R.id.indicator_button)
        nextActivityButton = findViewById(R.id.next_activity_button)
        textField = findViewById(R.id.text_field)
    }
}

