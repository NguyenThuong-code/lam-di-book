package com.example.boschtryhard.service;

import com.example.boschtryhard.dto.PageBookDTO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface BookService {
    Map<String, Object> getAllRequest(PageBookDTO pageBookDTO);
    Boolean updateBook(Map<String, String> req);
    Boolean deleteRequestBookByIds(List<Long> ids);
    byte[]  generateBookExcel(PageBookDTO pageBookDTO)throws IOException;
}
