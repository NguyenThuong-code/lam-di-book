package com.example.boschtryhard.convertter;

import com.example.boschtryhard.dto.BookDTO;
import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.model.Category;
import com.example.boschtryhard.model.Warehouse;
import com.example.boschtryhard.model.WarehouseBook;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookConverter {
    public static BookDTO BookEntityToBookDTO(Book bookEntity){
        BookDTO dto = new BookDTO();
        dto.setId(bookEntity.getId());
        dto.setName(bookEntity.getName());
        Category category= bookEntity.getCategoryId();
        dto.setCategory(category.getCategory());
        dto.setAuthor(ComponentConverter.authorEntityToAuthorDTO(bookEntity.getAuthorId()));
        dto.setPublisher(ComponentConverter.publisherEntityToDTO(bookEntity.getPublisherId()));
        dto.setPrice(bookEntity.getPrice());
        List<WarehouseBook> warehouseBookEntity= bookEntity.getWarehouseBookList();
        if (warehouseBookEntity!= null){
            for (int i = 0; i < warehouseBookEntity.size(); i++) {
                dto.setQuantity(warehouseBookEntity.get(i).getQuantity());
                Warehouse warehouseEntity = warehouseBookEntity.get(i).getWarehouseCode();
                if (warehouseEntity!= null){
                    dto.setWarehouseCode(warehouseBookEntity.get(i).getWarehouseCode().getId());
                    dto.setAddressWarehouse(warehouseBookEntity.get(i).getWarehouseCode().getWareHouseAddress());
                }
            }
        }
        dto.setCodeBook(bookEntity.getCodeBook());
        return dto;
    }
    public static Map<String, Object> BookDTOToMap(Page<BookDTO> bookPage){
        Map<String, Object> response= new HashMap<>();
        response.put("requests", bookPage.getContent());
        response.put("currentPage", bookPage.getNumber());
        response.put("totalItems", bookPage.getTotalElements());
        response.put("totalPages", bookPage.getTotalPages());
        return  response;
    }
}
