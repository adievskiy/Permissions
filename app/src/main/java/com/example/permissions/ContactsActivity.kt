package com.example.permissions

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.permissions.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding
    private val contacts = mutableListOf(
        Contacts("Александр", "81234567895"),
        Contacts("Алексей", "81234567895"),
        Contacts("Арсений", "81234567895"),
        Contacts("Андрей", "81234567895")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarContacts)

        binding.recyclerRV.layoutManager = LinearLayoutManager(this)
        val adapter = ContactsAdapter(contacts)
        binding.recyclerRV.adapter = adapter
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