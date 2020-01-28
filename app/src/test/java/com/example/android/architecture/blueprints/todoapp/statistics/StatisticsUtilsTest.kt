package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {

        // Create an active tasks (the false makes this active)
        val tasks = listOf(
                Task("title", "desc", isCompleted = false)
        )
        // Call our function
        val result = getActiveAndCompletedStats(tasks)

        // Check the result
        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 100f)
    }

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsSixtyForty() {

        val tasks = listOf(
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = true),
                Task("title", "desc", isCompleted = false),
                Task("title", "desc", isCompleted = false)
        )
        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 60f)
        assertEquals(result.activeTasksPercent, 40f)
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZeros() {

        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }

    @Test
    fun getActiveAndCompletedStats_error_returnsZeros() {

        val tasks = emptyList<Task>()

        val result = getActiveAndCompletedStats(tasks)

        assertEquals(result.completedTasksPercent, 0f)
        assertEquals(result.activeTasksPercent, 0f)
    }
}