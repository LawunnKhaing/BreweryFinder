package com.example.qtquickview_kotlin

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.qtquickview_kotlin.databinding.ActivityMainBinding
import org.qtproject.example.breweryfinderApp.QmlModule.Main
import org.qtproject.qt.android.QtQmlStatus
import org.qtproject.qt.android.QtQmlStatusChangeListener
import org.qtproject.qt.android.QtQuickView
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class MainActivity : AppCompatActivity(), QtQmlStatusChangeListener {

    private lateinit var binding: ActivityMainBinding
    internal var qtQuickView: QtQuickView? = null
    private var mainQmlContent: Main = Main()
    private lateinit var qmlBridge: QmlBridge


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        qtQuickView = QtQuickView(this)

        mainQmlContent.setStatusChangeListener(this)

        val params = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        )
        binding.qmlContainer.addView(qtQuickView, params)

        qtQuickView!!.loadContent(mainQmlContent)
        qmlBridge = QmlBridge(this)

        binding.fetchButton.setOnClickListener {
            if (isNetworkAvailable(this)) {
                binding.titleText.text = "Fetching Brewery Data..."
                qmlBridge.fetchBreweryData()
            } else {
                binding.titleText.text = "⚠️ No Internet Connection. Please check and try again."
            }
        }
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    fun updateQmlData(northern: String, southern: String, longest: String) {
        runOnUiThread {
            qtQuickView?.apply {
                setProperty("northernMostBrewery", northern)
                setProperty("southernMostBrewery", southern)
                setProperty("longestNameBrewery", longest)
            }
        }
    }

    fun updateTitleText(newText: String) {
        runOnUiThread {
            binding.titleText.text = newText
        }
    }

    override fun onStatusChanged(status: QtQmlStatus?) {
        if (status == QtQmlStatus.READY) {
            binding.titleText.text = "Welcome to Brewery Finder"
        }
    }
}
