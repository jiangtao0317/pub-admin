package com.fanle.moka.entity.user.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:49
 **/

@Entity
@Table(name = "share_record", schema = "wenxue_user", catalog = "")
public class ShareRecordEntity {
    private Long seqid;
    private String shareRecodeId;
    private String shareid;
    private String userid;
    private String ext1;
    private String sharePlatform;
    private String date;
    private String title;
    private String content;
    private String logo;
    private String shareUrl;
    private String sPlatform;
    private String shareType;
    private String successflag;

    @Id
    @Column(name = "seqid")
    public Long getSeqid() {
        return seqid;
    }

    public void setSeqid(Long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "shareRecodeId")
    public String getShareRecodeId() {
        return shareRecodeId;
    }

    public void setShareRecodeId(String shareRecodeId) {
        this.shareRecodeId = shareRecodeId;
    }

    @Basic
    @Column(name = "shareid")
    public String getShareid() {
        return shareid;
    }

    public void setShareid(String shareid) {
        this.shareid = shareid;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "ext1")
    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    @Basic
    @Column(name = "sharePlatform")
    public String getSharePlatform() {
        return sharePlatform;
    }

    public void setSharePlatform(String sharePlatform) {
        this.sharePlatform = sharePlatform;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "shareUrl")
    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    @Basic
    @Column(name = "s_platform")
    public String getsPlatform() {
        return sPlatform;
    }

    public void setsPlatform(String sPlatform) {
        this.sPlatform = sPlatform;
    }

    @Basic
    @Column(name = "shareType")
    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    @Basic
    @Column(name = "successflag")
    public String getSuccessflag() {
        return successflag;
    }

    public void setSuccessflag(String successflag) {
        this.successflag = successflag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShareRecordEntity that = (ShareRecordEntity) o;
        return seqid == that.seqid &&
                Objects.equals(shareRecodeId, that.shareRecodeId) &&
                Objects.equals(shareid, that.shareid) &&
                Objects.equals(userid, that.userid) &&
                Objects.equals(ext1, that.ext1) &&
                Objects.equals(sharePlatform, that.sharePlatform) &&
                Objects.equals(date, that.date) &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(logo, that.logo) &&
                Objects.equals(shareUrl, that.shareUrl) &&
                Objects.equals(sPlatform, that.sPlatform) &&
                Objects.equals(shareType, that.shareType) &&
                Objects.equals(successflag, that.successflag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, shareRecodeId, shareid, userid, ext1, sharePlatform, date, title, content, logo, shareUrl, sPlatform, shareType, successflag);
    }
}
