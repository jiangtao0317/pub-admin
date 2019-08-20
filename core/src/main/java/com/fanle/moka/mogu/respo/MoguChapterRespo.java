package com.fanle.moka.mogu.respo;

import com.fanle.moka.entity.mogu.domain.HqStorysEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MoguChapterRespo  extends JpaRepository<HqStorysEntity,Integer> {

    @Query("select sum(a.len) from HqStorysEntity a where a.status = 2 and a.storyId = ?1")
    Long findByStoryId(Integer storyId);
}
