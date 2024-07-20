package com.example.ethantelefonicatest.ui.screen.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.usecase.GetUserDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(private val useCase: GetUserDetailUseCase) : ViewModel() {

    private var _user = MutableStateFlow<UserBO?>(null)
    val user = _user.asStateFlow()

    fun fetchUserDetail(id: Int) {
        viewModelScope.launch {
            _user.update { useCase.execute(id) }
        }
    }
}