package com.example.ethantelefonicatest.domain.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ethantelefonicatest.domain.model.UserBO
import com.example.ethantelefonicatest.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private var _userData = MutableStateFlow<List<UserBO>>(emptyList())
    val userData = _userData.asStateFlow()

    init {
        viewModelScope.launch {
            _userData.update { repository.getUserList() }
        }
    }
}