package com.fanle.moka.respo.stat;

import com.fanle.moka.entity.stat.domain.MokaStatChannelLogEntity;
import com.fanle.moka.vo.MokaChannelLogVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MokaStatChannelLogRespo extends JpaRepository<MokaStatChannelLogEntity,Long> {


    MokaStatChannelLogEntity findFirstByDateAndCidAndPlatform(String date, String cid , String platform);

    List<MokaStatChannelLogEntity> findAllByDateAndPlatformAndAdsenseOrderStatusAndH5AdsenseRateMoneyGreaterThan(String date, String platform, byte status, int money);

    List<MokaStatChannelLogEntity> findAllByPlatformAndAdsenseOrderStatusAndH5AdsenseRateMoneyGreaterThan(String platform, byte status, int money);

    List<MokaStatChannelLogEntity> findAllByPlatformAndAdsenseOrderStatusNotAndH5AdsenseRateMoneyGreaterThan(String platform, byte status, int money);

    List<MokaStatChannelLogEntity> findAllByDateLessThanAndPlatformAndAdsenseOrderStatusAndH5AdsenseRateMoneyGreaterThan(String date ,String platform, byte status, int money);

    List<MokaStatChannelLogEntity> findAllByDateAndPlatformAndPayOrderStatus(String date, String platform, byte status);

    @Query("select new com.fanle.moka.vo.MokaChannelLogVo(sum(h5AdsenseStatMoney),sum(h5AdsenseRateMoney),date) from " +
            "MokaStatChannelLogEntity where date between ?1 and ?2 and platform = ?3 group by date")
    List<MokaChannelLogVo> sumMoneyByDateAndPlatform(String startDate, String endDate, String platform);
    List<MokaStatChannelLogEntity> findAllByDateAndPlatformAndPayOrderStatusAndH5RateMoneyGreaterThan(String date, String platform, byte status,int rateMoney);
    List<MokaStatChannelLogEntity> findAllByDateLessThanAndPlatformAndPayOrderStatusAndH5RateMoneyGreaterThan(String date, String platform, byte status,int rateMoney);

    List<MokaStatChannelLogEntity> findAllByPlatformAndPayOrderStatusAndH5RateMoneyGreaterThan(String platform, byte status,int rateMoney);

    List<MokaStatChannelLogEntity> findAllByPlatformAndPayOrderStatusNotAndH5RateMoneyGreaterThan(String platform, byte status,int rateMoney);

}
