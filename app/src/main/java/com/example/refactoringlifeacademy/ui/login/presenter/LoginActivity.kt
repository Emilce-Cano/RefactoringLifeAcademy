package com.example.refactoringlifeacademy.ui.login.presenter

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.refactoringlifeacademy.ui.login.viewmodel.ViewModelLogin
import com.example.refactoringlifeacademy.databinding.ActivityLoginBinding
import com.example.refactoringlifeacademy.ui.register.presenter.RegisterActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: ViewModelLogin by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer()
        activateButton()
        initListeners()

    }

    private fun initListeners() {
        binding.cbShowPassword.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            binding.etPassword.setSelection(binding.etPassword.text.length)
        }

        binding.tvRegisterHere.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

//    binding.btnEnter.setOnClickListener {
//        val email = binding.etEmail.text.toString()
//        val password = binding.etPassword.text.toString()
//        if (email.isNotEmpty() && password.isNotEmpty()) {
//            viewModel.loginUser(email, password)
//        } else {
//            Toast.makeText(this, "Por favor ingrese su correo y contraseña", Toast.LENGTH_SHORT).show()
//        }
//    }


    private fun observer() {
        viewModel.validationFields.observe(this) { isValid ->
            binding.btnEnter.isEnabled = isValid
        }

//        viewModel.dataState.observe(this) { state ->
//            when (state) {
//                is StateLogin.Loading -> {
//                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
//                }
//                is StateLogin.Succes -> {
//                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//                is StateLogin.Error -> {
//                    Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }

    private fun activateButton() {
        binding.etEmail.addTextChangedListener {
            validateFields()
        }
        binding.etPassword.addTextChangedListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        viewModel.checkAllFields(email, password)
    }
}