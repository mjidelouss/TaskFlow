package com.example.taskflow.controller;

import com.example.taskflow.Dtos.TagDto;
import com.example.taskflow.entities.Tag;
import com.example.taskflow.response.ResponseMessage;
import com.example.taskflow.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @GetMapping("")
    public ResponseEntity getTags() {
        List<Tag> tags = tagService.getTags();
        if (tags.isEmpty()) {
            return ResponseMessage.notFound("Tags Not Found");
        } else {
            return ResponseMessage.ok("Success", tags);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getTagById(@PathVariable Long id) {
        Tag tag = tagService.getTagById(id);
        if (tag == null) {
            return ResponseMessage.notFound("Tag Not Found");
        } else {
            return ResponseMessage.ok("Success", tag);
        }
    }

    @PostMapping("")
    public ResponseEntity createTag(@RequestBody @Valid TagDto tagDto) {
        Tag tag = TagMapper.mapTagDtoToTag(tagDto);
        Tag tag1 = tagService.createTag(tag);
        if(tag1 == null) {
            return ResponseMessage.badRequest("Failed To Create Tag");
        } else {
            return ResponseMessage.created("Tag Created Successfully", tag1);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateTag(@RequestBody @Valid TagDto tagDto, @PathVariable Long id) {
        Tag tag = TagMapper.mapTagDtoToTag(tagDto);
        Tag tag1 = tagService.updateTag(tag, id);
        if (tag1 == null) {
            return ResponseMessage.badRequest("Tag Not Updated");
        } else {
            return ResponseMessage.created("Tag Updated Successfully", tag1);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTag(@PathVariable Long id) {
        Tag tag = tagService.getTagById(id);
        if (tag == null) {
            return ResponseMessage.notFound("Tag Not Found");
        } else {
            tagService.deleteTag(id);
            return ResponseMessage.ok("Tag Deleted Successfully", tag);
        }
    }
}
