package com.fanle.moka.entity.stat.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * @program: simple-application
 * @description:
 * @author: jiangtao
 * @create: 2019-04-22 19:14
 **/

@Entity
@Table(name = "moka_stat_day", schema = "wenxue_statistics", catalog = "")
public class MokaStatDayEntity {
    private long seqid;
    private int active;
    private int ageAreaExists;
    private int appStartKeepd1;
    private int appStartKeepd14;
    private int appStartKeepd2;
    private int appStartKeepd3;
    private int appStartKeepd30;
    private int appStartKeepd4;
    private int appStartKeepd5;
    private int appStartKeepd6;
    private int appStartKeepd7;
    private int appStartNew;
    private int appStartPv;
    private int appStartUv;
    private int appStartUvAll;
    private int arpu;
    private int barrage;
    private int book2ImgShared;
    private int book2ImgSharedSuccess;
    private int bookBorrow;
    private int bookBorrowShared;
    private int bookBorrowSharedSuccess;
    private int bookDesk;
    private int bookDeskShared;
    private int bookDeskSharedSuccess;
    private int bookDeskUserUv;
    private int bookReader;
    private int bookReaderComment;
    private int bookShared;
    private int bookSharedSuccess;
    private String cid;
    private int club;
    private int clubNew;
    private String cname;
    private int d30ActiveUv;
    private int d30LoginUv;
    private int d30Reg;
    private int d7ActiveUv;
    private int d7LoginUv;
    private int d7Reg;
    private String date;
    private int drawcashMoney;
    private int drawcashUser;
    private int dynamic;
    private int dynamicComment;
    private int dynamicFri;
    private int dynamicFriComment;
    private int dynamicFriShared;
    private int dynamicFriSharedSuccess;
    private int dynamicNormal;
    private int dynamicNormalComment;
    private int dynamicShared;
    private int dynamicSharedSuccess;
    private int firstPayUser;
    private int login;
    private int loginKeepd1;
    private int loginKeepd14;
    private int loginKeepd2;
    private int loginKeepd3;
    private int loginKeepd30;
    private int loginKeepd4;
    private int loginKeepd5;
    private int loginKeepd6;
    private int loginKeepd7;
    private long onlineSec;
    private int payMoney;
    private int payUser;
    private int pcInstall;
    private int pcUninstall;
    private String platform;
    private int praise;
    private int praiseComment;
    private int praiseDynamicFri;
    private int praiseDynamicNormal;
    private int praiseTalk;
    private int readBookPv;
    private long readSec;
    private int readUserUv;
    private int refreshDynamic;
    private int refreshDynamicBookDesk;
    private int reg;
    private int regAll;
    private int regGuest;
    private int regQq;
    private int regTel;
    private int regWebchat;
    private int regWeibo;
    private int shareDynamicOther;
    private int shareDynamicOtherSuccess;
    private int shareDynamicSelf;
    private int shareDynamicSelfSuccess;
    private int shareQq;
    private int shareQqSuccess;
    private int shareQqzone;
    private int shareQqzoneSuccess;
    private int shareWebchat;
    private int shareWebchatFri;
    private int shareWebchatFriSuccess;
    private int shareWebchatSuccess;
    private int shareWebo;
    private int shareWeboSuccess;
    private int tagsExists;
    private int uaBookActivityPv;
    private int uaBookActivityUv;
    private int uaBookEndPv;
    private int uaBookEndUv;
    private int uaBookNewestPv;
    private int uaBookNewestUv;
    private int uaDeskPv;
    private int uaDeskUv;
    private int uaDynamicPv;
    private int uaDynamicUv;
    private int uaRankPv;
    private int uaRankUv;
    private int uaReadmatUv;
    private int uaReadmatePv;
    private String version;
    private int pcInstallUv;
    private int pcUninstallUv;
    private int readPagePv;
    private int readPageUv;
    private int loginGuest;
    private int readUserGuestUv;
    private int readUserAppStartNewUv;
    private int sharePv;
    private int shareUv;
    private int loginAppStartPv;
    private int bookUv;
    private int shareAllPv;
    private int shareAllUv;
    private int shareActive;
    private int shareAppPv;
    private int shareAppUv;
    private int shareAppSuccessPv;
    private int shareAppSuccessUv;

    @Id
    @Column(name = "seqid")
    public long getSeqid() {
        return seqid;
    }

    public void setSeqid(long seqid) {
        this.seqid = seqid;
    }

    @Basic
    @Column(name = "active")
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Basic
    @Column(name = "ageAreaExists")
    public int getAgeAreaExists() {
        return ageAreaExists;
    }

    public void setAgeAreaExists(int ageAreaExists) {
        this.ageAreaExists = ageAreaExists;
    }

    @Basic
    @Column(name = "appStartKeepd1")
    public int getAppStartKeepd1() {
        return appStartKeepd1;
    }

    public void setAppStartKeepd1(int appStartKeepd1) {
        this.appStartKeepd1 = appStartKeepd1;
    }

    @Basic
    @Column(name = "appStartKeepd14")
    public int getAppStartKeepd14() {
        return appStartKeepd14;
    }

    public void setAppStartKeepd14(int appStartKeepd14) {
        this.appStartKeepd14 = appStartKeepd14;
    }

    @Basic
    @Column(name = "appStartKeepd2")
    public int getAppStartKeepd2() {
        return appStartKeepd2;
    }

    public void setAppStartKeepd2(int appStartKeepd2) {
        this.appStartKeepd2 = appStartKeepd2;
    }

    @Basic
    @Column(name = "appStartKeepd3")
    public int getAppStartKeepd3() {
        return appStartKeepd3;
    }

    public void setAppStartKeepd3(int appStartKeepd3) {
        this.appStartKeepd3 = appStartKeepd3;
    }

    @Basic
    @Column(name = "appStartKeepd30")
    public int getAppStartKeepd30() {
        return appStartKeepd30;
    }

    public void setAppStartKeepd30(int appStartKeepd30) {
        this.appStartKeepd30 = appStartKeepd30;
    }

    @Basic
    @Column(name = "appStartKeepd4")
    public int getAppStartKeepd4() {
        return appStartKeepd4;
    }

    public void setAppStartKeepd4(int appStartKeepd4) {
        this.appStartKeepd4 = appStartKeepd4;
    }

    @Basic
    @Column(name = "appStartKeepd5")
    public int getAppStartKeepd5() {
        return appStartKeepd5;
    }

    public void setAppStartKeepd5(int appStartKeepd5) {
        this.appStartKeepd5 = appStartKeepd5;
    }

    @Basic
    @Column(name = "appStartKeepd6")
    public int getAppStartKeepd6() {
        return appStartKeepd6;
    }

    public void setAppStartKeepd6(int appStartKeepd6) {
        this.appStartKeepd6 = appStartKeepd6;
    }

    @Basic
    @Column(name = "appStartKeepd7")
    public int getAppStartKeepd7() {
        return appStartKeepd7;
    }

    public void setAppStartKeepd7(int appStartKeepd7) {
        this.appStartKeepd7 = appStartKeepd7;
    }

    @Basic
    @Column(name = "appStartNew")
    public int getAppStartNew() {
        return appStartNew;
    }

    public void setAppStartNew(int appStartNew) {
        this.appStartNew = appStartNew;
    }

    @Basic
    @Column(name = "appStartPv")
    public int getAppStartPv() {
        return appStartPv;
    }

    public void setAppStartPv(int appStartPv) {
        this.appStartPv = appStartPv;
    }

    @Basic
    @Column(name = "appStartUv")
    public int getAppStartUv() {
        return appStartUv;
    }

    public void setAppStartUv(int appStartUv) {
        this.appStartUv = appStartUv;
    }

    @Basic
    @Column(name = "appStartUvAll")
    public int getAppStartUvAll() {
        return appStartUvAll;
    }

    public void setAppStartUvAll(int appStartUvAll) {
        this.appStartUvAll = appStartUvAll;
    }

    @Basic
    @Column(name = "arpu")
    public int getArpu() {
        return arpu;
    }

    public void setArpu(int arpu) {
        this.arpu = arpu;
    }

    @Basic
    @Column(name = "barrage")
    public int getBarrage() {
        return barrage;
    }

    public void setBarrage(int barrage) {
        this.barrage = barrage;
    }

    @Basic
    @Column(name = "book2ImgShared")
    public int getBook2ImgShared() {
        return book2ImgShared;
    }

    public void setBook2ImgShared(int book2ImgShared) {
        this.book2ImgShared = book2ImgShared;
    }

    @Basic
    @Column(name = "book2ImgSharedSuccess")
    public int getBook2ImgSharedSuccess() {
        return book2ImgSharedSuccess;
    }

    public void setBook2ImgSharedSuccess(int book2ImgSharedSuccess) {
        this.book2ImgSharedSuccess = book2ImgSharedSuccess;
    }

    @Basic
    @Column(name = "bookBorrow")
    public int getBookBorrow() {
        return bookBorrow;
    }

    public void setBookBorrow(int bookBorrow) {
        this.bookBorrow = bookBorrow;
    }

    @Basic
    @Column(name = "bookBorrowShared")
    public int getBookBorrowShared() {
        return bookBorrowShared;
    }

    public void setBookBorrowShared(int bookBorrowShared) {
        this.bookBorrowShared = bookBorrowShared;
    }

    @Basic
    @Column(name = "bookBorrowSharedSuccess")
    public int getBookBorrowSharedSuccess() {
        return bookBorrowSharedSuccess;
    }

    public void setBookBorrowSharedSuccess(int bookBorrowSharedSuccess) {
        this.bookBorrowSharedSuccess = bookBorrowSharedSuccess;
    }

    @Basic
    @Column(name = "bookDesk")
    public int getBookDesk() {
        return bookDesk;
    }

    public void setBookDesk(int bookDesk) {
        this.bookDesk = bookDesk;
    }

    @Basic
    @Column(name = "bookDeskShared")
    public int getBookDeskShared() {
        return bookDeskShared;
    }

    public void setBookDeskShared(int bookDeskShared) {
        this.bookDeskShared = bookDeskShared;
    }

    @Basic
    @Column(name = "bookDeskSharedSuccess")
    public int getBookDeskSharedSuccess() {
        return bookDeskSharedSuccess;
    }

    public void setBookDeskSharedSuccess(int bookDeskSharedSuccess) {
        this.bookDeskSharedSuccess = bookDeskSharedSuccess;
    }

    @Basic
    @Column(name = "bookDeskUserUv")
    public int getBookDeskUserUv() {
        return bookDeskUserUv;
    }

    public void setBookDeskUserUv(int bookDeskUserUv) {
        this.bookDeskUserUv = bookDeskUserUv;
    }

    @Basic
    @Column(name = "bookReader")
    public int getBookReader() {
        return bookReader;
    }

    public void setBookReader(int bookReader) {
        this.bookReader = bookReader;
    }

    @Basic
    @Column(name = "bookReaderComment")
    public int getBookReaderComment() {
        return bookReaderComment;
    }

    public void setBookReaderComment(int bookReaderComment) {
        this.bookReaderComment = bookReaderComment;
    }

    @Basic
    @Column(name = "bookShared")
    public int getBookShared() {
        return bookShared;
    }

    public void setBookShared(int bookShared) {
        this.bookShared = bookShared;
    }

    @Basic
    @Column(name = "bookSharedSuccess")
    public int getBookSharedSuccess() {
        return bookSharedSuccess;
    }

    public void setBookSharedSuccess(int bookSharedSuccess) {
        this.bookSharedSuccess = bookSharedSuccess;
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
    @Column(name = "club")
    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Basic
    @Column(name = "clubNew")
    public int getClubNew() {
        return clubNew;
    }

    public void setClubNew(int clubNew) {
        this.clubNew = clubNew;
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
    @Column(name = "d30ActiveUv")
    public int getD30ActiveUv() {
        return d30ActiveUv;
    }

    public void setD30ActiveUv(int d30ActiveUv) {
        this.d30ActiveUv = d30ActiveUv;
    }

    @Basic
    @Column(name = "d30LoginUv")
    public int getD30LoginUv() {
        return d30LoginUv;
    }

    public void setD30LoginUv(int d30LoginUv) {
        this.d30LoginUv = d30LoginUv;
    }

    @Basic
    @Column(name = "d30Reg")
    public int getD30Reg() {
        return d30Reg;
    }

    public void setD30Reg(int d30Reg) {
        this.d30Reg = d30Reg;
    }

    @Basic
    @Column(name = "d7ActiveUv")
    public int getD7ActiveUv() {
        return d7ActiveUv;
    }

    public void setD7ActiveUv(int d7ActiveUv) {
        this.d7ActiveUv = d7ActiveUv;
    }

    @Basic
    @Column(name = "d7LoginUv")
    public int getD7LoginUv() {
        return d7LoginUv;
    }

    public void setD7LoginUv(int d7LoginUv) {
        this.d7LoginUv = d7LoginUv;
    }

    @Basic
    @Column(name = "d7Reg")
    public int getD7Reg() {
        return d7Reg;
    }

    public void setD7Reg(int d7Reg) {
        this.d7Reg = d7Reg;
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
    @Column(name = "drawcashMoney")
    public int getDrawcashMoney() {
        return drawcashMoney;
    }

    public void setDrawcashMoney(int drawcashMoney) {
        this.drawcashMoney = drawcashMoney;
    }

    @Basic
    @Column(name = "drawcashUser")
    public int getDrawcashUser() {
        return drawcashUser;
    }

    public void setDrawcashUser(int drawcashUser) {
        this.drawcashUser = drawcashUser;
    }

    @Basic
    @Column(name = "dynamic")
    public int getDynamic() {
        return dynamic;
    }

    public void setDynamic(int dynamic) {
        this.dynamic = dynamic;
    }

    @Basic
    @Column(name = "dynamicComment")
    public int getDynamicComment() {
        return dynamicComment;
    }

    public void setDynamicComment(int dynamicComment) {
        this.dynamicComment = dynamicComment;
    }

    @Basic
    @Column(name = "dynamicFri")
    public int getDynamicFri() {
        return dynamicFri;
    }

    public void setDynamicFri(int dynamicFri) {
        this.dynamicFri = dynamicFri;
    }

    @Basic
    @Column(name = "dynamicFriComment")
    public int getDynamicFriComment() {
        return dynamicFriComment;
    }

    public void setDynamicFriComment(int dynamicFriComment) {
        this.dynamicFriComment = dynamicFriComment;
    }

    @Basic
    @Column(name = "dynamicFriShared")
    public int getDynamicFriShared() {
        return dynamicFriShared;
    }

    public void setDynamicFriShared(int dynamicFriShared) {
        this.dynamicFriShared = dynamicFriShared;
    }

    @Basic
    @Column(name = "dynamicFriSharedSuccess")
    public int getDynamicFriSharedSuccess() {
        return dynamicFriSharedSuccess;
    }

    public void setDynamicFriSharedSuccess(int dynamicFriSharedSuccess) {
        this.dynamicFriSharedSuccess = dynamicFriSharedSuccess;
    }

    @Basic
    @Column(name = "dynamicNormal")
    public int getDynamicNormal() {
        return dynamicNormal;
    }

    public void setDynamicNormal(int dynamicNormal) {
        this.dynamicNormal = dynamicNormal;
    }

    @Basic
    @Column(name = "dynamicNormalComment")
    public int getDynamicNormalComment() {
        return dynamicNormalComment;
    }

    public void setDynamicNormalComment(int dynamicNormalComment) {
        this.dynamicNormalComment = dynamicNormalComment;
    }

    @Basic
    @Column(name = "dynamicShared")
    public int getDynamicShared() {
        return dynamicShared;
    }

    public void setDynamicShared(int dynamicShared) {
        this.dynamicShared = dynamicShared;
    }

    @Basic
    @Column(name = "dynamicSharedSuccess")
    public int getDynamicSharedSuccess() {
        return dynamicSharedSuccess;
    }

    public void setDynamicSharedSuccess(int dynamicSharedSuccess) {
        this.dynamicSharedSuccess = dynamicSharedSuccess;
    }

    @Basic
    @Column(name = "firstPayUser")
    public int getFirstPayUser() {
        return firstPayUser;
    }

    public void setFirstPayUser(int firstPayUser) {
        this.firstPayUser = firstPayUser;
    }

    @Basic
    @Column(name = "login")
    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    @Basic
    @Column(name = "loginKeepd1")
    public int getLoginKeepd1() {
        return loginKeepd1;
    }

    public void setLoginKeepd1(int loginKeepd1) {
        this.loginKeepd1 = loginKeepd1;
    }

    @Basic
    @Column(name = "loginKeepd14")
    public int getLoginKeepd14() {
        return loginKeepd14;
    }

    public void setLoginKeepd14(int loginKeepd14) {
        this.loginKeepd14 = loginKeepd14;
    }

    @Basic
    @Column(name = "loginKeepd2")
    public int getLoginKeepd2() {
        return loginKeepd2;
    }

    public void setLoginKeepd2(int loginKeepd2) {
        this.loginKeepd2 = loginKeepd2;
    }

    @Basic
    @Column(name = "loginKeepd3")
    public int getLoginKeepd3() {
        return loginKeepd3;
    }

    public void setLoginKeepd3(int loginKeepd3) {
        this.loginKeepd3 = loginKeepd3;
    }

    @Basic
    @Column(name = "loginKeepd30")
    public int getLoginKeepd30() {
        return loginKeepd30;
    }

    public void setLoginKeepd30(int loginKeepd30) {
        this.loginKeepd30 = loginKeepd30;
    }

    @Basic
    @Column(name = "loginKeepd4")
    public int getLoginKeepd4() {
        return loginKeepd4;
    }

    public void setLoginKeepd4(int loginKeepd4) {
        this.loginKeepd4 = loginKeepd4;
    }

    @Basic
    @Column(name = "loginKeepd5")
    public int getLoginKeepd5() {
        return loginKeepd5;
    }

    public void setLoginKeepd5(int loginKeepd5) {
        this.loginKeepd5 = loginKeepd5;
    }

    @Basic
    @Column(name = "loginKeepd6")
    public int getLoginKeepd6() {
        return loginKeepd6;
    }

    public void setLoginKeepd6(int loginKeepd6) {
        this.loginKeepd6 = loginKeepd6;
    }

    @Basic
    @Column(name = "loginKeepd7")
    public int getLoginKeepd7() {
        return loginKeepd7;
    }

    public void setLoginKeepd7(int loginKeepd7) {
        this.loginKeepd7 = loginKeepd7;
    }

    @Basic
    @Column(name = "onlineSec")
    public long getOnlineSec() {
        return onlineSec;
    }

    public void setOnlineSec(long onlineSec) {
        this.onlineSec = onlineSec;
    }

    @Basic
    @Column(name = "payMoney")
    public int getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    @Basic
    @Column(name = "payUser")
    public int getPayUser() {
        return payUser;
    }

    public void setPayUser(int payUser) {
        this.payUser = payUser;
    }

    @Basic
    @Column(name = "pcInstall")
    public int getPcInstall() {
        return pcInstall;
    }

    public void setPcInstall(int pcInstall) {
        this.pcInstall = pcInstall;
    }

    @Basic
    @Column(name = "pcUninstall")
    public int getPcUninstall() {
        return pcUninstall;
    }

    public void setPcUninstall(int pcUninstall) {
        this.pcUninstall = pcUninstall;
    }

    @Basic
    @Column(name = "platform")
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Basic
    @Column(name = "praise")
    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    @Basic
    @Column(name = "praiseComment")
    public int getPraiseComment() {
        return praiseComment;
    }

    public void setPraiseComment(int praiseComment) {
        this.praiseComment = praiseComment;
    }

    @Basic
    @Column(name = "praiseDynamicFri")
    public int getPraiseDynamicFri() {
        return praiseDynamicFri;
    }

    public void setPraiseDynamicFri(int praiseDynamicFri) {
        this.praiseDynamicFri = praiseDynamicFri;
    }

    @Basic
    @Column(name = "praiseDynamicNormal")
    public int getPraiseDynamicNormal() {
        return praiseDynamicNormal;
    }

    public void setPraiseDynamicNormal(int praiseDynamicNormal) {
        this.praiseDynamicNormal = praiseDynamicNormal;
    }

    @Basic
    @Column(name = "praiseTalk")
    public int getPraiseTalk() {
        return praiseTalk;
    }

    public void setPraiseTalk(int praiseTalk) {
        this.praiseTalk = praiseTalk;
    }

    @Basic
    @Column(name = "readBookPv")
    public int getReadBookPv() {
        return readBookPv;
    }

    public void setReadBookPv(int readBookPv) {
        this.readBookPv = readBookPv;
    }

    @Basic
    @Column(name = "readSec")
    public long getReadSec() {
        return readSec;
    }

    public void setReadSec(long readSec) {
        this.readSec = readSec;
    }

    @Basic
    @Column(name = "readUserUv")
    public int getReadUserUv() {
        return readUserUv;
    }

    public void setReadUserUv(int readUserUv) {
        this.readUserUv = readUserUv;
    }

    @Basic
    @Column(name = "refreshDynamic")
    public int getRefreshDynamic() {
        return refreshDynamic;
    }

    public void setRefreshDynamic(int refreshDynamic) {
        this.refreshDynamic = refreshDynamic;
    }

    @Basic
    @Column(name = "refreshDynamicBookDesk")
    public int getRefreshDynamicBookDesk() {
        return refreshDynamicBookDesk;
    }

    public void setRefreshDynamicBookDesk(int refreshDynamicBookDesk) {
        this.refreshDynamicBookDesk = refreshDynamicBookDesk;
    }

    @Basic
    @Column(name = "reg")
    public int getReg() {
        return reg;
    }

    public void setReg(int reg) {
        this.reg = reg;
    }

    @Basic
    @Column(name = "regAll")
    public int getRegAll() {
        return regAll;
    }

    public void setRegAll(int regAll) {
        this.regAll = regAll;
    }

    @Basic
    @Column(name = "regGuest")
    public int getRegGuest() {
        return regGuest;
    }

    public void setRegGuest(int regGuest) {
        this.regGuest = regGuest;
    }

    @Basic
    @Column(name = "regQQ")
    public int getRegQq() {
        return regQq;
    }

    public void setRegQq(int regQq) {
        this.regQq = regQq;
    }

    @Basic
    @Column(name = "regTel")
    public int getRegTel() {
        return regTel;
    }

    public void setRegTel(int regTel) {
        this.regTel = regTel;
    }

    @Basic
    @Column(name = "regWebchat")
    public int getRegWebchat() {
        return regWebchat;
    }

    public void setRegWebchat(int regWebchat) {
        this.regWebchat = regWebchat;
    }

    @Basic
    @Column(name = "regWeibo")
    public int getRegWeibo() {
        return regWeibo;
    }

    public void setRegWeibo(int regWeibo) {
        this.regWeibo = regWeibo;
    }

    @Basic
    @Column(name = "shareDynamicOther")
    public int getShareDynamicOther() {
        return shareDynamicOther;
    }

    public void setShareDynamicOther(int shareDynamicOther) {
        this.shareDynamicOther = shareDynamicOther;
    }

    @Basic
    @Column(name = "shareDynamicOtherSuccess")
    public int getShareDynamicOtherSuccess() {
        return shareDynamicOtherSuccess;
    }

    public void setShareDynamicOtherSuccess(int shareDynamicOtherSuccess) {
        this.shareDynamicOtherSuccess = shareDynamicOtherSuccess;
    }

    @Basic
    @Column(name = "shareDynamicSelf")
    public int getShareDynamicSelf() {
        return shareDynamicSelf;
    }

    public void setShareDynamicSelf(int shareDynamicSelf) {
        this.shareDynamicSelf = shareDynamicSelf;
    }

    @Basic
    @Column(name = "shareDynamicSelfSuccess")
    public int getShareDynamicSelfSuccess() {
        return shareDynamicSelfSuccess;
    }

    public void setShareDynamicSelfSuccess(int shareDynamicSelfSuccess) {
        this.shareDynamicSelfSuccess = shareDynamicSelfSuccess;
    }

    @Basic
    @Column(name = "shareQq")
    public int getShareQq() {
        return shareQq;
    }

    public void setShareQq(int shareQq) {
        this.shareQq = shareQq;
    }

    @Basic
    @Column(name = "shareQqSuccess")
    public int getShareQqSuccess() {
        return shareQqSuccess;
    }

    public void setShareQqSuccess(int shareQqSuccess) {
        this.shareQqSuccess = shareQqSuccess;
    }

    @Basic
    @Column(name = "shareQqzone")
    public int getShareQqzone() {
        return shareQqzone;
    }

    public void setShareQqzone(int shareQqzone) {
        this.shareQqzone = shareQqzone;
    }

    @Basic
    @Column(name = "shareQqzoneSuccess")
    public int getShareQqzoneSuccess() {
        return shareQqzoneSuccess;
    }

    public void setShareQqzoneSuccess(int shareQqzoneSuccess) {
        this.shareQqzoneSuccess = shareQqzoneSuccess;
    }

    @Basic
    @Column(name = "shareWebchat")
    public int getShareWebchat() {
        return shareWebchat;
    }

    public void setShareWebchat(int shareWebchat) {
        this.shareWebchat = shareWebchat;
    }

    @Basic
    @Column(name = "shareWebchatFri")
    public int getShareWebchatFri() {
        return shareWebchatFri;
    }

    public void setShareWebchatFri(int shareWebchatFri) {
        this.shareWebchatFri = shareWebchatFri;
    }

    @Basic
    @Column(name = "shareWebchatFriSuccess")
    public int getShareWebchatFriSuccess() {
        return shareWebchatFriSuccess;
    }

    public void setShareWebchatFriSuccess(int shareWebchatFriSuccess) {
        this.shareWebchatFriSuccess = shareWebchatFriSuccess;
    }

    @Basic
    @Column(name = "shareWebchatSuccess")
    public int getShareWebchatSuccess() {
        return shareWebchatSuccess;
    }

    public void setShareWebchatSuccess(int shareWebchatSuccess) {
        this.shareWebchatSuccess = shareWebchatSuccess;
    }

    @Basic
    @Column(name = "shareWebo")
    public int getShareWebo() {
        return shareWebo;
    }

    public void setShareWebo(int shareWebo) {
        this.shareWebo = shareWebo;
    }

    @Basic
    @Column(name = "shareWeboSuccess")
    public int getShareWeboSuccess() {
        return shareWeboSuccess;
    }

    public void setShareWeboSuccess(int shareWeboSuccess) {
        this.shareWeboSuccess = shareWeboSuccess;
    }

    @Basic
    @Column(name = "tagsExists")
    public int getTagsExists() {
        return tagsExists;
    }

    public void setTagsExists(int tagsExists) {
        this.tagsExists = tagsExists;
    }

    @Basic
    @Column(name = "uaBookActivityPv")
    public int getUaBookActivityPv() {
        return uaBookActivityPv;
    }

    public void setUaBookActivityPv(int uaBookActivityPv) {
        this.uaBookActivityPv = uaBookActivityPv;
    }

    @Basic
    @Column(name = "uaBookActivityUv")
    public int getUaBookActivityUv() {
        return uaBookActivityUv;
    }

    public void setUaBookActivityUv(int uaBookActivityUv) {
        this.uaBookActivityUv = uaBookActivityUv;
    }

    @Basic
    @Column(name = "uaBookEndPv")
    public int getUaBookEndPv() {
        return uaBookEndPv;
    }

    public void setUaBookEndPv(int uaBookEndPv) {
        this.uaBookEndPv = uaBookEndPv;
    }

    @Basic
    @Column(name = "uaBookEndUv")
    public int getUaBookEndUv() {
        return uaBookEndUv;
    }

    public void setUaBookEndUv(int uaBookEndUv) {
        this.uaBookEndUv = uaBookEndUv;
    }

    @Basic
    @Column(name = "uaBookNewestPv")
    public int getUaBookNewestPv() {
        return uaBookNewestPv;
    }

    public void setUaBookNewestPv(int uaBookNewestPv) {
        this.uaBookNewestPv = uaBookNewestPv;
    }

    @Basic
    @Column(name = "uaBookNewestUv")
    public int getUaBookNewestUv() {
        return uaBookNewestUv;
    }

    public void setUaBookNewestUv(int uaBookNewestUv) {
        this.uaBookNewestUv = uaBookNewestUv;
    }

    @Basic
    @Column(name = "uaDeskPv")
    public int getUaDeskPv() {
        return uaDeskPv;
    }

    public void setUaDeskPv(int uaDeskPv) {
        this.uaDeskPv = uaDeskPv;
    }

    @Basic
    @Column(name = "uaDeskUv")
    public int getUaDeskUv() {
        return uaDeskUv;
    }

    public void setUaDeskUv(int uaDeskUv) {
        this.uaDeskUv = uaDeskUv;
    }

    @Basic
    @Column(name = "uaDynamicPv")
    public int getUaDynamicPv() {
        return uaDynamicPv;
    }

    public void setUaDynamicPv(int uaDynamicPv) {
        this.uaDynamicPv = uaDynamicPv;
    }

    @Basic
    @Column(name = "uaDynamicUv")
    public int getUaDynamicUv() {
        return uaDynamicUv;
    }

    public void setUaDynamicUv(int uaDynamicUv) {
        this.uaDynamicUv = uaDynamicUv;
    }

    @Basic
    @Column(name = "uaRankPv")
    public int getUaRankPv() {
        return uaRankPv;
    }

    public void setUaRankPv(int uaRankPv) {
        this.uaRankPv = uaRankPv;
    }

    @Basic
    @Column(name = "uaRankUv")
    public int getUaRankUv() {
        return uaRankUv;
    }

    public void setUaRankUv(int uaRankUv) {
        this.uaRankUv = uaRankUv;
    }

    @Basic
    @Column(name = "uaReadmatUv")
    public int getUaReadmatUv() {
        return uaReadmatUv;
    }

    public void setUaReadmatUv(int uaReadmatUv) {
        this.uaReadmatUv = uaReadmatUv;
    }

    @Basic
    @Column(name = "uaReadmatePv")
    public int getUaReadmatePv() {
        return uaReadmatePv;
    }

    public void setUaReadmatePv(int uaReadmatePv) {
        this.uaReadmatePv = uaReadmatePv;
    }

    @Basic
    @Column(name = "version")
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Basic
    @Column(name = "pcInstallUv")
    public int getPcInstallUv() {
        return pcInstallUv;
    }

    public void setPcInstallUv(int pcInstallUv) {
        this.pcInstallUv = pcInstallUv;
    }

    @Basic
    @Column(name = "pcUninstallUv")
    public int getPcUninstallUv() {
        return pcUninstallUv;
    }

    public void setPcUninstallUv(int pcUninstallUv) {
        this.pcUninstallUv = pcUninstallUv;
    }

    @Basic
    @Column(name = "readPagePv")
    public int getReadPagePv() {
        return readPagePv;
    }

    public void setReadPagePv(int readPagePv) {
        this.readPagePv = readPagePv;
    }

    @Basic
    @Column(name = "readPageUv")
    public int getReadPageUv() {
        return readPageUv;
    }

    public void setReadPageUv(int readPageUv) {
        this.readPageUv = readPageUv;
    }

    @Basic
    @Column(name = "loginGuest")
    public int getLoginGuest() {
        return loginGuest;
    }

    public void setLoginGuest(int loginGuest) {
        this.loginGuest = loginGuest;
    }

    @Basic
    @Column(name = "readUserGuestUv")
    public int getReadUserGuestUv() {
        return readUserGuestUv;
    }

    public void setReadUserGuestUv(int readUserGuestUv) {
        this.readUserGuestUv = readUserGuestUv;
    }

    @Basic
    @Column(name = "readUserAppStartNewUv")
    public int getReadUserAppStartNewUv() {
        return readUserAppStartNewUv;
    }

    public void setReadUserAppStartNewUv(int readUserAppStartNewUv) {
        this.readUserAppStartNewUv = readUserAppStartNewUv;
    }

    @Basic
    @Column(name = "sharePv")
    public int getSharePv() {
        return sharePv;
    }

    public void setSharePv(int sharePv) {
        this.sharePv = sharePv;
    }

    @Basic
    @Column(name = "shareUv")
    public int getShareUv() {
        return shareUv;
    }

    public void setShareUv(int shareUv) {
        this.shareUv = shareUv;
    }

    @Basic
    @Column(name = "loginAppStartPv")
    public int getLoginAppStartPv() {
        return loginAppStartPv;
    }

    public void setLoginAppStartPv(int loginAppStartPv) {
        this.loginAppStartPv = loginAppStartPv;
    }

    @Basic
    @Column(name = "bookUv")
    public int getBookUv() {
        return bookUv;
    }

    public void setBookUv(int bookUv) {
        this.bookUv = bookUv;
    }

    @Basic
    @Column(name = "shareAllPv")
    public int getShareAllPv() {
        return shareAllPv;
    }

    public void setShareAllPv(int shareAllPv) {
        this.shareAllPv = shareAllPv;
    }

    @Basic
    @Column(name = "shareAllUv")
    public int getShareAllUv() {
        return shareAllUv;
    }

    public void setShareAllUv(int shareAllUv) {
        this.shareAllUv = shareAllUv;
    }

    @Basic
    @Column(name = "shareActive")
    public int getShareActive() {
        return shareActive;
    }

    public void setShareActive(int shareActive) {
        this.shareActive = shareActive;
    }

    @Basic
    @Column(name = "shareAppPv")
    public int getShareAppPv() {
        return shareAppPv;
    }

    public void setShareAppPv(int shareAppPv) {
        this.shareAppPv = shareAppPv;
    }

    @Basic
    @Column(name = "shareAppUv")
    public int getShareAppUv() {
        return shareAppUv;
    }

    public void setShareAppUv(int shareAppUv) {
        this.shareAppUv = shareAppUv;
    }

    @Basic
    @Column(name = "shareAppSuccessPv")
    public int getShareAppSuccessPv() {
        return shareAppSuccessPv;
    }

    public void setShareAppSuccessPv(int shareAppSuccessPv) {
        this.shareAppSuccessPv = shareAppSuccessPv;
    }

    @Basic
    @Column(name = "shareAppSuccessUv")
    public int getShareAppSuccessUv() {
        return shareAppSuccessUv;
    }

    public void setShareAppSuccessUv(int shareAppSuccessUv) {
        this.shareAppSuccessUv = shareAppSuccessUv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MokaStatDayEntity that = (MokaStatDayEntity) o;
        return seqid == that.seqid &&
                active == that.active &&
                ageAreaExists == that.ageAreaExists &&
                appStartKeepd1 == that.appStartKeepd1 &&
                appStartKeepd14 == that.appStartKeepd14 &&
                appStartKeepd2 == that.appStartKeepd2 &&
                appStartKeepd3 == that.appStartKeepd3 &&
                appStartKeepd30 == that.appStartKeepd30 &&
                appStartKeepd4 == that.appStartKeepd4 &&
                appStartKeepd5 == that.appStartKeepd5 &&
                appStartKeepd6 == that.appStartKeepd6 &&
                appStartKeepd7 == that.appStartKeepd7 &&
                appStartNew == that.appStartNew &&
                appStartPv == that.appStartPv &&
                appStartUv == that.appStartUv &&
                appStartUvAll == that.appStartUvAll &&
                arpu == that.arpu &&
                barrage == that.barrage &&
                book2ImgShared == that.book2ImgShared &&
                book2ImgSharedSuccess == that.book2ImgSharedSuccess &&
                bookBorrow == that.bookBorrow &&
                bookBorrowShared == that.bookBorrowShared &&
                bookBorrowSharedSuccess == that.bookBorrowSharedSuccess &&
                bookDesk == that.bookDesk &&
                bookDeskShared == that.bookDeskShared &&
                bookDeskSharedSuccess == that.bookDeskSharedSuccess &&
                bookDeskUserUv == that.bookDeskUserUv &&
                bookReader == that.bookReader &&
                bookReaderComment == that.bookReaderComment &&
                bookShared == that.bookShared &&
                bookSharedSuccess == that.bookSharedSuccess &&
                club == that.club &&
                clubNew == that.clubNew &&
                d30ActiveUv == that.d30ActiveUv &&
                d30LoginUv == that.d30LoginUv &&
                d30Reg == that.d30Reg &&
                d7ActiveUv == that.d7ActiveUv &&
                d7LoginUv == that.d7LoginUv &&
                d7Reg == that.d7Reg &&
                drawcashMoney == that.drawcashMoney &&
                drawcashUser == that.drawcashUser &&
                dynamic == that.dynamic &&
                dynamicComment == that.dynamicComment &&
                dynamicFri == that.dynamicFri &&
                dynamicFriComment == that.dynamicFriComment &&
                dynamicFriShared == that.dynamicFriShared &&
                dynamicFriSharedSuccess == that.dynamicFriSharedSuccess &&
                dynamicNormal == that.dynamicNormal &&
                dynamicNormalComment == that.dynamicNormalComment &&
                dynamicShared == that.dynamicShared &&
                dynamicSharedSuccess == that.dynamicSharedSuccess &&
                firstPayUser == that.firstPayUser &&
                login == that.login &&
                loginKeepd1 == that.loginKeepd1 &&
                loginKeepd14 == that.loginKeepd14 &&
                loginKeepd2 == that.loginKeepd2 &&
                loginKeepd3 == that.loginKeepd3 &&
                loginKeepd30 == that.loginKeepd30 &&
                loginKeepd4 == that.loginKeepd4 &&
                loginKeepd5 == that.loginKeepd5 &&
                loginKeepd6 == that.loginKeepd6 &&
                loginKeepd7 == that.loginKeepd7 &&
                onlineSec == that.onlineSec &&
                payMoney == that.payMoney &&
                payUser == that.payUser &&
                pcInstall == that.pcInstall &&
                pcUninstall == that.pcUninstall &&
                praise == that.praise &&
                praiseComment == that.praiseComment &&
                praiseDynamicFri == that.praiseDynamicFri &&
                praiseDynamicNormal == that.praiseDynamicNormal &&
                praiseTalk == that.praiseTalk &&
                readBookPv == that.readBookPv &&
                readSec == that.readSec &&
                readUserUv == that.readUserUv &&
                refreshDynamic == that.refreshDynamic &&
                refreshDynamicBookDesk == that.refreshDynamicBookDesk &&
                reg == that.reg &&
                regAll == that.regAll &&
                regGuest == that.regGuest &&
                regQq == that.regQq &&
                regTel == that.regTel &&
                regWebchat == that.regWebchat &&
                regWeibo == that.regWeibo &&
                shareDynamicOther == that.shareDynamicOther &&
                shareDynamicOtherSuccess == that.shareDynamicOtherSuccess &&
                shareDynamicSelf == that.shareDynamicSelf &&
                shareDynamicSelfSuccess == that.shareDynamicSelfSuccess &&
                shareQq == that.shareQq &&
                shareQqSuccess == that.shareQqSuccess &&
                shareQqzone == that.shareQqzone &&
                shareQqzoneSuccess == that.shareQqzoneSuccess &&
                shareWebchat == that.shareWebchat &&
                shareWebchatFri == that.shareWebchatFri &&
                shareWebchatFriSuccess == that.shareWebchatFriSuccess &&
                shareWebchatSuccess == that.shareWebchatSuccess &&
                shareWebo == that.shareWebo &&
                shareWeboSuccess == that.shareWeboSuccess &&
                tagsExists == that.tagsExists &&
                uaBookActivityPv == that.uaBookActivityPv &&
                uaBookActivityUv == that.uaBookActivityUv &&
                uaBookEndPv == that.uaBookEndPv &&
                uaBookEndUv == that.uaBookEndUv &&
                uaBookNewestPv == that.uaBookNewestPv &&
                uaBookNewestUv == that.uaBookNewestUv &&
                uaDeskPv == that.uaDeskPv &&
                uaDeskUv == that.uaDeskUv &&
                uaDynamicPv == that.uaDynamicPv &&
                uaDynamicUv == that.uaDynamicUv &&
                uaRankPv == that.uaRankPv &&
                uaRankUv == that.uaRankUv &&
                uaReadmatUv == that.uaReadmatUv &&
                uaReadmatePv == that.uaReadmatePv &&
                pcInstallUv == that.pcInstallUv &&
                pcUninstallUv == that.pcUninstallUv &&
                readPagePv == that.readPagePv &&
                readPageUv == that.readPageUv &&
                loginGuest == that.loginGuest &&
                readUserGuestUv == that.readUserGuestUv &&
                readUserAppStartNewUv == that.readUserAppStartNewUv &&
                sharePv == that.sharePv &&
                shareUv == that.shareUv &&
                loginAppStartPv == that.loginAppStartPv &&
                bookUv == that.bookUv &&
                shareAllPv == that.shareAllPv &&
                shareAllUv == that.shareAllUv &&
                shareActive == that.shareActive &&
                shareAppPv == that.shareAppPv &&
                shareAppUv == that.shareAppUv &&
                shareAppSuccessPv == that.shareAppSuccessPv &&
                shareAppSuccessUv == that.shareAppSuccessUv &&
                Objects.equals(cid, that.cid) &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(date, that.date) &&
                Objects.equals(platform, that.platform) &&
                Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqid, active, ageAreaExists, appStartKeepd1, appStartKeepd14, appStartKeepd2, appStartKeepd3, appStartKeepd30, appStartKeepd4, appStartKeepd5, appStartKeepd6, appStartKeepd7, appStartNew, appStartPv, appStartUv, appStartUvAll, arpu, barrage, book2ImgShared, book2ImgSharedSuccess, bookBorrow, bookBorrowShared, bookBorrowSharedSuccess, bookDesk, bookDeskShared, bookDeskSharedSuccess, bookDeskUserUv, bookReader, bookReaderComment, bookShared, bookSharedSuccess, cid, club, clubNew, cname, d30ActiveUv, d30LoginUv, d30Reg, d7ActiveUv, d7LoginUv, d7Reg, date, drawcashMoney, drawcashUser, dynamic, dynamicComment, dynamicFri, dynamicFriComment, dynamicFriShared, dynamicFriSharedSuccess, dynamicNormal, dynamicNormalComment, dynamicShared, dynamicSharedSuccess, firstPayUser, login, loginKeepd1, loginKeepd14, loginKeepd2, loginKeepd3, loginKeepd30, loginKeepd4, loginKeepd5, loginKeepd6, loginKeepd7, onlineSec, payMoney, payUser, pcInstall, pcUninstall, platform, praise, praiseComment, praiseDynamicFri, praiseDynamicNormal, praiseTalk, readBookPv, readSec, readUserUv, refreshDynamic, refreshDynamicBookDesk, reg, regAll, regGuest, regQq, regTel, regWebchat, regWeibo, shareDynamicOther, shareDynamicOtherSuccess, shareDynamicSelf, shareDynamicSelfSuccess, shareQq, shareQqSuccess, shareQqzone, shareQqzoneSuccess, shareWebchat, shareWebchatFri, shareWebchatFriSuccess, shareWebchatSuccess, shareWebo, shareWeboSuccess, tagsExists, uaBookActivityPv, uaBookActivityUv, uaBookEndPv, uaBookEndUv, uaBookNewestPv, uaBookNewestUv, uaDeskPv, uaDeskUv, uaDynamicPv, uaDynamicUv, uaRankPv, uaRankUv, uaReadmatUv, uaReadmatePv, version, pcInstallUv, pcUninstallUv, readPagePv, readPageUv, loginGuest, readUserGuestUv, readUserAppStartNewUv, sharePv, shareUv, loginAppStartPv, bookUv, shareAllPv, shareAllUv, shareActive, shareAppPv, shareAppUv, shareAppSuccessPv, shareAppSuccessUv);
    }
}
