package com.fanle.moka.mogu.respo;

import com.fanle.moka.entity.mogu.domain.HqStoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-03 18:40
 **/

@Repository
public interface MoguBookRespo  extends JpaRepository<HqStoryEntity,Integer> {

    List<HqStoryEntity> findAllByStoryAttr(byte attr);
}
