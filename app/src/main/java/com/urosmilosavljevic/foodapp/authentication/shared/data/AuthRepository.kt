package com.urosmilosavljevic.foodapp.authentication.shared.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val auth: FirebaseAuth,
) {
    fun getCurrentUser(): FirebaseUser? = auth.currentUser

    private val _authState = MutableStateFlow<FirebaseUser?>(null)
    val authState: StateFlow<FirebaseUser?> = _authState.asStateFlow()

    init {
        auth.addAuthStateListener { auth ->
            _authState.value = auth.currentUser
        }
    }

    suspend fun signUp(
        email: String,
        password: String,
        name: String,
    ): Result<FirebaseUser> =
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user!!

            val profileUpdates =
                userProfileChangeRequest {
                    displayName = name
                }
            user.updateProfile(profileUpdates).await()

            Result
                .success(result.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }

    suspend fun login(
        email: String,
        password: String,
    ): Result<FirebaseUser> =
        try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            Result.success(result.user!!)
        } catch (e: Exception) {
            Result.failure(e)
        }

    fun logout() {
        auth.signOut()
    }
}
