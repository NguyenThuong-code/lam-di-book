package com.example.boschtryhard.specification;

import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.specification.metamodel.AuthorMetaData;
import com.example.boschtryhard.specification.metamodel.CategoryMetaData;
import com.example.boschtryhard.specification.metamodel.PublisherMetaData;
import com.example.boschtryhard.specification.metamodel.RequestBook_;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class RequestBookSpecification {
    public static Specification<Book> authorLike(String authorFilter){
        if (authorFilter==null){
            return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(RequestBook_.AUTHORID)
                .get(AuthorMetaData.AUTHORNAME),"%"+authorFilter+"%");
    }

    public static Specification<Book> categoryIn(List<String> categoryFilter){

        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get(RequestBook_.CATEGORYID)
              .get(CategoryMetaData.CATEGORY)).value(categoryFilter);
    }

    public static Specification<Book> publisherLike(String publisherFilter){
        if (publisherFilter==null){
            return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(RequestBook_.PUBLISHERID)
                .get(PublisherMetaData.PUBLISHERNAME),"%"+publisherFilter+"%");
    }
}
