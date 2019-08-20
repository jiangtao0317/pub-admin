package com.fanle.moka.respo.user;

import com.fanle.moka.entity.user.domain.ShareRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareRecordRespo extends JpaRepository<ShareRecordEntity,Long> {

    ShareRecordEntity findFirstByShareRecodeId(String srid);
}
