package com.xolidon.winter.querydsl;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public abstract class QuerydslRepository<ENTITY, DTO> extends QuerydslRepositorySupport {

    public QuerydslRepository(Class<ENTITY> domainClass) {
        super(domainClass);
    }

    public abstract JPQLQuery<ENTITY> from();

    public DTO findOne(Predicate predicate, Projection<ENTITY, DTO> projection) {
        return projection.getQuery(from())
                .where(predicate)
                .select(projection.getProjection())
                .fetchOne();
    }

    public List<DTO> findAll(Predicate predicate, Projection<ENTITY, DTO> projection, OrderSpecifier... orderSpecifiers) {
        return projection.getQuery(from())
                .where(predicate)
                .select(projection.getProjection())
                .orderBy(orderSpecifiers)
                .fetch();
    }

    public Page<DTO> findAll(Predicate predicate, Pageable pageable, Projection<ENTITY, DTO> projection) {
        QueryResults<DTO> results = getQuerydsl()
                .applyPagination(
                        pageable,
                        projection.getQuery(from())
                                .where(predicate)
                )
                .select(projection.getProjection())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

}
