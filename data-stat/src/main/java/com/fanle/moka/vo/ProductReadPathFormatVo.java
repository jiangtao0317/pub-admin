package com.fanle.moka.vo;

import com.fanle.moka.annotation.Excel;
import lombok.Data;

@Data
public class ProductReadPathFormatVo {

    @Excel(name = "日期")
    private String date ;
    @Excel(name = "书会共读进入")
    private long clubReadTogetherEnterReader = 0;
    @Excel(name = "书会BB墙进入")
    private long clubChatEnterReader = 0;
    @Excel(name = "appScheme-启动页-书籍详情")
    private long launchAppSchemeEnterBookDetailToReader = 0;
    @Excel(name = "appScheme-书桌走马灯-书籍详情")
    private long deskHorseLampEnterBookDetailToReader = 0;
    @Excel(name = "appScheme-动态广告位-书籍详情")
    private long dynamicAdvertAppSchemeEnterBookDetailToReader = 0;
    @Excel(name = "appScheme-书库轮播图(大)-书籍详情")
    private long libraryBannerBigAppSchemeEnterBookDetailToReader = 0;
    @Excel(name = "appScheme-书库轮播图(小)-书籍详情")
    private long libraryBannerSmallAppSchemeEnterReader = 0;
    @Excel(name = "搜索热词-书籍详情")
    private long searchHotFirstEnterBookDetailToReader = 0;
    @Excel(name = "专题管理-书籍详情")
    private long librarySpecialListEnterBookDetailToReader = 0;
    @Excel(name = "书库排行榜前20-书籍详情")
    private long libraryRankTop20EnterBookDetailToReader = 0;
    @Excel(name = "小编推荐-书籍详情")
    private long libraryRecommendEnterBookDetailToReader = 0;
    @Excel(name = "书库分类前10-书籍详情")
    private long librarySortTop10EnterBookDetailToReader = 0;
    @Excel(name = "书会共读进入-书籍详情")
    private long clubReadTogetherEnterBookDetailToReader = 0;
}