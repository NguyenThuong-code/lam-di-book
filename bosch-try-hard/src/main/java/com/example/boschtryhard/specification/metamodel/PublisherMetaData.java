package com.example.boschtryhard.specification.metamodel;

import com.example.boschtryhard.model.Author;
import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.model.Publisher;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcesssor")
@StaticMetamodel(Publisher.class)
public abstract class PublisherMetaData {
    public static volatile SingularAttribute<Publisher, String> publisherName;
    public static final String PUBLISHERNAME="publisherName";
}
