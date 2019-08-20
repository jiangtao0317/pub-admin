package com.fanle.moka.entity.stat.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:15
 **/

public class MokaStatLogReportEntityPK implements Serializable {
    private Date date;
    private long seqid;

    @Column(name = "date")
    @Id
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "seqid")
    @Id
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatLogReportEntityPK that = (MokaStatLogReportEntityPK) o;
        return seqid == that.seqid &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, seqid);
    }
}
