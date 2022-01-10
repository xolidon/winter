package com.xolidon.winter.querydsl;

import com.querydsl.core.types.QBean;
import com.querydsl.jpa.JPQLQuery;

public interface Projection<ENTITY, DTO> {
    QBean<DTO> getProjection();

    default JPQLQuery<ENTITY> getQuery(JPQLQuery<ENTITY> query) {
        return query;
    }
}
