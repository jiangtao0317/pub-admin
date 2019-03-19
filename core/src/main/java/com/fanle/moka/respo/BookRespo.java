package com.fanle.moka.respo;
import com.fanle.moka.entity.book.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespo extends JpaRepository<BookEntity,Long> {

    BookEntity findFirstBySeqid(Long seqid);
}
