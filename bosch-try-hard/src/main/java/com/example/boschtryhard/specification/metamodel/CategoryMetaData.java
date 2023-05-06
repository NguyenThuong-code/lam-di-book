package com.example.boschtryhard.specification.metamodel;

import com.example.boschtryhard.model.Author;
import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.model.Category;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcesssor")
@StaticMetamodel(Category.class)
public abstract class CategoryMetaData {
    public static volatile SingularAttribute< Category,String> category;
    public static final String CATEGORY="category";
}
