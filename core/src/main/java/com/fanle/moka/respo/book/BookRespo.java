package com.fanle.moka.respo.book;

import com.fanle.moka.entity.book.domain.BookEntity;
import com.fanle.moka.vo.BookVo;
import com.fanle.moka.vo.MokaConstant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRespo extends JpaRepository<BookEntity,Long> {

    BookEntity findFirstBySeqid(Long seqid);

    List<BookEntity> findAllBySource(String source);

    List<BookEntity> findAllByBookid(String bookid);

    List<BookEntity> findAllBySourceIn(Set<String> sources);

    @Query("select new com.fanle.moka.vo.BookVo(a.bookid,b.alltypename,a.tags) from BookEntity a ,BooktypeEntity b where a.typeid = b.typeid and b.level = '2' and a.onlineflag = '"+ MokaConstant.ONLINE +"'")
    List<BookVo> findAllBookVo();

}
