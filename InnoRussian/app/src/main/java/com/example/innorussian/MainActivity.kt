package com.example.innorussian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.innorussian.home_fragment.HomeFragment
import com.example.innorussian.learn_fragment.LearnFragment
import com.example.innorussian.scanner_fragment.ScannerFragment
import com.example.innorussian.settings_fragment.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val phrasebookFragment = HomeFragment()
        val learnFragment = LearnFragment()
        val scannerFragment = ScannerFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(phrasebookFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miPhrasebook -> setCurrentFragment(phrasebookFragment)
                R.id.miLearn -> setCurrentFragment(learnFragment)
                R.id.miScanner -> setCurrentFragment(scannerFragment)
                R.id.miSettings -> setCurrentFragment(settingsFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
}