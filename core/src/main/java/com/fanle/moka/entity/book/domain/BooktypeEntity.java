package com.fanle.moka.entity.book.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-06-22 10:21
 **/

@Entity
@Table(name = "booktype", schema = "wenxue_book", catalog = "")
public class BooktypeEntity {
    private long seqid;
    private String typeid;
    private String level;
    private String levelname;
    private String fathertypeid;
    private String coverimg;
    private int booknum;
    private String tags;
    private String downloadUrl;
    private String typename;
    private String alltypename;
    private int priority;
    private String edittime;
    private String editby;
    private int inUse;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "typeid")
    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    @Basic
    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Basic
    @Column(name = "levelname")
    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    @Basic
    @Column(name = "fathertypeid")
    public String getFathertypeid() {
        return fathertypeid;
    }

    public void setFathertypeid(String fathertypeid) {
        this.fathertypeid = fathertypeid;
    }

    @Basic
    @Column(name = "coverimg")
    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    @Basic
    @Column(name = "booknum")
    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    @Basic
    @Column(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "downloadUrl")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Basic
    @Column(name = "typename")
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Basic
    @Column(name = "alltypename")
    public String getAlltypename() {
        return alltypename;
    }

    public void setAlltypename(String alltypename) {
        this.alltypename = alltypename;
    }

    @Basic
    @Column(name = "priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
    @Column(name = "inUse")
    public int getInUse() {
        return inUse;
    }

    public void setInUse(int inUse) {
        this.inUse = inUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooktypeEntity that = (BooktypeEntity) o;
        return seqid == that.seqid &&
                booknum == that.booknum &&
                priority == that.priority &&
                inUse == that.inUse &&
                Objects.equals(typeid, that.typeid) &&
                Objects.equals(level, that.level) &&
                Objects.equals(levelname, that.levelname) &&
                Objects.equals(fathertypeid, that.fathertypeid) &&
                Objects.equals(coverimg, that.coverimg) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(downloadUrl, that.downloadUrl) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(alltypename, that.alltypename) &&
                Objects.equals(edittime, that.edittime) &&
                Objects.equals(editby, that.editby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, typeid, level, levelname, fathertypeid, coverimg, booknum, tags, downloadUrl, typename, alltypename, priority, edittime, editby, inUse);
    }
}
