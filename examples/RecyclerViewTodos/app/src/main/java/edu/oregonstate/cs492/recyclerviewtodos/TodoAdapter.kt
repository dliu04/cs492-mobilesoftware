package edu.oregonstate.cs492.recyclerviewtodos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    val todos = mutableListOf<Todo>()

    override fun getItemCount() = todos.size

    fun addTodo(todo: Todo) {
        todos.add(0, todo)
        notifyItemInserted(0)
    }

    fun deleteTodoAt(position: Int) {
        todos.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_item, parent, false)
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val checkbox: CheckBox = itemView.findViewById(R.id.todo_checkbox)
        private val todoTextTV: TextView = itemView.findViewById(R.id.tv_todo_text)
        private var currentTodo: Todo? = null

        init {
            checkbox.setOnCheckedChangeListener { _, isChecked ->
                currentTodo?.completed = isChecked
            }
        }

        fun bind(todo: Todo) {
            todoTextTV.text = todo.text
            checkbox.isChecked = todo.completed
            currentTodo = todo
        }
    }
}