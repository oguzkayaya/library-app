package com.ok.libraryapp.db;

import com.ok.libraryapp.models.Author;
import com.ok.libraryapp.models.Book;
import com.ok.libraryapp.models.Publisher;
import com.ok.libraryapp.models.SearchModel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.*;

public class BookSpecification implements Specification<Book> {

    private SearchCriteria searchCriteria;

    public BookSpecification(SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (searchCriteria.getKey() == "author") {
            Join<Book, Author> authorJoin = root.join("author", JoinType.LEFT);
            return criteriaBuilder.like(
                    criteriaBuilder.lower(authorJoin.get("name")),
                    "%" + searchCriteria.getValue() + "%"
            );
        } else if (searchCriteria.getKey() == "publisher") {
            Join<Book, Publisher> publisherJoin = root.join("publisher", JoinType.LEFT);
            return criteriaBuilder.like(
                    criteriaBuilder.lower(publisherJoin.get("name")),
                    "%" + searchCriteria.getValue() + "%"
            );
        } else
            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get(searchCriteria.getKey())),
                    "%" + searchCriteria.getValue() + "%"
            );
    }
}
