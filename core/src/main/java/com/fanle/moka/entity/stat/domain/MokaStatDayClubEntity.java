package com.fanle.moka.entity.stat.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:15
 **/

@Entity
@Table(name = "moka_stat_day_club", schema = "wenxue_statistics", catalog = "")
public class MokaStatDayClubEntity {
    private long seqid;
    private String date;
    private String clubid;
    private String clubName;
    private String chairmanname;
    private String chairmanid;
    private int memberNum;
    private int newjoin;
    private int newuserjoin;
    private int loginNum;
    private int readNum;
    private int postuserNum;
    private int postNum;
    private int payuserNum;
    private int payNum;
    private int dynamicuserNum;
    private int dynamicNum;
    private int chairmanmoney;
    private String editTime;
    private String type;
    private String statTime;
    private int chairmanincome;
    private Long consumeBean;
    private Long readSec;
    private int newdeviceidjoin;
    private int newwebchatjoin;
    private int newqqjoin;
    private int newteljoin;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
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
    @Column(name = "clubid")
    public String getClubid() {
        return clubid;
    }

    public void setClubid(String clubid) {
        this.clubid = clubid;
    }

    @Basic
    @Column(name = "clubName")
    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    @Basic
    @Column(name = "chairmanname")
    public String getChairmanname() {
        return chairmanname;
    }

    public void setChairmanname(String chairmanname) {
        this.chairmanname = chairmanname;
    }

    @Basic
    @Column(name = "chairmanid")
    public String getChairmanid() {
        return chairmanid;
    }

    public void setChairmanid(String chairmanid) {
        this.chairmanid = chairmanid;
    }

    @Basic
    @Column(name = "memberNum")
    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    @Basic
    @Column(name = "newjoin")
    public int getNewjoin() {
        return newjoin;
    }

    public void setNewjoin(int newjoin) {
        this.newjoin = newjoin;
    }

    @Basic
    @Column(name = "newuserjoin")
    public int getNewuserjoin() {
        return newuserjoin;
    }

    public void setNewuserjoin(int newuserjoin) {
        this.newuserjoin = newuserjoin;
    }

    @Basic
    @Column(name = "loginNum")
    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
    }

    @Basic
    @Column(name = "readNum")
    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    @Basic
    @Column(name = "postuserNum")
    public int getPostuserNum() {
        return postuserNum;
    }

    public void setPostuserNum(int postuserNum) {
        this.postuserNum = postuserNum;
    }

    @Basic
    @Column(name = "postNum")
    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    @Basic
    @Column(name = "payuserNum")
    public int getPayuserNum() {
        return payuserNum;
    }

    public void setPayuserNum(int payuserNum) {
        this.payuserNum = payuserNum;
    }

    @Basic
    @Column(name = "payNum")
    public int getPayNum() {
        return payNum;
    }

    public void setPayNum(int payNum) {
        this.payNum = payNum;
    }

    @Basic
    @Column(name = "dynamicuserNum")
    public int getDynamicuserNum() {
        return dynamicuserNum;
    }

    public void setDynamicuserNum(int dynamicuserNum) {
        this.dynamicuserNum = dynamicuserNum;
    }

    @Basic
    @Column(name = "dynamicNum")
    public int getDynamicNum() {
        return dynamicNum;
    }

    public void setDynamicNum(int dynamicNum) {
        this.dynamicNum = dynamicNum;
    }

    @Basic
    @Column(name = "chairmanmoney")
    public int getChairmanmoney() {
        return chairmanmoney;
    }

    public void setChairmanmoney(int chairmanmoney) {
        this.chairmanmoney = chairmanmoney;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "statTime")
    public String getStatTime() {
        return statTime;
    }

    public void setStatTime(String statTime) {
        this.statTime = statTime;
    }

    @Basic
    @Column(name = "chairmanincome")
    public int getChairmanincome() {
        return chairmanincome;
    }

    public void setChairmanincome(int chairmanincome) {
        this.chairmanincome = chairmanincome;
    }

    @Basic
    @Column(name = "consumeBean")
    public Long getConsumeBean() {
        return consumeBean;
    }

    public void setConsumeBean(Long consumeBean) {
        this.consumeBean = consumeBean;
    }

    @Basic
    @Column(name = "readSec")
    public Long getReadSec() {
        return readSec;
    }

    public void setReadSec(Long readSec) {
        this.readSec = readSec;
    }

    @Basic
    @Column(name = "newdeviceidjoin")
    public int getNewdeviceidjoin() {
        return newdeviceidjoin;
    }

    public void setNewdeviceidjoin(int newdeviceidjoin) {
        this.newdeviceidjoin = newdeviceidjoin;
    }

    @Basic
    @Column(name = "newwebchatjoin")
    public int getNewwebchatjoin() {
        return newwebchatjoin;
    }

    public void setNewwebchatjoin(int newwebchatjoin) {
        this.newwebchatjoin = newwebchatjoin;
    }

    @Basic
    @Column(name = "newqqjoin")
    public int getNewqqjoin() {
        return newqqjoin;
    }

    public void setNewqqjoin(int newqqjoin) {
        this.newqqjoin = newqqjoin;
    }

    @Basic
    @Column(name = "newteljoin")
    public int getNewteljoin() {
        return newteljoin;
    }

    public void setNewteljoin(int newteljoin) {
        this.newteljoin = newteljoin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatDayClubEntity that = (MokaStatDayClubEntity) o;
        return seqid == that.seqid &&
                memberNum == that.memberNum &&
                newjoin == that.newjoin &&
                newuserjoin == that.newuserjoin &&
                loginNum == that.loginNum &&
                readNum == that.readNum &&
                postuserNum == that.postuserNum &&
                postNum == that.postNum &&
                payuserNum == that.payuserNum &&
                payNum == that.payNum &&
                dynamicuserNum == that.dynamicuserNum &&
                dynamicNum == that.dynamicNum &&
                chairmanmoney == that.chairmanmoney &&
                chairmanincome == that.chairmanincome &&
                newdeviceidjoin == that.newdeviceidjoin &&
                newwebchatjoin == that.newwebchatjoin &&
                newqqjoin == that.newqqjoin &&
                newteljoin == that.newteljoin &&
                Objects.equals(date, that.date) &&
                Objects.equals(clubid, that.clubid) &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(chairmanname, that.chairmanname) &&
                Objects.equals(chairmanid, that.chairmanid) &&
                Objects.equals(editTime, that.editTime) &&
                Objects.equals(type, that.type) &&
                Objects.equals(statTime, that.statTime) &&
                Objects.equals(consumeBean, that.consumeBean) &&
                Objects.equals(readSec, that.readSec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, date, clubid, clubName, chairmanname, chairmanid, memberNum, newjoin, newuserjoin, loginNum, readNum, postuserNum, postNum, payuserNum, payNum, dynamicuserNum, dynamicNum, chairmanmoney, editTime, type, statTime, chairmanincome, consumeBean, readSec, newdeviceidjoin, newwebchatjoin, newqqjoin, newteljoin);
    }
}
