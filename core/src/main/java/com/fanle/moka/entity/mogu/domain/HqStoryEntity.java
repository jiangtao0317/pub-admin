package com.fanle.moka.entity.mogu.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-03 18:39
 **/

@Entity
@Table(name = "hq_story", schema = "mogu", catalog = "")
public class HqStoryEntity {
    private int id;
    private String title;
    private Long crdate;
    private Byte deleted;
    private Byte hidden;
    private Integer sorting;
    private String image;
    private Byte category;
    private String remark;
    private String keywords;
    private Byte storyAttr;
    private String summary;
    private int author;
    private Byte storyStatus;
    private Integer len;
    private Integer readNum;
    private Integer likes;
    private Integer comment;
    private String editor;
    private String designer;
    private String updateRemind;
    private Integer attention;
    private Byte vip;
    private long tstamp;
    private byte finish;
    private byte charge;
    private byte chapterChargeNum;
    private byte choice;
    private String smallCategory;
    private String authorDesc;
    private byte hotBook;
    private byte newBook;
    private byte scavengBook;
    private byte foundBook;
    private byte weeklySelect;
    private Integer gold;
    private int crUserid;
    private String content;
    private String authorRemark;
    private String elite;
    private long issueTime;
    private byte issue;
    private byte thematicArea;
    private long updateTime;
    private byte updateChapter;
    private String originalBookId;
    private byte bookSource;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "crdate")
    public Long getCrdate() {
        return crdate;
    }

    public void setCrdate(Long crdate) {
        this.crdate = crdate;
    }

    @Basic
    @Column(name = "deleted")
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "hidden")
    public Byte getHidden() {
        return hidden;
    }

    public void setHidden(Byte hidden) {
        this.hidden = hidden;
    }

    @Basic
    @Column(name = "sorting")
    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "category")
    public Byte getCategory() {
        return category;
    }

    public void setCategory(Byte category) {
        this.category = category;
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
    @Column(name = "keywords")
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @Basic
    @Column(name = "story_attr")
    public Byte getStoryAttr() {
        return storyAttr;
    }

    public void setStoryAttr(Byte storyAttr) {
        this.storyAttr = storyAttr;
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "author")
    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    @Basic
    @Column(name = "story_status")
    public Byte getStoryStatus() {
        return storyStatus;
    }

    public void setStoryStatus(Byte storyStatus) {
        this.storyStatus = storyStatus;
    }

    @Basic
    @Column(name = "len")
    public Integer getLen() {
        return len;
    }

    public void setLen(Integer len) {
        this.len = len;
    }

    @Basic
    @Column(name = "read_num")
    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    @Basic
    @Column(name = "likes")
    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "comment")
    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
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
    @Column(name = "designer")
    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    @Basic
    @Column(name = "update_remind")
    public String getUpdateRemind() {
        return updateRemind;
    }

    public void setUpdateRemind(String updateRemind) {
        this.updateRemind = updateRemind;
    }

    @Basic
    @Column(name = "attention")
    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    @Basic
    @Column(name = "vip")
    public Byte getVip() {
        return vip;
    }

    public void setVip(Byte vip) {
        this.vip = vip;
    }

    @Basic
    @Column(name = "tstamp")
    public long getTstamp() {
        return tstamp;
    }

    public void setTstamp(long tstamp) {
        this.tstamp = tstamp;
    }

    @Basic
    @Column(name = "finish")
    public byte getFinish() {
        return finish;
    }

    public void setFinish(byte finish) {
        this.finish = finish;
    }

    @Basic
    @Column(name = "charge")
    public byte getCharge() {
        return charge;
    }

    public void setCharge(byte charge) {
        this.charge = charge;
    }

    @Basic
    @Column(name = "chapter_charge_num")
    public byte getChapterChargeNum() {
        return chapterChargeNum;
    }

    public void setChapterChargeNum(byte chapterChargeNum) {
        this.chapterChargeNum = chapterChargeNum;
    }

    @Basic
    @Column(name = "choice")
    public byte getChoice() {
        return choice;
    }

    public void setChoice(byte choice) {
        this.choice = choice;
    }

    @Basic
    @Column(name = "small_category")
    public String getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }

    @Basic
    @Column(name = "author_desc")
    public String getAuthorDesc() {
        return authorDesc;
    }

    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }

    @Basic
    @Column(name = "hot_book")
    public byte getHotBook() {
        return hotBook;
    }

    public void setHotBook(byte hotBook) {
        this.hotBook = hotBook;
    }

    @Basic
    @Column(name = "new_book")
    public byte getNewBook() {
        return newBook;
    }

    public void setNewBook(byte newBook) {
        this.newBook = newBook;
    }

    @Basic
    @Column(name = "scaveng_book")
    public byte getScavengBook() {
        return scavengBook;
    }

    public void setScavengBook(byte scavengBook) {
        this.scavengBook = scavengBook;
    }

    @Basic
    @Column(name = "found_book")
    public byte getFoundBook() {
        return foundBook;
    }

    public void setFoundBook(byte foundBook) {
        this.foundBook = foundBook;
    }

    @Basic
    @Column(name = "weekly_select")
    public byte getWeeklySelect() {
        return weeklySelect;
    }

    public void setWeeklySelect(byte weeklySelect) {
        this.weeklySelect = weeklySelect;
    }

    @Basic
    @Column(name = "gold")
    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Basic
    @Column(name = "cr_userid")
    public int getCrUserid() {
        return crUserid;
    }

    public void setCrUserid(int crUserid) {
        this.crUserid = crUserid;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "author_remark")
    public String getAuthorRemark() {
        return authorRemark;
    }

    public void setAuthorRemark(String authorRemark) {
        this.authorRemark = authorRemark;
    }

    @Basic
    @Column(name = "elite")
    public String getElite() {
        return elite;
    }

    public void setElite(String elite) {
        this.elite = elite;
    }

    @Basic
    @Column(name = "issue_time")
    public long getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }

    @Basic
    @Column(name = "issue")
    public byte getIssue() {
        return issue;
    }

    public void setIssue(byte issue) {
        this.issue = issue;
    }

    @Basic
    @Column(name = "thematic_area")
    public byte getThematicArea() {
        return thematicArea;
    }

    public void setThematicArea(byte thematicArea) {
        this.thematicArea = thematicArea;
    }

    @Basic
    @Column(name = "update_time")
    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "update_chapter")
    public byte getUpdateChapter() {
        return updateChapter;
    }

    public void setUpdateChapter(byte updateChapter) {
        this.updateChapter = updateChapter;
    }

    @Basic
    @Column(name = "original_book_id")
    public String getOriginalBookId() {
        return originalBookId;
    }

    public void setOriginalBookId(String originalBookId) {
        this.originalBookId = originalBookId;
    }

    @Basic
    @Column(name = "book_source")
    public byte getBookSource() {
        return bookSource;
    }

    public void setBookSource(byte bookSource) {
        this.bookSource = bookSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HqStoryEntity that = (HqStoryEntity) o;
        return id == that.id &&
                author == that.author &&
                tstamp == that.tstamp &&
                finish == that.finish &&
                charge == that.charge &&
                chapterChargeNum == that.chapterChargeNum &&
                choice == that.choice &&
                hotBook == that.hotBook &&
                newBook == that.newBook &&
                scavengBook == that.scavengBook &&
                foundBook == that.foundBook &&
                weeklySelect == that.weeklySelect &&
                crUserid == that.crUserid &&
                issueTime == that.issueTime &&
                issue == that.issue &&
                thematicArea == that.thematicArea &&
                updateTime == that.updateTime &&
                updateChapter == that.updateChapter &&
                bookSource == that.bookSource &&
                Objects.equals(title, that.title) &&
                Objects.equals(crdate, that.crdate) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(hidden, that.hidden) &&
                Objects.equals(sorting, that.sorting) &&
                Objects.equals(image, that.image) &&
                Objects.equals(category, that.category) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(keywords, that.keywords) &&
                Objects.equals(storyAttr, that.storyAttr) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(storyStatus, that.storyStatus) &&
                Objects.equals(len, that.len) &&
                Objects.equals(readNum, that.readNum) &&
                Objects.equals(likes, that.likes) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(designer, that.designer) &&
                Objects.equals(updateRemind, that.updateRemind) &&
                Objects.equals(attention, that.attention) &&
                Objects.equals(vip, that.vip) &&
                Objects.equals(smallCategory, that.smallCategory) &&
                Objects.equals(authorDesc, that.authorDesc) &&
                Objects.equals(gold, that.gold) &&
                Objects.equals(content, that.content) &&
                Objects.equals(authorRemark, that.authorRemark) &&
                Objects.equals(elite, that.elite) &&
                Objects.equals(originalBookId, that.originalBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, crdate, deleted, hidden, sorting, image, category, remark, keywords, storyAttr, summary, author, storyStatus, len, readNum, likes, comment, editor, designer, updateRemind, attention, vip, tstamp, finish, charge, chapterChargeNum, choice, smallCategory, authorDesc, hotBook, newBook, scavengBook, foundBook, weeklySelect, gold, crUserid, content, authorRemark, elite, issueTime, issue, thematicArea, updateTime, updateChapter, originalBookId, bookSource);
    }
}
