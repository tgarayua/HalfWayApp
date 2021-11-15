package com.olayg.halfwayapp.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.olayg.halfwayapp.adapter.CharacterAdapter
import com.olayg.halfwayapp.databinding.ActivityMainBinding
import com.olayg.halfwayapp.model.custom.Character
import com.olayg.halfwayapp.util.logMe
import com.olayg.halfwayapp.viewmodel.SSBViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SSBViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.categories.observe(this) { characters ->
            "MainActivity $characters".logMe()
            binding.rvCharacters.adapter = CharacterAdapter(characters, ::characterSelected)
        }
    }

    private fun characterSelected(character: Character) {
    }
}
