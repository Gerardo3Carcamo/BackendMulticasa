package com.multicasa.multicasabackend.Dtos;

import java.util.List;

public class ChartDto {
    private List<String> labels;
    private List<Dataset> datasets;

    // Getters y Setters
    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<Dataset> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<Dataset> datasets) {
        this.datasets = datasets;
    }
}
