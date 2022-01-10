package com.xolidon.winter.querydsl;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuerydslRepositoryCustom<ENTITY, DTO> {
    DTO findOne(Predicate predicate, Projection<ENTITY, DTO> projection);

    List<DTO> findAll(Predicate predicate, Projection<ENTITY, DTO> projection, OrderSpecifier... orderSpecifiers);

    Page<DTO> findAll(Predicate predicate, Pageable pageable, Projection<ENTITY, DTO> projection);
}
