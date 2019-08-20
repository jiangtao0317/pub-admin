package com.fanle.moka.respo.book;

import com.fanle.moka.entity.book.domain.BooktagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTagRepo extends JpaRepository<BooktagEntity,Long> {

    @Query("select distinct tagname from BooktagEntity ")
    List<String> findAllTagName();
}
