package com.example.myapplication;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter(taskList);
        recyclerView.setAdapter(taskAdapter);

        // Добавление кнопки и установка обработчика нажатия
        Button addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Добавление новой тестовой задачи
                taskList.add(new Task("Новая задача", "Описание новой задачи"));
                taskAdapter.notifyDataSetChanged();
            }
        });

        // Добавление тестовых задач для демонстрации
        taskList.add(new Task("Покупки", "Купить молоко и хлеб"));
        taskList.add(new Task("Уборка", "Прибраться на кухне"));
        taskAdapter.notifyDataSetChanged();
    }

}
