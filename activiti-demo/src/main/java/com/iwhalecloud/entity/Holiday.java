package com.iwhalecloud.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 请假实体
 */
public class Holiday implements Serializable {

    private Integer id;

    // 申请人
    private String holidayName;

    // 开始时间
    private Date beginDate;

    // 结束时间
    private Date endDate;

    // 请假天数
    private Float dayNum;

    // 事由
    private String reason;

    // 请假类型
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Float getDayNum() {
        return dayNum;
    }

    public void setDayNum(Float dayNum) {
        this.dayNum = dayNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
