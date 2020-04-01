package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Test

class StatisticsUtilsTest {

        @Test
        internal fun getActiveAndCompletedStats(tasks: List<Task>?): StatsResult {

        return

        if (tasks == null || tasks.isEmpty()) {
            StatsResult(0f, 0f)
        } else {
            val totalTasks = tasks.size
            val numberOfActiveTasks = tasks.count { it.isActive }
            StatsResult(
                    activeTasksPercent = 100f * numberOfActiveTasks / tasks.size,
                    completedTasksPercent = 100f * (totalTasks - numberOfActiveTasks) / tasks.size
            )
        }
    }
    }