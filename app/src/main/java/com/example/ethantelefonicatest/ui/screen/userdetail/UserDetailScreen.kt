package com.example.ethantelefonicatest.ui.screen.userdetail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ethantelefonicatest.domain.viewmodel.UserDetailViewModel

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.UserDetailScreen(
    viewModel: UserDetailViewModel = hiltViewModel(),
    coverImage: String?,
    id: Int,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {}