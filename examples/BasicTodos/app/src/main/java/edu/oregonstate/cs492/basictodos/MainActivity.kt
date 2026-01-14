package edu.oregonstate.cs492.basictodos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val todos = mutableListOf<String>()

        val addTodoBtn: Button = findViewById(id = R.id.btn_add_todo)
        val todoEntryET: EditText = findViewById(id = R.id.et_todo_entry)
        val todoListTV: TextView = findViewById(id = R.id.tv_todo_list)
        // todoListTV.text = "Finish todo app"

        addTodoBtn.setOnClickListener { 
            val newTodo = todoEntryET.text.toString()
            if (!TextUtils.isEmpty(str = newTodo)) {
                todos.add(index = 0, element = newTodo)
                todoListTV.text = todos.joinToString(separator = "\n\n")
                todoEntryET.setText("")
            }
        }
    }
}