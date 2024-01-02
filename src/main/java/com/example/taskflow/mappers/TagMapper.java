package com.example.taskflow.mappers;

import com.example.taskflow.Dtos.TagDto;
import com.example.taskflow.Dtos.TaskDto;
import com.example.taskflow.entities.Tag;
import com.example.taskflow.entities.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TagMapper {
    public static List<Tag> mapTagDtoListToTagList(List<String> tagDtoList) {
        return tagDtoList.stream()
                .map(tagDto -> mapTagDtoToTag(tagDto))
                .collect(Collectors.toList());
    }

    public static Tag mapTagDtoToTag(String tagDto) {
        return Tag.builder()
                .name(tagDto)
                .build();
    }
}
