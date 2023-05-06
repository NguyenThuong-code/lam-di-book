package com.example.boschtryhard.repo;

import com.example.boschtryhard.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
@Modifying
    @Query("DELETE FROM Book b where b.id in ?1")
    Integer deleteByBookIds(List<Long> ids);
}
