package com.example.refactoringlifeacademy.data.service

import com.example.refactoringlifeacademy.data.dto.request.RegisterRequest
import com.example.refactoringlifeacademy.data.dto.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("auth/register")
    fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>
}