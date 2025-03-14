package com.example.qtquickview_kotlin

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.qtquickview_kotlin.databinding.ActivityMainBinding
import org.qtproject.example.breweryfinderApp.QmlModule.Main
import org.qtproject.qt.android.QtQmlStatus
import org.qtproject.qt.android.QtQmlStatusChangeListener
import org.qtproject.qt.android.QtQuickView


class MainActivity : AppCompatActivity(), QtQmlStatusChangeListener {

    private lateinit var binding: ActivityMainBinding
    internal var qtQuickView: QtQuickView? = null
    private var mainQmlContent: Main = Main()
    private lateinit var qmlBridge: QmlBridge


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ Inflate ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Initialize QtQuickView
        qtQuickView = QtQuickView(this)

        // ✅ Set QML Status Change Listener
        mainQmlContent.setStatusChangeListener(this)

        // ✅ Add QtQuickView to FrameLayout
        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        binding.qmlContainer.addView(qtQuickView, params)

        // ✅ Load QML from compiled module (not raw file)
        qtQuickView!!.loadContent(mainQmlContent)
        qmlBridge = QmlBridge(this)

        // ✅ Button Click Listener for fetching Brewery data
        binding.fetchButton.setOnClickListener {
            binding.titleText.text = "Fetching Brewery Data..."
            qmlBridge.fetchBreweryData()
        }
    }


    /*fun updateQmlData(northern: String, southern: String, longest: String) {
        qtQuickView?.setProperty("northernMostText", "Northern Most Brewery: $northern")
        qtQuickView?.setProperty("southernMostText", "Southern Most Brewery: $southern")
        qtQuickView?.setProperty("longestNameText", "Longest Name Brewery: $longest")
    }*/

    fun updateQmlData(northern: String, southern: String, longest: String) {
        runOnUiThread {
            qtQuickView?.apply {
                setProperty("northernMostBrewery", northern)
                setProperty("southernMostBrewery", southern)
                setProperty("longestNameBrewery", longest)
            }
        }
    }

    override fun onStatusChanged(status: QtQmlStatus?) {
        if (status == QtQmlStatus.READY) {
            binding.titleText.text = "Welcome to Brewery Finder"
        }
    }
}
