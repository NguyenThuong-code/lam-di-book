package com.example.boschtryhard.specification.metamodel;

import com.example.boschtryhard.model.Author;
import com.example.boschtryhard.model.Book;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcesssor")
@StaticMetamodel(Author.class)
public abstract class AuthorMetaData {
    public static volatile SingularAttribute< Author,String> authorName;
    public static final String AUTHORNAME="authorName";
}
