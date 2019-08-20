package com.fanle.moka.entity.book.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-06-21 19:28
 **/

@Entity
@Table(name = "booktag", schema = "wenxue_book", catalog = "")
public class BooktagEntity {
    private long seqid;
    private String tagid;
    private String addfrom;
    private String adduserid;
    private String tagname;
    private String edittime;
    private String editby;
    private String inuse;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "tagid")
    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    @Basic
    @Column(name = "addfrom")
    public String getAddfrom() {
        return addfrom;
    }

    public void setAddfrom(String addfrom) {
        this.addfrom = addfrom;
    }

    @Basic
    @Column(name = "adduserid")
    public String getAdduserid() {
        return adduserid;
    }

    public void setAdduserid(String adduserid) {
        this.adduserid = adduserid;
    }

    @Basic
    @Column(name = "tagname")
    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    @Basic
    @Column(name = "edittime")
    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }

    @Basic
    @Column(name = "editby")
    public String getEditby() {
        return editby;
    }

    public void setEditby(String editby) {
        this.editby = editby;
    }

    @Basic
    @Column(name = "inuse")
    public String getInuse() {
        return inuse;
    }

    public void setInuse(String inuse) {
        this.inuse = inuse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooktagEntity that = (BooktagEntity) o;
        return seqid == that.seqid &&
                Objects.equals(tagid, that.tagid) &&
                Objects.equals(addfrom, that.addfrom) &&
                Objects.equals(adduserid, that.adduserid) &&
                Objects.equals(tagname, that.tagname) &&
                Objects.equals(edittime, that.edittime) &&
                Objects.equals(editby, that.editby) &&
                Objects.equals(inuse, that.inuse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, tagid, addfrom, adduserid, tagname, edittime, editby, inuse);
    }
}
