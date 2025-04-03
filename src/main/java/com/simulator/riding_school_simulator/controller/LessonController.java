package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Lessons;
import com.simulator.riding_school_simulator.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/create")
    public Lessons createLesson(@RequestBody Lessons lesson) {
        return lessonService.createLesson(lesson);
    }

    @PutMapping("/update/{id}")
    public Lessons updateLesson(@PathVariable Long id, @RequestBody Lessons lesson) {
        return lessonService.updateLesson(id, lesson);
    }

    @GetMapping
    public List<Lessons> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public Lessons getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }

    @PatchMapping("/status/{id}")
    public Lessons updateLessonStatus(@PathVariable Long id, @RequestParam String status) {
        return lessonService.updateLessonStatus(id, status);
    }
}
