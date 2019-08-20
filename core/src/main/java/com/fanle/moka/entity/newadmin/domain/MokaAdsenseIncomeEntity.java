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
@Table(name = "moka_adsense_income", schema = "wenxue_newadmin", catalog = "")
public class MokaAdsenseIncomeEntity {
    private long seqid;
    private String locationId;
    private int income;
    private String date;
    private byte type;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
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
    @Column(name = "income")
    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
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
    @Column(name = "type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaAdsenseIncomeEntity that = (MokaAdsenseIncomeEntity) o;
        return seqid == that.seqid &&
                income == that.income &&
                type == that.type &&
                Objects.equals(locationId, that.locationId) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, locationId, income, date, type);
    }
}
