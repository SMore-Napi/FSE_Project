package com.example.innorussian.scanner_fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.budiyev.android.codescanner.CodeScanner
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.innorussian.R
import com.example.innorussian.home_fragment.phrasebook.topic.TopicActivity
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.PhrasesActivity
import com.example.innorussian.home_fragment.phrasebook.topic.phrases.TopicsDataFactory
import kotlinx.android.synthetic.main.fragment_scanner.*

private const val CAMERA_REQUEST_CODE = 101

class ScannerFragment : Fragment(R.layout.fragment_scanner) {
    private lateinit var codeScanner: CodeScanner
    private lateinit var topicName: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_open_topic.setOnClickListener {
            val intent = Intent(activity, TopicActivity()::class.java)
            intent.putExtra("topic", topicName)
            startActivity(intent)
        }

        setupPermissions()
        codeScanner()

    }

    private fun codeScanner() {
        codeScanner = context?.let { CodeScanner(it, scanner_view) }!!

        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS

            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback {
                activity?.runOnUiThread {
                    if (tv_textView != null && btn_open_topic != null) {
                        if (TopicsDataFactory.containsTopic(it.text)) {
                            topicName = it.text
                            tv_textView.text = it.text
                            btn_open_topic.visibility = View.VISIBLE
                        } else {
                            tv_textView.text = "Such topic doesn't exist"
                            btn_open_topic.visibility = View.GONE
                        }
                    }
                }
            }

            errorCallback = ErrorCallback {
                activity?.runOnUiThread {
                    Log.e("Main", "Camera initialization error: ${it.message}")
                }
            }
        }

        scanner_view.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onStop() {
        codeScanner.releaseResources()
        super.onStop()
    }

    override fun onDestroy() {
        codeScanner.releaseResources()
        super.onDestroy()
    }

    override fun onDestroyView() {
        codeScanner.releaseResources()
        super.onDestroyView()
    }

    private fun setupPermissions() {
        val permission = context?.let {
            ContextCompat.checkSelfPermission(
                it,
                android.Manifest.permission.CAMERA
            )
        }

        if (permission != PackageManager.PERMISSION_GRANTED) {
            makeRequest()
        }
    }

    private fun makeRequest() {
        activity?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_REQUEST_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(
                        context,
                        "You need the camera permission to be able to use this app!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // successful
                }
            }
        }
    }
}