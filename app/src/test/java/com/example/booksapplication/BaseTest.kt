package com.example.booksapplication

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Before

/**
 * Created by Nadya N. on 21.01.2025.
 */
open class BaseTest {

    @Before
    fun setup() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }
}