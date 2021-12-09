package example.irenepoem.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MotivationFragment : Fragment() {

    lateinit var demotivImageView: ImageView
    lateinit var changeButton: Button

    private var demotivationImageList: List<Int> = listOf(
        R.drawable.motiv1,
        R.drawable.motiv2,
        R.drawable.motiv3,
        R.drawable.motiv4,
        R.drawable.motiv5,
        R.drawable.motiv6
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_motivation, container, false)

        demotivImageView = view.findViewById(R.id.demotivation_image_view)
        changeButton = view.findViewById(R.id.change_button)

        changeButton.setOnClickListener {

            demotivImageView.setImageResource(demotivationImageList.random())
        }
        return view
    }

}