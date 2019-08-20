package com.fanle.moka.entity.stat.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:14
 **/

@Entity
@Table(name = "moka_stat_appstart", schema = "wenxue_statistics", catalog = "")
public class MokaStatAppstartEntity {
    private String sDeviceId;
    private String cid;
    private String firstStartTime;
    private String lastStartTime;
    private String userid;
    private String platform;
    private String version;
    private String aid;
    private String coid;
    private String spid;
    private String srid;

    @Id
    @Column(name = "sDeviceId")
    public String getsDeviceId() {
        return sDeviceId;
    }

    public void setsDeviceId(String sDeviceId) {
        this.sDeviceId = sDeviceId;
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
    @Column(name = "firstStartTime")
    public String getFirstStartTime() {
        return firstStartTime;
    }

    public void setFirstStartTime(String firstStartTime) {
        this.firstStartTime = firstStartTime;
    }

    @Basic
    @Column(name = "lastStartTime")
    public String getLastStartTime() {
        return lastStartTime;
    }

    public void setLastStartTime(String lastStartTime) {
        this.lastStartTime = lastStartTime;
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
    @Column(name = "platform")
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
    @Column(name = "coid")
    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatAppstartEntity that = (MokaStatAppstartEntity) o;
        return Objects.equals(sDeviceId, that.sDeviceId) &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(firstStartTime, that.firstStartTime) &&
                Objects.equals(lastStartTime, that.lastStartTime) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(version, that.version) &&
                Objects.equals(aid, that.aid) &&
                Objects.equals(coid, that.coid) &&
                Objects.equals(spid, that.spid) &&
                Objects.equals(srid, that.srid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sDeviceId, cid, firstStartTime, lastStartTime, userid, platform, version, aid, coid, spid, srid);
    }
}
