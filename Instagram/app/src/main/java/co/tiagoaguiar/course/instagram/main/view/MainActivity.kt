package co.tiagoaguiar.course.instagram.main.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowInsetsController
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout

import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import co.tiagoaguiar.course.instagram.R
import co.tiagoaguiar.course.instagram.camera.view.CameraFragment
import co.tiagoaguiar.course.instagram.common.extension.replaceFragment
import co.tiagoaguiar.course.instagram.databinding.ActivityMainBinding
import co.tiagoaguiar.course.instagram.home.view.HomeFragment
import co.tiagoaguiar.course.instagram.profile.view.ProfileFragment
import co.tiagoaguiar.course.instagram.search.view.SearchFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var homeFragment: Fragment
    private lateinit var searchFragment: Fragment
    private lateinit var cameraFragment: Fragment
    private lateinit var profileFragment: Fragment
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            window.insetsController?.setSystemBarsAppearance(
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
            window.statusBarColor = ContextCompat.getColor(this, R.color.gray)
        }

        setSupportActionBar(binding.mainToolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_insta_camera)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= ""

        homeFragment = HomeFragment()
        searchFragment = SearchFragment()
        cameraFragment = CameraFragment()
        profileFragment = ProfileFragment()

        binding.mainBottomNav.setOnNavigationItemSelectedListener(this)
        binding.mainBottomNav.selectedItemId = R.id.menu_bottom_home

    }

    private fun setScrollToolbarEnabled(enabled: Boolean){
        val params = binding.mainToolbar.layoutParams as AppBarLayout.LayoutParams
        val cordinatorParams = binding.mainAppBar.layoutParams as CoordinatorLayout.LayoutParams

        if (enabled){
            params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
            cordinatorParams.behavior = AppBarLayout.Behavior()
        } else {
            params.scrollFlags = 0
            cordinatorParams.behavior = null
        }
        binding.mainAppBar.layoutParams = cordinatorParams
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var scroolToolbarEnabled = false
        when(item.itemId){
            R.id.menu_bottom_home ->{
                if (currentFragment == homeFragment) return false
                currentFragment = homeFragment
            }
            R.id.menu_bottom_search ->{
                if (currentFragment == searchFragment) return false
                currentFragment = searchFragment
            }
            R.id.menu_bottom_add ->{
                if (currentFragment == cameraFragment) return false
                currentFragment = cameraFragment
            }
            R.id.menu_bottom_profile ->{
                if (currentFragment == profileFragment) return false
                currentFragment = profileFragment
                scroolToolbarEnabled = true
            }
        }

        setScrollToolbarEnabled(scrollToolbarEnabled)
        currentFragment?.let {
            replaceFragment(R.id.main_fragment, it)
        }
        return true
    }

}