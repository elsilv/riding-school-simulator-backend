package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Lessons;
import com.simulator.riding_school_simulator.repository.HorseRepository;
import com.simulator.riding_school_simulator.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private HorseRepository horseRepository;

    public Lessons createLesson(Lessons lesson) {
        int horseCount = (int) horseRepository.count();
        lesson.setMaxStudents(horseCount);
        return lessonRepository.save(lesson);
    }

    public List<Lessons> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lessons getLessonById(Long id) {
        Optional<Lessons> lesson = lessonRepository.findById(id);
        return lesson.orElse(null);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

}
