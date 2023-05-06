package com.example.boschtryhard.service.serviceimpl;

import com.example.boschtryhard.convertter.BookConverter;
import com.example.boschtryhard.dto.BookDTO;
import com.example.boschtryhard.dto.PageBookDTO;
import com.example.boschtryhard.model.Book;
import com.example.boschtryhard.repo.BookRepository;
import com.example.boschtryhard.service.BookService;
import com.example.boschtryhard.specification.RequestBookSpecification;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Map<String, Object> getAllRequest(PageBookDTO pageBookDTO) {
        Pageable paging = PageRequest.of(pageBookDTO.getPage(), pageBookDTO.getSize(), Sort.by(Sort.Direction.DESC, "id"));
        Page<Book> filterPageBook= this.bookRepository.findAll(
                RequestBookSpecification.authorLike(pageBookDTO.getAuthorNameFilter())
                        .and(RequestBookSpecification.categoryIn(pageBookDTO.getCategoriesFilter()))
                        .and(RequestBookSpecification.publisherLike(pageBookDTO.getPublisherNameFilter())),
        paging);
        Page<BookDTO> bookDTOS = filterPageBook.map(BookConverter::BookEntityToBookDTO);
        return BookConverter.BookDTOToMap(bookDTOS);
    }
    @Override
    public Boolean updateBook(Map<String, String> req){
        Boolean result = false;
        try {
            Long idBook= Long.valueOf(req.get("id"));
            Optional<Book> requestConFixBook= this.bookRepository.findById(idBook);
            if (!requestConFixBook.isEmpty()){
                Book book= requestConFixBook.get();
                book.setPrice(Double.valueOf(req.get("price")));
                book.setCodeBook(req.get("codeBook"));
                this.bookRepository.save(book);
                result= true;
            }
        } catch (Exception e) {
           return false;
        }
        return result;
    }
@Transactional
    @Override
    public Boolean deleteRequestBookByIds(List<Long> ids) {
        Boolean result= false;
    Integer numberOfDelete=0;
        try {
                 numberOfDelete= bookRepository.deleteByBookIds(ids);
                if (numberOfDelete>0){
                    result=true;
                }
        }catch (Exception e){
            return  false;
        }
        return result;
    }

    @Override
    public byte[] generateBookExcel(PageBookDTO pageBookDTO) throws IOException {

        List<Book> filterPageBook= this.bookRepository.findAll(
                RequestBookSpecification.authorLike(pageBookDTO.getAuthorNameFilter())
                        .and(RequestBookSpecification.categoryIn(pageBookDTO.getCategoriesFilter()))
                        .and(RequestBookSpecification.publisherLike(pageBookDTO.getPublisherNameFilter()))
                );
//        List<Book> bookEntityList = filterPageBook.getContent();
        Workbook workbook= new SXSSFWorkbook();
        CellStyle headerCellStyle= workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont= workbook.createFont();
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setBorderRight(BorderStyle.THIN);

        CellStyle cellStyle =workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);

        HashMap<Integer, String> headerMap = new HashMap<>();
        headerMap.put(0, "Book Name");
        headerMap.put(1, "Category");
        headerMap.put(2, "Name Author");
        headerMap.put(3, "Publisher Name");
        headerMap.put(4, "Quantity");
        headerMap.put(5, "Warehouse Code");
        headerMap.put(6, "Warehouse Address");
        Sheet sheet=workbook.createSheet("Data");
        Row headerRow= sheet.createRow(0);
        Cell cell=null;
        for (int i = 0; i < headerMap.size(); i++) {
            cell=headerRow.createCell(i);
            cell.setCellValue(headerMap.get(i));
            cell.setCellStyle(headerCellStyle);
            sheet.setColumnWidth(i, 25*250);
        }
        int rowNum =1;
        for (Book bookEntity: filterPageBook
             ) {
            BookDTO item = BookConverter.BookEntityToBookDTO(bookEntity);
            Row row =sheet.createRow(rowNum++);
            Cell c= null;
            c=row.createCell(0);
            c.setCellValue(item.getName());
            c.setCellStyle(cellStyle);
            c=row.createCell(1);
            c.setCellValue(item.getCategory());
            c.setCellStyle(cellStyle);
            c=row.createCell(2);
            c.setCellValue(item.getAuthor().getAuthorName());
            c.setCellStyle(cellStyle);
            c=row.createCell(3);
            c.setCellValue(item.getPublisher().getPublisherName());
            c.setCellStyle(cellStyle);
            c=row.createCell(4);
            c.setCellValue(item.getQuantity());
            c.setCellStyle(cellStyle);
           if (item.getWarehouseCode()!= null){
               c=row.createCell(5);
               c.setCellValue(item.getWarehouseCode());
           }
            c.setCellStyle(cellStyle);
            c=row.createCell(6);
            c.setCellValue(item.getAddressWarehouse());
            c.setCellStyle(cellStyle);
        }
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] bytes=outputStream.toByteArray();
        outputStream.close();
        return bytes;
    }

}
