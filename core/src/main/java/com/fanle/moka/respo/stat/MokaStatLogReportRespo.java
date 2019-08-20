package com.fanle.moka.respo.stat;

import com.fanle.moka.entity.stat.domain.MokaStatLogReportEntity;
import com.fanle.moka.entity.stat.domain.MokaStatLogReportEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MokaStatLogReportRespo extends JpaRepository<MokaStatLogReportEntity, MokaStatLogReportEntityPK> {

    List<MokaStatLogReportEntity> findAllByDate(Date date);

//    @Query("select distinct a.deviceId from MokaStatLogReportEntity a where a.date between ?1 and ?2 and")
//    List<MokaStatLogReportEntity> findAllBy

    long countDistinctByDateAndEventAndDeviceIdInAndAid(String date,String event ,List<String> deviceIds,String aid);
}
