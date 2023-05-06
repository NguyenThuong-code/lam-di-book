package com.example.boschtryhard.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "warehouseCode")
    private List<WarehouseBook> warehouseBookList;
    @Column(name = "warehouse_address")
    private String wareHouseAddress;
    @Column(name = "warehouse_phone")
    private String warehousePhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<WarehouseBook> getWarehouseBookList() {
        return warehouseBookList;
    }

    public void setWarehouseBookList(List<WarehouseBook> warehouseBookList) {
        this.warehouseBookList = warehouseBookList;
    }

    public String getWareHouseAddress() {
        return wareHouseAddress;
    }

    public void setWareHouseAddress(String wareHouseAddress) {
        this.wareHouseAddress = wareHouseAddress;
    }

    public String getWarehousePhone() {
        return warehousePhone;
    }

    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone;
    }
}
