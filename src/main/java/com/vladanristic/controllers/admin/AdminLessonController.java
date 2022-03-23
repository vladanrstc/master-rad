package com.vladanristic.controllers.admin;

import com.vladanristic.dtos.LessonOrderRequest;
import com.vladanristic.entities.Lesson;
import com.vladanristic.service.FileStorageService;
import com.vladanristic.service.LessonService;
import com.vladanristic.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class AdminLessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping(value = "lessons/section/{sectionId}")
    public List<Lesson> getLessonsForSection(@PathVariable(required = false, name = "sectionId") long sectionId) {
        return this.lessonService.getLessonsForSection(sectionId);
    }

    @PostMapping(path = "/lessons", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Lesson createNewLesson(
            @RequestParam String lessonTitle,
            @RequestParam String lessonDescription,
            @RequestParam String lessonCode,
            @RequestParam Long lessonSectionId,
            @RequestPart(required = false, name = "lessonPractice") MultipartFile lessonPractice) {
        try {
            Lesson newLesson = new Lesson();
            newLesson.setLessonTitle(lessonTitle);
            newLesson.setLessonDescription(lessonDescription);
            newLesson.setLessonCode(lessonCode);
            newLesson.setLessonSectionId(this.sectionService.getSectionById(lessonSectionId));
            if(lessonPractice != null) {
                String fileName = fileStorageService.storeFile(lessonPractice);
                newLesson.setLessonPractice("http://localhost/vladanristicjava/uploads/" + fileName);
            }
            return this.lessonService.createNewLesson(newLesson);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping(path = "/lessons/update/{lessonId}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Lesson updateLesson(
            @PathVariable(required = false, name = "lessonId") Long lessonId,
            @RequestParam String lessonTitle,
            @RequestParam String lessonDescription,
            @RequestParam String lessonCode,
            @RequestPart(required = false, name = "lessonPractice") MultipartFile lessonPractice) {

        try {
            Lesson existingLesson = this.lessonService.getLessonById(lessonId);

            if(lessonPractice != null) {
                String fileName = fileStorageService.storeFile(lessonPractice);
                existingLesson.setLessonPractice("http://localhost/vladanristicjava/uploads/" + fileName);
            }

            existingLesson.setLessonTitle(lessonTitle);
            existingLesson.setLessonDescription(lessonDescription);
            existingLesson.setLessonCode(lessonCode);
            return this.lessonService.saveLesson(existingLesson);
        } catch (Exception e) {
            return null;
        }

    }

    @PatchMapping("lessons/video")
    public Lesson updateLessonVideo(@RequestBody Lesson lesson) {
        Lesson currentLesson = this.lessonService.getLessonById(lesson.getLessonId());
        currentLesson.setLessonVideoLink(lesson.getLessonVideoLink());
        return this.lessonService.updateLesson(currentLesson);
    }

    @PatchMapping("lessons/switch")
    public Lesson updateLessonPublished(@RequestBody Lesson lesson) {
        return this.lessonService.updateLessonPublishedStatus(this.lessonService.getLessonById(lesson.getLessonId()));
    }

    @DeleteMapping("lessons/{lessonId}")
    public boolean deleteLesson(@PathVariable long lessonId) {
        return this.lessonService.removeLesson(this.lessonService.getLessonById(lessonId));
    }

    @PostMapping("lessons/order")
    public List<Lesson> updateLessonsOrder(@RequestBody LessonOrderRequest lessons) {
        return this.lessonService.updateLessonsOrder(lessons.getLessons());
    }

}
