package com.example.boschtryhard.convertter;

import com.example.boschtryhard.dto.AuthorDTO;
import com.example.boschtryhard.dto.PublisherDTO;
import com.example.boschtryhard.model.Author;
import com.example.boschtryhard.model.Publisher;

public class ComponentConverter {
public static AuthorDTO authorEntityToAuthorDTO(Author authorEntity){
    if(authorEntity!=null){
        AuthorDTO dto= new AuthorDTO();
        dto.setAuthorName(authorEntity.getAuthorName());
        dto.setAuthorAddress(authorEntity.getAuthorAddress());
        dto.setAuthorEmail(authorEntity.getAuthorEmail());
        return dto;
    }
    return null;
}
public static PublisherDTO publisherEntityToDTO(Publisher publisherEntity){
    if (publisherEntity!=null){
        PublisherDTO dto = new PublisherDTO();
        dto.setPublisherName(publisherEntity.getPublisherName());
        dto.setPublisherAddress(publisherEntity.getPublisherAddress());
        return dto;
    }
    return null;
}
}
