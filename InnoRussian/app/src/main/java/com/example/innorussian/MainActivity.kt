package com.example.innorussian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val phrasebookFragment = PhrasebookFragment()
        val learnFragment = LearnFragment()
        val scannerFragment = ScannerFragment()
        val accountFragment = AccountFragment()

        setCurrentFragment(phrasebookFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.miPhrasebook -> setCurrentFragment(phrasebookFragment)
                R.id.miLearn -> setCurrentFragment(learnFragment)
                R.id.miScanner -> setCurrentFragment(scannerFragment)
                R.id.miAccount -> setCurrentFragment(accountFragment)
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