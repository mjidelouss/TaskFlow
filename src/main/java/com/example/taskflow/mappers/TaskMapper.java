package com.example.taskflow.mappers;

import com.example.taskflow.Dtos.TaskDto;
import com.example.taskflow.entities.Task;

public class TaskMapper {
    public static Task mapTaskDtoToTask(TaskDto taskDto) {
        return Task.builder()
                .build();
    }
}
