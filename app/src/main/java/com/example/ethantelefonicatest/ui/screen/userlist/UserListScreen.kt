@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.example.ethantelefonicatest.ui.screen.userlist

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ethantelefonicatest.domain.viewmodel.UserListViewModel
import com.example.ethantelefonicatest.ui.screen.userlist.composable.UserCard

@Composable
fun SharedTransitionScope.UserListScreen(
    onUserClick: (String, String) -> Unit,
    animatedVisibilityScope: AnimatedVisibilityScope,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val userData by viewModel.userData.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        AnimatedContent(
            targetState = userData.isEmpty(),
            label = "..."
        ) { isEmpty ->
            if (isEmpty) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(
                        top = innerPadding.calculateTopPadding() + 10.dp,
                        start = 20.dp,
                        end = 20.dp,
                        bottom = innerPadding.calculateBottomPadding() + 10.dp,
                    ),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Text(
                            text = "User List",
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    items(userData) { user ->
                        UserCard(
                            user = user,
                            onClick = {
                                //  onUserClick(user.attributes.posterImage.original, user.id)
                            },
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                    }
                }

            }
        }
    }
}

