package com.example.permissions

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.permissions.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMain)

        binding.cameraPermBTN.setOnClickListener {
            val permission = Manifest.permission.CAMERA
            permissionCamera.launch(permission)
        }

        binding.contactsPermBTN.setOnClickListener {
            val permission = Manifest.permission.READ_CONTACTS
            permissionContacts.launch(permission)
        }
    }

    private val permissionCamera =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                goToCamera()
            } else {
                Toast.makeText(this, "Нет доступа к камере", Toast.LENGTH_LONG).show()
            }
        }

    private fun goToCamera() {
        startActivity(Intent(this, CameraActivity::class.java))
    }

    private val permissionContacts =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                goToContacts()
            } else {
                Toast.makeText(this, "Нет доступа к контактам", Toast.LENGTH_LONG).show()
            }
        }

    private fun goToContacts() {
        startActivity(Intent(this, ContactsActivity::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_exit -> finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
}