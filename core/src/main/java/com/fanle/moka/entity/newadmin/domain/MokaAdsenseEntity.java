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
@Table(name = "moka_adsense", schema = "wenxue_newadmin", catalog = "")
public class MokaAdsenseEntity {
    private long seqid;
    private String adsenseId;
    private String name;
    private String location;
    private int rate;
    private String cid;
    private Timestamp createTime;
    private Timestamp editTime;
    private String cname;
    private String creator;
    private String editor;
    private byte inuse;
    private byte type;
    private String remark;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "rate")
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
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
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "editTime")
    public Timestamp getEditTime() {
        return editTime;
    }

    public void setEditTime(Timestamp editTime) {
        this.editTime = editTime;
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
    @Column(name = "creator")
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
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
    @Column(name = "type")
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaAdsenseEntity that = (MokaAdsenseEntity) o;
        return seqid == that.seqid &&
                rate == that.rate &&
                inuse == that.inuse &&
                type == that.type &&
                Objects.equals(adsenseId, that.adsenseId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(location, that.location) &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(editTime, that.editTime) &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(remark, that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, adsenseId, name, location, rate, cid, createTime, editTime, cname, creator, editor, inuse, type, remark);
    }
}
