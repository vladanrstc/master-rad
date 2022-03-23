package com.vladanristic.dtos;

import com.vladanristic.entities.Section;

import java.io.Serializable;
import java.util.List;

public class SectionOrderRequest implements Serializable {

    private List<Section> sections;

    public SectionOrderRequest() {

    }

    public SectionOrderRequest(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
