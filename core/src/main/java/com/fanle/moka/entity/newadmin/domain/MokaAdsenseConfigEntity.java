package com.fanle.moka.entity.newadmin.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-08-17 16:53
 **/

@Entity
@Table(name = "moka_adsense_config", schema = "wenxue_newadmin", catalog = "")
public class MokaAdsenseConfigEntity {
    private long seqid;
    private String adsenseId;
    private String locationId;
    private byte index;
    private String remark;
    private String name;
    private byte inuse;
    private String domain;
    private String creator;
    private Timestamp createtime;

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
    @Column(name = "location_id")
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "index")
    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
    @Column(name = "inuse")
    public byte getInuse() {
        return inuse;
    }

    public void setInuse(byte inuse) {
        this.inuse = inuse;
    }

    @Basic
    @Column(name = "domain")
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Basic
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "createtime")
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaAdsenseConfigEntity that = (MokaAdsenseConfigEntity) o;
        return seqid == that.seqid &&
                index == that.index &&
                inuse == that.inuse &&
                Objects.equals(adsenseId, that.adsenseId) &&
                Objects.equals(locationId, that.locationId) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(name, that.name) &&
                Objects.equals(domain, that.domain) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createtime, that.createtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, adsenseId, locationId, index, remark, name, inuse, domain, creator, createtime);
    }
}
