package com.ok.libraryapp.db;

import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.SearchModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BookSpecification implements Specification<Book> {

    private SearchCriteria searchCriteria;

    public BookSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(
                criteriaBuilder.lower(
                        root.get(searchCriteria.getKey())),
                "%" + searchCriteria.getValue() + "%");
    }
}
