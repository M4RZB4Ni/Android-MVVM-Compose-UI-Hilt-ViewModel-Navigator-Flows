package com.marzbani.presentation.nodes

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NodesScreenKtTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @Before
    fun setUp() {
        hiltRule.inject()

    }

    @After
    fun tearDown() {
    }

    @Test
    fun nodesScreen() {
    }
}