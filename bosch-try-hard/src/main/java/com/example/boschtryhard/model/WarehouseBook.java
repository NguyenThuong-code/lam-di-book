package com.example.boschtryhard.model;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_book")
public class WarehouseBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouseCode;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @Column(name = "quantity")
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Warehouse getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Warehouse warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Book getBookId() {
        return bookId;
    }

    public void setBookId(Book bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
