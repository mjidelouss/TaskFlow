package com.example.taskflow.service;

import com.example.taskflow.entities.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTags();

    Tag getTagById(Long id);

    Tag createTag(Tag tag);

    Tag updateTag(Tag tag, Long id);

    void deleteTag(Long id);
}
