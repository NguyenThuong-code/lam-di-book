package com.example.boschtryhard.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO {
    private long id;
  private String name;
  private String category;
  private AuthorDTO author;
  private PublisherDTO publisher;
  private Double price;
  private String addressWarehouse;
  private int quantity;
private Long warehouseCode;
    private String codeBook;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public PublisherDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAddressWarehouse() {
        return addressWarehouse;
    }

    public void setAddressWarehouse(String addressWarehouse) {
        this.addressWarehouse = addressWarehouse;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(Long warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }
}
