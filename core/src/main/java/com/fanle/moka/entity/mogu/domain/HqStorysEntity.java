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
@Table(name = "hq_storys", schema = "mogu", catalog = "")
public class HqStorysEntity {
    private int storyId;
    private String content;
    private String title;
    private String keywords;
    private Integer len;
    private Integer readNum;
    private Integer comment;
    private Integer forward;
    private Integer crdate;
    private Byte hidden;
    private Byte deleted;
    private Integer tstamp;
    private String image;
    private String summary;
    private String editor;
    private int id;
    private String remark;
    private Byte chapterNum;
    private Integer likes;
    private String authorDesc;
    private byte status;
    private byte issue;
    private long issueTime;
    private int gold;
    private byte chapterSource;
    private String originalBookId;
    private String originalChapterId;

    @Basic
    @Column(name = "story_id")
    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "comment")
    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "forward")
    public Integer getForward() {
        return forward;
    }

    public void setForward(Integer forward) {
        this.forward = forward;
    }

    @Basic
    @Column(name = "crdate")
    public Integer getCrdate() {
        return crdate;
    }

    public void setCrdate(Integer crdate) {
        this.crdate = crdate;
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
    @Column(name = "deleted")
    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    @Basic
    @Column(name = "tstamp")
    public Integer getTstamp() {
        return tstamp;
    }

    public void setTstamp(Integer tstamp) {
        this.tstamp = tstamp;
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
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "editor")
    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "chapter_num")
    public Byte getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(Byte chapterNum) {
        this.chapterNum = chapterNum;
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
    @Column(name = "author_desc")
    public String getAuthorDesc() {
        return authorDesc;
    }

    public void setAuthorDesc(String authorDesc) {
        this.authorDesc = authorDesc;
    }

    @Basic
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
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
    @Column(name = "issue_time")
    public long getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }

    @Basic
    @Column(name = "gold")
    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Basic
    @Column(name = "chapter_source")
    public byte getChapterSource() {
        return chapterSource;
    }

    public void setChapterSource(byte chapterSource) {
        this.chapterSource = chapterSource;
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
    @Column(name = "original_chapter_id")
    public String getOriginalChapterId() {
        return originalChapterId;
    }

    public void setOriginalChapterId(String originalChapterId) {
        this.originalChapterId = originalChapterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HqStorysEntity that = (HqStorysEntity) o;
        return storyId == that.storyId &&
                id == that.id &&
                status == that.status &&
                issue == that.issue &&
                issueTime == that.issueTime &&
                gold == that.gold &&
                chapterSource == that.chapterSource &&
                Objects.equals(content, that.content) &&
                Objects.equals(title, that.title) &&
                Objects.equals(keywords, that.keywords) &&
                Objects.equals(len, that.len) &&
                Objects.equals(readNum, that.readNum) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(forward, that.forward) &&
                Objects.equals(crdate, that.crdate) &&
                Objects.equals(hidden, that.hidden) &&
                Objects.equals(deleted, that.deleted) &&
                Objects.equals(tstamp, that.tstamp) &&
                Objects.equals(image, that.image) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(editor, that.editor) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(chapterNum, that.chapterNum) &&
                Objects.equals(likes, that.likes) &&
                Objects.equals(authorDesc, that.authorDesc) &&
                Objects.equals(originalBookId, that.originalBookId) &&
                Objects.equals(originalChapterId, that.originalChapterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storyId, content, title, keywords, len, readNum, comment, forward, crdate, hidden, deleted, tstamp, image, summary, editor, id, remark, chapterNum, likes, authorDesc, status, issue, issueTime, gold, chapterSource, originalBookId, originalChapterId);
    }
}
