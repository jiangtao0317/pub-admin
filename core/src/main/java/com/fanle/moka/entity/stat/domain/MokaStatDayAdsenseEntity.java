package com.fanle.moka.entity.stat.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-08-17 16:54
 **/

@Entity
@Table(name = "moka_stat_day_adsense", schema = "wenxue_statistics", catalog = "")
public class MokaStatDayAdsenseEntity {
    private long seqid;
    private String adsenseId;
    private String cid;
    private String date;
    private String platform;
    private int rateMoney;
    private int showNum;
    private int showRate;
    private int statMoney;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "adsense_id")
    public String getAdsenseId() {
        return adsenseId;
    }

    public void setAdsenseId(String adsenseId) {
        this.adsenseId = adsenseId;
    }

    @Basic
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "platform")
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "rate_money")
    public int getRateMoney() {
        return rateMoney;
    }

    public void setRateMoney(int rateMoney) {
        this.rateMoney = rateMoney;
    }

    @Basic
    @Column(name = "show_num")
    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    @Basic
    @Column(name = "show_rate")
    public int getShowRate() {
        return showRate;
    }

    public void setShowRate(int showRate) {
        this.showRate = showRate;
    }

    @Basic
    @Column(name = "stat_money")
    public int getStatMoney() {
        return statMoney;
    }

    public void setStatMoney(int statMoney) {
        this.statMoney = statMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatDayAdsenseEntity that = (MokaStatDayAdsenseEntity) o;
        return seqid == that.seqid &&
                rateMoney == that.rateMoney &&
                showNum == that.showNum &&
                showRate == that.showRate &&
                statMoney == that.statMoney &&
                Objects.equals(adsenseId, that.adsenseId) &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(date, that.date) &&
                Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, adsenseId, cid, date, platform, rateMoney, showNum, showRate, statMoney);
    }
}
