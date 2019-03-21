package com.fanle.moka.constant;

import com.fanle.moka.constant.base.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ReadPathEnum implements BaseEnum<String,String> {
    clubReadTogetherEnterReader("clubReadTogetherEnterReader","书会共读进入"),
    clubChatEnterReader("clubChatEnterReader","书会BB墙进入"),
    launchAppSchemeEnterBookDetailToReader("launchAppSchemeEnterBookDetailToReader","appScheme-启动页-书籍详情"),
    deskHorseLampEnterBookDetailToReader("deskHorseLampEnterBookDetailToReader","appScheme-书桌走马灯-书籍详情"),
    dynamicAdvertAppSchemeEnterBookDetailToReader("dynamicAdvertAppSchemeEnterBookDetailToReader","appScheme-动态广告位-书籍详情"),
    libraryBannerBigAppSchemeEnterBookDetailToReader("libraryBannerBigAppSchemeEnterBookDetailToReader","appScheme-书库轮播图(大)-书籍详情"),
    libraryBannerSmallAppSchemeEnterReader("libraryBannerSmallAppSchemeEnterReader","appScheme-书库轮播图(小)-书籍详情"),
    searchHotFirstEnterBookDetailToReader("searchHotFirstEnterBookDetailToReader","搜索热词-书籍详情"),
    librarySpecialListEnterBookDetailToReader("librarySpecialListEnterBookDetailToReader","专题管理-书籍详情"),
    libraryRankTop20EnterBookDetailToReader("libraryRankTop20EnterBookDetailToReader","书库排行榜前20-书籍详情"),
    libraryRecommendEnterBookDetailToReader("libraryRecommendEnterBookDetailToReader","小编推荐-书籍详情"),
    librarySortTop10EnterBookDetailToReader("librarySortTop10EnterBookDetailToReader","书库分类前10-书籍详情"),
    clubReadTogetherEnterBookDetailToReader("clubReadTogetherEnterBookDetailToReader","书会共读进入-书籍详情"),
    libraryFreeWithTimeEnterBookDetailToReader("libraryFreeWithTimeEnterBookDetailToReader","书库免费-限时免费"),
    librarySelectedEnterBookDetailToReader("librarySelectedEnterBookDetailToReader","书库精选-书籍详情"),
    libraryBoyEnterBookDetailToReader("clubReadTogetherEnterBookDetailToReader","书库男生-书籍详情"),
    libraryGirlEnterBookDetailToReader("libraryGirlEnterBookDetailToReader","书库女生-书籍详情"),
    libraryPublishEnterBookDetailToReader("libraryPublishEnterBookDetailToReader","书库出版-书籍详情"),
    librarySortListEnterBookDetailToReader("librarySortListEnterBookDetailToReader","书库分类-书籍详情"),
    libraryRankListEnterBookDetailToReader("libraryRankListEnterBookDetailToReader","书库排行榜-书籍详情"),
    libraryFreeEnterBookDetailToReader("libraryFreeEnterBookDetailToReader","书库免费-书籍详情"),
    defaultBookDetailToReader("defaultBookDetailToReader","书籍详情");

    @Getter
    @Setter
    private String key ;
    @Getter
    @Setter
    private String name ;

    public static String name(String key){
        return BaseEnum.getKey(key,ReadPathEnum.values());
    }

}
