package com.fanle.moka.entity.newadmin.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-08-17 16:54
 **/

@Entity
@Table(name = "moka_adsense_location", schema = "wenxue_newadmin", catalog = "")
public class MokaAdsenseLocationEntity {
    private String locationId;
    private String locationName;
    private String remark;
    private byte inuse;

    @Id
    @Column(name = "location_id")
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "location_name")
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
    @Column(name = "inuse")
    public byte getInuse() {
        return inuse;
    }

    public void setInuse(byte inuse) {
        this.inuse = inuse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaAdsenseLocationEntity that = (MokaAdsenseLocationEntity) o;
        return inuse == that.inuse &&
                Objects.equals(locationId, that.locationId) &&
                Objects.equals(locationName, that.locationName) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationName, remark, inuse);
    }
}
