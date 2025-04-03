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

    public Lessons updateLesson(Long id, Lessons updatedLesson) {
        Optional<Lessons> existingLesson = lessonRepository.findById(id);
        if (existingLesson.isPresent()) {
            Lessons lesson = existingLesson.get();
            lesson.setTitle(updatedLesson.getTitle());
            lesson.setDateTime(updatedLesson.getDateTime());
            lesson.setMaxStudents(updatedLesson.getMaxStudents());
            lesson.setPrice(updatedLesson.getPrice());
            lesson.setLessonType(updatedLesson.getLessonType());
            lesson.setTeacherName(updatedLesson.getTeacherName());
            lesson.setHorseAssigned(updatedLesson.getHorseAssigned());
            lesson.setLessonStatus(updatedLesson.getLessonStatus());
            return lessonRepository.save(lesson);
        }
        return null;
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

    public Lessons updateLessonStatus(Long id, String status) {
        Lessons lesson = getLessonById(id);
        if (lesson != null) {
            lesson.setLessonStatus(status);
            return lessonRepository.save(lesson);
        }
        return null;
    }
}
