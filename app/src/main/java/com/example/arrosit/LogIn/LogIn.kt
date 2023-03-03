package com.example.arrosit.LogIn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.example.arrosit.Main.MainActivity
import com.example.arrosit.Utils.LoadingDialog
import com.example.arrosit.databinding.ActivityLogInBinding
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {

    lateinit var binding:ActivityLogInBinding

    lateinit var auth: FirebaseAuth

    private val loadingDialog: LoadingDialog by lazy {
        LoadingDialog(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        auth = FirebaseAuth.getInstance()

        binding.buttonLogIn.setOnClickListener {
            logInWithEmailAndPassword()
        }

    }

    override fun onStart() {
        if (auth.currentUser != null)
        {
            finish()
            startActivity(Intent(this ,MainActivity::class.java))
        }
        super.onStart()
    }
    fun logInWithEmailAndPassword()
    {
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            binding.editTextEmail.error = "Please enter a valid email"
            binding.editTextEmail.requestFocus()
            return
        }

        if (password.length < 6)
        {
            binding.editTextPassword.error = "Password 6 char required"
            binding.editTextPassword.requestFocus()
            return
        }
        logInWithEmailAndPassword(email ,password)

    }

    private fun logInWithEmailAndPassword(email: String, password: String) {
        loadingDialog.show()
        auth.signInWithEmailAndPassword(email ,password).addOnCompleteListener {
            if (it.isSuccessful)
            {
                loadingDialog.hide()
                startActivity(Intent(this , MainActivity::class.java))
            }
            else
            {

                loadingDialog.hide()
                binding.textViewError.text = "${it.exception!!.message}"
                binding.textViewError.visibility = View.VISIBLE
            }

        }
    }
}