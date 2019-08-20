package com.fanle.moka.entity.stat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:15
 **/

@Entity
@Table(name = "moka_stat_log_report", schema = "wenxue_statistics", catalog = "")
@IdClass(MokaStatLogReportEntityPK.class)
public class MokaStatLogReportEntity {

    private Date date;
    private long seqid;
    private String aid;
    private String appScheme;
    private String browser;
    private String cid;
    private String coid;
    private Date datetime;
    private String deviceId;
    private String event;
    private String ext0;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;
    private String name;
    private String page;
    private String platform;
    private String spid;
    private String srid;
    private String unionid;
    private String userid;
    private String version;

    @Id
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "aid")
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    @Basic
    @Column(name = "appScheme")
    public String getAppScheme() {
        return appScheme;
    }

    public void setAppScheme(String appScheme) {
        this.appScheme = appScheme;
    }

    @Basic
    @Column(name = "browser")
    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
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
    @Column(name = "coid")
    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    @Basic
    @Column(name = "datetime")
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "ext0")
    public String getExt0() {
        return ext0;
    }

    public void setExt0(String ext0) {
        this.ext0 = ext0;
    }

    @Basic
    @Column(name = "ext1")
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "ext2")
    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    @Basic
    @Column(name = "ext3")
    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @Basic
    @Column(name = "ext4")
    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    @Basic
    @Column(name = "ext5")
    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "page")
    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
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
    @Column(name = "spid")
    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    @Basic
    @Column(name = "srid")
    public String getSrid() {
        return srid;
    }

    public void setSrid(String srid) {
        this.srid = srid;
    }

    @Basic
    @Column(name = "unionid")
    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatLogReportEntity that = (MokaStatLogReportEntity) o;
        return seqid == that.seqid &&
                Objects.equals(date, that.date) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(appScheme, that.appScheme) &&
                Objects.equals(browser, that.browser) &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(coid, that.coid) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(event, that.event) &&
                Objects.equals(ext0, that.ext0) &&
                Objects.equals(ext1, that.ext1) &&
                Objects.equals(ext2, that.ext2) &&
                Objects.equals(ext3, that.ext3) &&
                Objects.equals(ext4, that.ext4) &&
                Objects.equals(ext5, that.ext5) &&
                Objects.equals(name, that.name) &&
                Objects.equals(page, that.page) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(spid, that.spid) &&
                Objects.equals(srid, that.srid) &&
                Objects.equals(unionid, that.unionid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, seqid, aid, appScheme, browser, cid, coid, datetime, deviceId, event, ext0, ext1, ext2, ext3, ext4, ext5, name, page, platform, spid, srid, unionid, userid, version);
    }
}
