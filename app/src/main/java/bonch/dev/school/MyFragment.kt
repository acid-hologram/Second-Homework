package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import bonch.dev.school.R

class MyFragment: Fragment() {

    private lateinit var mainText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val textMain: TextView = view.findViewById(R.id.main_text_view)

        var tapAmount = arguments?.getInt("TAP_KEY", 0)
        var state = arguments?.getBoolean("TAP_STATE", false)
        var text = arguments?.get("TEXT")

        textMain.text =  "Количество котиков: ${tapAmount} \nСостояние индикатора: ${state} \n${text}"

        return view
    }
}