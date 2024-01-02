package com.example.taskflow.mappers;

import com.example.taskflow.Dtos.TaskDto;
import com.example.taskflow.entities.Task;
import com.example.taskflow.entities.User;
import com.example.taskflow.enums.TaskStatus;
import com.example.taskflow.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final UserService userService;
    public Task mapTaskDtoToTask(TaskDto taskDto) {
        return Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .tags(TagMapper.mapTagDtoListToTagList(taskDto.getTags()))
                .deadline(taskDto.getDeadline())
                .status(TaskStatus.TODO)
                .createdBy(userService.getUserById(taskDto.getCreatedBy()))
                .creationDate(taskDto.getCreationDate())
                .completed(false)
                .build();
    }
}
