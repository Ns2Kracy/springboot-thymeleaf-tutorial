package com.example.demo.core;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageUtil implements Serializable {
    private static final long serialVersionUID = 1L;
    private int total;
    private List<?> rows;
    public PageUtil(List<?> content, long total) {
        this.rows = content;
        this.total = (int) total;
    }
}
