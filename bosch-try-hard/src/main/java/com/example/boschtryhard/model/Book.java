package com.example.boschtryhard.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;

    @OneToMany(mappedBy = "bookId")
    private List<WarehouseBook> warehouseBookList;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisherId;

    @Column(name = "price")
    private Double price;

    @Column(name = "code_book")
    private String codeBook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public List<WarehouseBook> getWarehouseBookList() {
        return warehouseBookList;
    }

    public void setWarehouseBookList(List<WarehouseBook> warehouseBookList) {
        this.warehouseBookList = warehouseBookList;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }
}
