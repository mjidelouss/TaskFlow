package com.example.taskflow.mappers;

import com.example.taskflow.Dtos.TagDto;
import com.example.taskflow.Dtos.TaskDto;
import com.example.taskflow.entities.Tag;
import com.example.taskflow.entities.Task;

public class TagMapper {
        public static Tag mapTagDtoToTag(TagDto tagDto) {
        return Tag.builder()
                .build();
    }
}
