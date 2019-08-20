package com.fanle.moka.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: msw
 * @date: 2019-07-29
 * @description:
 **/
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MokaChannelLogVo {

    private long h5AdsenseStatMoney;

    private long h5AdsenseRateMoney;

    private String date;

    public long getH5AdsenseStatMoney() {
        return h5AdsenseStatMoney;
    }

    public void setH5AdsenseStatMoney(long h5AdsenseStatMoney) {
        this.h5AdsenseStatMoney = h5AdsenseStatMoney;
    }

    public long getH5AdsenseRateMoney() {
        return h5AdsenseRateMoney;
    }

    public void setH5AdsenseRateMoney(long h5AdsenseRateMoney) {
        this.h5AdsenseRateMoney = h5AdsenseRateMoney;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
