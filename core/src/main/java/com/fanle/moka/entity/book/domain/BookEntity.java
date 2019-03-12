package com.fanle.moka.entity.book.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book", schema = "wenxue_book", catalog = "")
public class BookEntity {
    private Long seqid;
    private String bookid;
    private String typeid;
    private String bookname;
    private String author;
    private String desc;
    private String classIclines;
    private String coverimg;
    private String majorRole;
    private String grant;
    private String source;
    private String createstatus;
    private String originalflag;
    private String tags;
    private String onlineflag;
    private String feeflag;
    private String task;
    private int startfeeChapter;
    private int totalfee;
    private int totalchapter;
    private int totalwords;
    private int totalsubscribes;
    private int randomSubscribes;
    private int totalreadtimes;
    private int totalNews;
    private int totalvotes;
    private int randomVotes;
    private int heats;
    private int attendNum;
    private String firstrelease;
    private String lastrelease;
    private String onlinetime;
    private String editTime;
    private String editby;
    private String originalBookId;
    private String downloadUrl;
    private String displayName;
    private String originalTypeId;
    private Integer originalHeats;
    private Integer systemHeats;
    private String authorid;
    private String declaration;
    private String modifytime;
    private String chargetype;
    private int unitprice;
    private String discountid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "bookid")
    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
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
    @Column(name = "bookname")
    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "classIclines")
    public String getClassIclines() {
        return classIclines;
    }

    public void setClassIclines(String classIclines) {
        this.classIclines = classIclines;
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
    @Column(name = "majorRole")
    public String getMajorRole() {
        return majorRole;
    }

    public void setMajorRole(String majorRole) {
        this.majorRole = majorRole;
    }

    @Basic
    @Column(name = "grant")
    public String getGrant() {
        return grant;
    }

    public void setGrant(String grant) {
        this.grant = grant;
    }

    @Basic
    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Basic
    @Column(name = "createstatus")
    public String getCreatestatus() {
        return createstatus;
    }

    public void setCreatestatus(String createstatus) {
        this.createstatus = createstatus;
    }

    @Basic
    @Column(name = "originalflag")
    public String getOriginalflag() {
        return originalflag;
    }

    public void setOriginalflag(String originalflag) {
        this.originalflag = originalflag;
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
    @Column(name = "onlineflag")
    public String getOnlineflag() {
        return onlineflag;
    }

    public void setOnlineflag(String onlineflag) {
        this.onlineflag = onlineflag;
    }

    @Basic
    @Column(name = "feeflag")
    public String getFeeflag() {
        return feeflag;
    }

    public void setFeeflag(String feeflag) {
        this.feeflag = feeflag;
    }

    @Basic
    @Column(name = "task")
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Basic
    @Column(name = "startfeeChapter")
    public int getStartfeeChapter() {
        return startfeeChapter;
    }

    public void setStartfeeChapter(int startfeeChapter) {
        this.startfeeChapter = startfeeChapter;
    }

    @Basic
    @Column(name = "totalfee")
    public int getTotalfee() {
        return totalfee;
    }

    public void setTotalfee(int totalfee) {
        this.totalfee = totalfee;
    }

    @Basic
    @Column(name = "totalchapter")
    public int getTotalchapter() {
        return totalchapter;
    }

    public void setTotalchapter(int totalchapter) {
        this.totalchapter = totalchapter;
    }

    @Basic
    @Column(name = "totalwords")
    public int getTotalwords() {
        return totalwords;
    }

    public void setTotalwords(int totalwords) {
        this.totalwords = totalwords;
    }

    @Basic
    @Column(name = "totalsubscribes")
    public int getTotalsubscribes() {
        return totalsubscribes;
    }

    public void setTotalsubscribes(int totalsubscribes) {
        this.totalsubscribes = totalsubscribes;
    }

    @Basic
    @Column(name = "randomSubscribes")
    public int getRandomSubscribes() {
        return randomSubscribes;
    }

    public void setRandomSubscribes(int randomSubscribes) {
        this.randomSubscribes = randomSubscribes;
    }

    @Basic
    @Column(name = "totalreadtimes")
    public int getTotalreadtimes() {
        return totalreadtimes;
    }

    public void setTotalreadtimes(int totalreadtimes) {
        this.totalreadtimes = totalreadtimes;
    }

    @Basic
    @Column(name = "totalNews")
    public int getTotalNews() {
        return totalNews;
    }

    public void setTotalNews(int totalNews) {
        this.totalNews = totalNews;
    }

    @Basic
    @Column(name = "totalvotes")
    public int getTotalvotes() {
        return totalvotes;
    }

    public void setTotalvotes(int totalvotes) {
        this.totalvotes = totalvotes;
    }

    @Basic
    @Column(name = "randomVotes")
    public int getRandomVotes() {
        return randomVotes;
    }

    public void setRandomVotes(int randomVotes) {
        this.randomVotes = randomVotes;
    }

    @Basic
    @Column(name = "heats")
    public int getHeats() {
        return heats;
    }

    public void setHeats(int heats) {
        this.heats = heats;
    }

    @Basic
    @Column(name = "attendNum")
    public int getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(int attendNum) {
        this.attendNum = attendNum;
    }

    @Basic
    @Column(name = "firstrelease")
    public String getFirstrelease() {
        return firstrelease;
    }

    public void setFirstrelease(String firstrelease) {
        this.firstrelease = firstrelease;
    }

    @Basic
    @Column(name = "lastrelease")
    public String getLastrelease() {
        return lastrelease;
    }

    public void setLastrelease(String lastrelease) {
        this.lastrelease = lastrelease;
    }

    @Basic
    @Column(name = "onlinetime")
    public String getOnlinetime() {
        return onlinetime;
    }

    public void setOnlinetime(String onlinetime) {
        this.onlinetime = onlinetime;
    }

    @Basic
    @Column(name = "editTime")
    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
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
    @Column(name = "originalBookId")
    public String getOriginalBookId() {
        return originalBookId;
    }

    public void setOriginalBookId(String originalBookId) {
        this.originalBookId = originalBookId;
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
    @Column(name = "displayName")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "originalTypeId")
    public String getOriginalTypeId() {
        return originalTypeId;
    }

    public void setOriginalTypeId(String originalTypeId) {
        this.originalTypeId = originalTypeId;
    }

    @Basic
    @Column(name = "originalHeats")
    public Integer getOriginalHeats() {
        return originalHeats;
    }

    public void setOriginalHeats(Integer originalHeats) {
        this.originalHeats = originalHeats;
    }

    @Basic
    @Column(name = "systemHeats")
    public Integer getSystemHeats() {
        return systemHeats;
    }

    public void setSystemHeats(Integer systemHeats) {
        this.systemHeats = systemHeats;
    }

    @Basic
    @Column(name = "authorid")
    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    @Basic
    @Column(name = "declaration")
    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    @Basic
    @Column(name = "modifytime")
    public String getModifytime() {
        return modifytime;
    }

    public void setModifytime(String modifytime) {
        this.modifytime = modifytime;
    }

    @Basic
    @Column(name = "chargetype")
    public String getChargetype() {
        return chargetype;
    }

    public void setChargetype(String chargetype) {
        this.chargetype = chargetype;
    }

    @Basic
    @Column(name = "unitprice")
    public int getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(int unitprice) {
        this.unitprice = unitprice;
    }

    @Basic
    @Column(name = "discountid")
    public String getDiscountid() {
        return discountid;
    }

    public void setDiscountid(String discountid) {
        this.discountid = discountid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return seqid == that.seqid &&
                startfeeChapter == that.startfeeChapter &&
                totalfee == that.totalfee &&
                totalchapter == that.totalchapter &&
                totalwords == that.totalwords &&
                totalsubscribes == that.totalsubscribes &&
                randomSubscribes == that.randomSubscribes &&
                totalreadtimes == that.totalreadtimes &&
                totalNews == that.totalNews &&
                totalvotes == that.totalvotes &&
                randomVotes == that.randomVotes &&
                heats == that.heats &&
                attendNum == that.attendNum &&
                unitprice == that.unitprice &&
                Objects.equals(bookid, that.bookid) &&
                Objects.equals(typeid, that.typeid) &&
                Objects.equals(bookname, that.bookname) &&
                Objects.equals(author, that.author) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(classIclines, that.classIclines) &&
                Objects.equals(coverimg, that.coverimg) &&
                Objects.equals(majorRole, that.majorRole) &&
                Objects.equals(grant, that.grant) &&
                Objects.equals(source, that.source) &&
                Objects.equals(createstatus, that.createstatus) &&
                Objects.equals(originalflag, that.originalflag) &&
                Objects.equals(tags, that.tags) &&
                Objects.equals(onlineflag, that.onlineflag) &&
                Objects.equals(feeflag, that.feeflag) &&
                Objects.equals(task, that.task) &&
                Objects.equals(firstrelease, that.firstrelease) &&
                Objects.equals(lastrelease, that.lastrelease) &&
                Objects.equals(onlinetime, that.onlinetime) &&
                Objects.equals(editTime, that.editTime) &&
                Objects.equals(editby, that.editby) &&
                Objects.equals(originalBookId, that.originalBookId) &&
                Objects.equals(downloadUrl, that.downloadUrl) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(originalTypeId, that.originalTypeId) &&
                Objects.equals(originalHeats, that.originalHeats) &&
                Objects.equals(systemHeats, that.systemHeats) &&
                Objects.equals(authorid, that.authorid) &&
                Objects.equals(declaration, that.declaration) &&
                Objects.equals(modifytime, that.modifytime) &&
                Objects.equals(chargetype, that.chargetype) &&
                Objects.equals(discountid, that.discountid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, bookid, typeid, bookname, author, desc, classIclines, coverimg, majorRole, grant, source, createstatus, originalflag, tags, onlineflag, feeflag, task, startfeeChapter, totalfee, totalchapter, totalwords, totalsubscribes, randomSubscribes, totalreadtimes, totalNews, totalvotes, randomVotes, heats, attendNum, firstrelease, lastrelease, onlinetime, editTime, editby, originalBookId, downloadUrl, displayName, originalTypeId, originalHeats, systemHeats, authorid, declaration, modifytime, chargetype, unitprice, discountid);
    }
}
