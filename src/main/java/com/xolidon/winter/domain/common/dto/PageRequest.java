package com.xolidon.winter.domain.common.dto;

import org.springframework.data.domain.Sort;

public final class PageRequest {
    private final int DEFAULT_SIZE = 10;
    private final int MAX_SIZE = 100;

    private int page;
    private int size;
    private Sort.Direction direction;

    public void setPage(int page) {
        this.page = page <= 0 ? 1 : page;
    }

    public void setSize(int size) {
        this.size = (size > MAX_SIZE || size < 1) ? DEFAULT_SIZE : size;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, "createdAt");
    }
}
