package com.example.boschtryhard.controller;

import com.example.boschtryhard.dto.PageBookDTO;
import com.example.boschtryhard.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping(value = "/book/all/request")
    public ResponseEntity<Map<String,Object>> getAllBookPagination(@RequestBody PageBookDTO pageBookDTO){
        return ResponseEntity.ok().body(this.bookService.getAllRequest(pageBookDTO));
    }
    @PostMapping(value = "/book/update/task")
    public ResponseEntity<Boolean> updateTask(@RequestBody Map<String, String> body){
Boolean result= this.bookService.updateBook(body);
        if (!result) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
    @PostMapping(value = "/book/export-excel")
    public ResponseEntity<byte[]> exportExcelForBook(@RequestBody PageBookDTO pageBookDTO){
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "my-data.xlsx");
        try {
            byte[] outputStream = bookService.generateBookExcel(pageBookDTO);
            headers.setContentLength(outputStream.length);
            return new ResponseEntity<>(outputStream,headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, headers,HttpStatus.OK);
        }
    }
    @DeleteMapping(value = "/book/delete-by-ids")
    public ResponseEntity<Boolean> deleteBookByIds(@RequestParam List<Long> ids){
        Boolean result= bookService.deleteRequestBookByIds(ids);
        if (!result){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(false);
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
