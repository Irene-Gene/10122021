package example.irenepoem.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigtor)
        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.new_motivation -> {
                    fragment = MotivationFragment()
                }
                R.id.about_developers -> {
                    fragment = AboutFragment()
                }
                R.id.web_menu -> {
                    val link = Uri.parse("https://google.com/")
                    val openBrowserInt = Intent(Intent.ACTION_VIEW, link)
                    startActivity(openBrowserInt)
                }
            }
                replaceFragment(fragment!!)

            true
        }
        bottomNavigationView.selectedItemId = R.id.new_motivation
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}