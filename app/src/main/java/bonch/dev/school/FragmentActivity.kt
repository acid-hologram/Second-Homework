package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import bonch.dev.school.models.Counter

class FragmentActivity : AppCompatActivity() {

    private lateinit var counterButton: Button
    private lateinit var indicatorButton: Button
    private lateinit var nextFragmentButton: Button
    private lateinit var textField: EditText

    private val myFragment = MyFragment()
    private var counter = Counter()
    open    val fm = supportFragmentManager


    private fun initializeViews() {
        counterButton = findViewById(R.id.counter_button)
        indicatorButton = findViewById(R.id.indicator_button)
        nextFragmentButton = findViewById(R.id.attach_fragment_button)
        textField = findViewById(R.id.text_field)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bundle = Bundle()
        initializeViews()


        counter = if (savedInstanceState == null) {
            Counter()
        } else {
            Counter(savedInstanceState.getInt("TAP_KEY"))
        }

        counterButton.setOnClickListener{counter.increment()}

        indicatorButton.setOnClickListener {indicatorButton.isEnabled = false}

        nextFragmentButton.setOnClickListener  {
            bundle.putInt("TAP_KEY", counter.currentCount)
            bundle.putBoolean("TAP_STATE", indicatorButton.isEnabled)
            bundle.putString("TEXT", textField.text.toString())
            myFragment.arguments = bundle
            attachFragment()
        }
    }


    fun attachFragment() {
        fm.beginTransaction().add(R.id.fragment1, MyFragment()).commit()
    }
}
