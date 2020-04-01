package com.example.android.architecture.blueprints.todoapp.tasks

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
    class TasksViewModelTest {

        private lateinit var tasksViewModel: TasksViewModel

        @get:Rule
                var instantExecutorRule = InstantTaskExecutorRule()

        @Before
        fun setupViewModel() {
            tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
        }


        @Test
        fun addNewTask_setsNewTaskEvent() {

            tasksViewModel.addNewTask()

            val value = tasksViewModel.newTaskEvent.awaitNextValue()
            assertThat(
                    value?.getContentIfNotHandled(), (not(nullValue()))
            )
        }

        @Test
        fun getTasksAddViewVisible() {

            tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)

            assertThat(tasksViewModel.tasksAddViewVisible.awaitNextValue(), `is`(true))
        }

    }


