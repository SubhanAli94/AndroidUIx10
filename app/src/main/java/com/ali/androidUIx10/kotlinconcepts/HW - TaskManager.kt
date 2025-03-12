package com.ali.androidUIx10.kotlinconcepts

data class Task(val title: String, val description: String, var completed: Boolean = false)

class TaskManager {

    // A mutable list to store tasks
    private val tasks = mutableListOf<Task>()

    // Add a new task
    fun addTask(task: Task) {
        // TODO: Implement this method to add a task to the tasks list
    }

    // Remove a task by its title
    fun removeTask(title: String) {
        // TODO: Implement this method to remove a task by its title
        // Hint: You can use the `find` method to find a task with the matching title
    }

    // List all tasks
    fun listTasks() {
        // TODO: Implement this method to list all tasks with their title, description, and completion status
        // Hint: You can loop through the list of tasks and print each task's details
    }

    // Mark a task as completed
    fun markAsCompleted(title: String) {
        // TODO: Implement this method to mark a task as completed
        // Hint: Use the `find` method to locate the task by title, then set its `completed` property to true
    }

    // Mark a task as incomplete
    fun markAsIncomplete(title: String) {
        // TODO: Implement this method to mark a task as incomplete
        // Hint: Use the `find` method to locate the task by title, then set its `completed` property to false
    }

    // Filter tasks by completion status
    fun filterByCompletionStatus(status: Boolean): List<Task> {
        // TODO: Implement this method to filter tasks based on their completion status
        // Hint: You can use the `filter` function to return only tasks matching the given status
        return tasks.filter { it.completed == status }
    }
}

fun main() {
    val taskManager = TaskManager()

    while (true) {
        println("\nTask Manager")
        println("1. Add Task")
        println("2. Remove Task")
        println("3. List Tasks")
        println("4. Mark Task as Completed")
        println("5. Mark Task as Incomplete")
        println("6. Filter Tasks by Status")
        println("7. Exit")
        print("Enter choice: ")

        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> {
                // TODO: Ask the user for task details (title and description) and add a task
                // Hint: Call `taskManager.addTask()` with the new Task
            }
            2 -> {
                // TODO: Ask the user for the title of the task to remove, and call `taskManager.removeTask()`
            }
            3 -> {
                // TODO: Call `taskManager.listTasks()` to display all tasks
            }
            4 -> {
                // TODO: Ask the user for the title of the task to mark as completed, and call `taskManager.markAsCompleted()`
            }
            5 -> {
                // TODO: Ask the user for the title of the task to mark as incomplete, and call `taskManager.markAsIncomplete()`
            }
            6 -> {
                // TODO: Ask the user for the status (true for completed, false for incomplete), and filter tasks using `taskManager.filterByCompletionStatus()`
                // Hint: You can display the filtered tasks by iterating through the list
            }
            7 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}
