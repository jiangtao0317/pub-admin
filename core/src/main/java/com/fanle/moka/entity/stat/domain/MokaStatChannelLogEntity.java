package com.fanle.moka.entity.stat.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-08-07 12:27
 **/

@Entity
@Table(name = "moka_stat_channel_log", schema = "wenxue_statistics", catalog = "")
public class MokaStatChannelLogEntity {
    private Long seqid;
    private String cid;
    private String date;
    private int h5PayMoney;
    private int h5RateMoney;
    private int h5StatMoney;
    private int h5StatRate;
    private int pcInstallRate;
    private int pcInstallUv;
    private int pcPayMoney;
    private int pcSinglePrice;
    private int pcStatInstallUv;
    private int pcStatUninstallUv;
    private int pcUninstallRate;
    private int pcUninstallUv;
    private String platform;
    private String cname;
    private byte h5AdsenseStatType;
    private byte h5StatType;
    private int h5AdsenseRateMoney;
    private int h5AdsenseStatMoney;
    private int h5AdsenseStatRate;
    private String adsenseOrderId;
    private byte adsenseOrderStatus;
    private String payOrderId;
    private byte payOrderStatus;

    @Basic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seqid")
    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
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
    @Column(name = "h5_pay_money")
    public int getH5PayMoney() {
        return h5PayMoney;
    }

    public void setH5PayMoney(int h5PayMoney) {
        this.h5PayMoney = h5PayMoney;
    }

    @Basic
    @Column(name = "h5_rate_money")
    public int getH5RateMoney() {
        return h5RateMoney;
    }

    public void setH5RateMoney(int h5RateMoney) {
        this.h5RateMoney = h5RateMoney;
    }

    @Basic
    @Column(name = "h5_stat_money")
    public int getH5StatMoney() {
        return h5StatMoney;
    }

    public void setH5StatMoney(int h5StatMoney) {
        this.h5StatMoney = h5StatMoney;
    }

    @Basic
    @Column(name = "h5_stat_rate")
    public int getH5StatRate() {
        return h5StatRate;
    }

    public void setH5StatRate(int h5StatRate) {
        this.h5StatRate = h5StatRate;
    }

    @Basic
    @Column(name = "pc_install_rate")
    public int getPcInstallRate() {
        return pcInstallRate;
    }

    public void setPcInstallRate(int pcInstallRate) {
        this.pcInstallRate = pcInstallRate;
    }

    @Basic
    @Column(name = "pc_install_uv")
    public int getPcInstallUv() {
        return pcInstallUv;
    }

    public void setPcInstallUv(int pcInstallUv) {
        this.pcInstallUv = pcInstallUv;
    }

    @Basic
    @Column(name = "pc_pay_money")
    public int getPcPayMoney() {
        return pcPayMoney;
    }

    public void setPcPayMoney(int pcPayMoney) {
        this.pcPayMoney = pcPayMoney;
    }

    @Basic
    @Column(name = "pc_single_price")
    public int getPcSinglePrice() {
        return pcSinglePrice;
    }

    public void setPcSinglePrice(int pcSinglePrice) {
        this.pcSinglePrice = pcSinglePrice;
    }

    @Basic
    @Column(name = "pc_stat_install_uv")
    public int getPcStatInstallUv() {
        return pcStatInstallUv;
    }

    public void setPcStatInstallUv(int pcStatInstallUv) {
        this.pcStatInstallUv = pcStatInstallUv;
    }

    @Basic
    @Column(name = "pc_stat_uninstall_uv")
    public int getPcStatUninstallUv() {
        return pcStatUninstallUv;
    }

    public void setPcStatUninstallUv(int pcStatUninstallUv) {
        this.pcStatUninstallUv = pcStatUninstallUv;
    }

    @Basic
    @Column(name = "pc_uninstall_rate")
    public int getPcUninstallRate() {
        return pcUninstallRate;
    }

    public void setPcUninstallRate(int pcUninstallRate) {
        this.pcUninstallRate = pcUninstallRate;
    }

    @Basic
    @Column(name = "pc_uninstall_uv")
    public int getPcUninstallUv() {
        return pcUninstallUv;
    }

    public void setPcUninstallUv(int pcUninstallUv) {
        this.pcUninstallUv = pcUninstallUv;
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
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "h5_adsense_stat_type")
    public byte getH5AdsenseStatType() {
        return h5AdsenseStatType;
    }

    public void setH5AdsenseStatType(byte h5AdsenseStatType) {
        this.h5AdsenseStatType = h5AdsenseStatType;
    }

    @Basic
    @Column(name = "h5_stat_type")
    public byte getH5StatType() {
        return h5StatType;
    }

    public void setH5StatType(byte h5StatType) {
        this.h5StatType = h5StatType;
    }

    @Basic
    @Column(name = "h5_adsense_rate_money")
    public int getH5AdsenseRateMoney() {
        return h5AdsenseRateMoney;
    }

    public void setH5AdsenseRateMoney(int h5AdsenseRateMoney) {
        this.h5AdsenseRateMoney = h5AdsenseRateMoney;
    }

    @Basic
    @Column(name = "h5_adsense_stat_money")
    public int getH5AdsenseStatMoney() {
        return h5AdsenseStatMoney;
    }

    public void setH5AdsenseStatMoney(int h5AdsenseStatMoney) {
        this.h5AdsenseStatMoney = h5AdsenseStatMoney;
    }

    @Basic
    @Column(name = "h5_adsense_stat_rate")
    public int getH5AdsenseStatRate() {
        return h5AdsenseStatRate;
    }

    public void setH5AdsenseStatRate(int h5AdsenseStatRate) {
        this.h5AdsenseStatRate = h5AdsenseStatRate;
    }

    @Basic
    @Column(name = "adsense_order_id")
    public String getAdsenseOrderId() {
        return adsenseOrderId;
    }

    public void setAdsenseOrderId(String adsenseOrderId) {
        this.adsenseOrderId = adsenseOrderId;
    }

    @Basic
    @Column(name = "adsense_order_status")
    public byte getAdsenseOrderStatus() {
        return adsenseOrderStatus;
    }

    public void setAdsenseOrderStatus(byte adsenseOrderStatus) {
        this.adsenseOrderStatus = adsenseOrderStatus;
    }

    @Basic
    @Column(name = "pay_order_id")
    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    @Basic
    @Column(name = "pay_order_status")
    public byte getPayOrderStatus() {
        return payOrderStatus;
    }

    public void setPayOrderStatus(byte payOrderStatus) {
        this.payOrderStatus = payOrderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatChannelLogEntity that = (MokaStatChannelLogEntity) o;
        return seqid == that.seqid &&
                h5PayMoney == that.h5PayMoney &&
                h5RateMoney == that.h5RateMoney &&
                h5StatMoney == that.h5StatMoney &&
                h5StatRate == that.h5StatRate &&
                pcInstallRate == that.pcInstallRate &&
                pcInstallUv == that.pcInstallUv &&
                pcPayMoney == that.pcPayMoney &&
                pcSinglePrice == that.pcSinglePrice &&
                pcStatInstallUv == that.pcStatInstallUv &&
                pcStatUninstallUv == that.pcStatUninstallUv &&
                pcUninstallRate == that.pcUninstallRate &&
                pcUninstallUv == that.pcUninstallUv &&
                h5AdsenseStatType == that.h5AdsenseStatType &&
                h5StatType == that.h5StatType &&
                h5AdsenseRateMoney == that.h5AdsenseRateMoney &&
                h5AdsenseStatMoney == that.h5AdsenseStatMoney &&
                h5AdsenseStatRate == that.h5AdsenseStatRate &&
                adsenseOrderStatus == that.adsenseOrderStatus &&
                payOrderStatus == that.payOrderStatus &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(date, that.date) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(adsenseOrderId, that.adsenseOrderId) &&
                Objects.equals(payOrderId, that.payOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, cid, date, h5PayMoney, h5RateMoney, h5StatMoney, h5StatRate, pcInstallRate, pcInstallUv, pcPayMoney, pcSinglePrice, pcStatInstallUv, pcStatUninstallUv, pcUninstallRate, pcUninstallUv, platform, cname, h5AdsenseStatType, h5StatType, h5AdsenseRateMoney, h5AdsenseStatMoney, h5AdsenseStatRate, adsenseOrderId, adsenseOrderStatus, payOrderId, payOrderStatus);
    }
}
