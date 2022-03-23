package com.vladanristic.controllers.admin;

import com.vladanristic.dtos.SectionOrderRequest;
import com.vladanristic.entities.Section;
import com.vladanristic.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class AdminSectionsController {

    @Autowired
    private SectionService sectionService;

    @GetMapping(value = "/sections/course/{courseId}")
    public List<Section> getSectionsForCourse(@PathVariable(required = false, name = "courseId") long courseId) {
        return this.sectionService.getSectionsForCourse(courseId);
    }

    @DeleteMapping(value = "/sections/{sectionId}")
    public boolean deleteSection(@PathVariable(required = false, name = "sectionId") long sectionId) {
        return this.sectionService.removeSection(sectionId);
    }

    @PostMapping("sections/order")
    public List<Section> updateLoggedUser(@RequestBody SectionOrderRequest sections) {
        return this.sectionService.updateSectionsOrder(sections.getSections());
    }

    @PostMapping("sections")
    public Section addNewSection(@RequestBody Map<String, String> section) {
        return this.sectionService.addNewSection(section);
    }

    @PatchMapping("sections/{sectionId}")
    public Section updateSection(@RequestBody Map<String, String> section, @PathVariable(required = false, name = "sectionId") long sectionId) {
        return this.sectionService.updateSection(section, sectionId);
    }

}
