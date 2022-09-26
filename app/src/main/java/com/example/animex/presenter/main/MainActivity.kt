package com.example.animex.presenter.main

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.example.animex.R
import com.example.animex.base.visible
import com.example.animex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.regex.Pattern


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        setSupportActionBar(binding.toolbar)

        launch(getRootNavController())
        getRootNavController().addOnDestinationChangedListener(destinationListener())

        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun launch(navController: NavController) {
        val graph = navController.navInflater.inflate(R.navigation.main_graph)
        vm.isSignedIn.observe(this) { boolean ->
            if (boolean) {
                graph.setStartDestination(R.id.fragmentTabs)
                navController.graph = graph
                visibility()
            } else {
                graph.setStartDestination(R.id.fragmentSplash)
                navController.graph = graph
                visibility()
            }
        }

    }


    private fun visibility() {
        findViewById<ImageView>(R.id.imageMain).visible(false)
        findViewById<ProgressBar>(R.id.progress).visible(false)
        findViewById<FragmentContainerView>(R.id.fragmentContainer).visible(true)
    }


    private fun getRootNavController(): NavController {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }


    private fun destinationListener() =
        NavController.OnDestinationChangedListener { _, destination, arguments ->
            if (destination.label != null) {
                prepareDefaultToolbar(destination, arguments)
            } else if(destination.label == " "){
                supportActionBar?.show()
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

            }else{
                supportActionBar?.hide()
            }
        }

    private fun prepareDefaultToolbar(destination: NavDestination, arguments: Bundle?) {
        supportActionBar?.show()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = prepareTitle(destination.label, arguments)
    }

    private fun prepareTitle(label: CharSequence?, arguments: Bundle?): String {

        // code for this method has been copied from Google sources :)

        if (label == null) return ""
        val title = StringBuffer()
        val fillInPattern = Pattern.compile("\\{(.+?)\\}")
        val matcher = fillInPattern.matcher(label)
        while (matcher.find()) {
            val argName = matcher.group(1)
            if (arguments != null && arguments.containsKey(argName)) {
                matcher.appendReplacement(title, "")
                title.append().toString()
            } else {
                throw IllegalArgumentException(
                    "Could not find $argName in $arguments to fill label $label"
                )
            }
        }
        matcher.appendTail(title)
        return title.toString()
    }


}