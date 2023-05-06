package com.example.boschtryhard.specification.metamodel;


import com.example.boschtryhard.model.Author;
import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.model.Category;
import com.example.boschtryhard.model.Publisher;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcesssor")
@StaticMetamodel(Book.class)
public abstract class RequestBook_ {
    public static volatile SingularAttribute<Book, Author> authorId;
    public static volatile SingularAttribute<Book, Category> categoryId;
    public static volatile SingularAttribute<Book, Publisher> publisherId;

    public static final String AUTHORID="authorId";
    public static final String CATEGORYID="categoryId";
    public static final String PUBLISHERID="publisherId";
}
