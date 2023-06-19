package com.wdf.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 描述
 *
 * @author ddshuai
 * date 2021-07-14 11:21
 **/
@XmlAccessorType(XmlAccessType.FIELD)
public class SendPicsInfo {

    @XmlElement(name = "Count")
    private Integer count;

    @XmlElement(name = "PicList")
    private PicList picList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PicList getPicList() {
        return picList;
    }

    public void setPicList(PicList picList) {
        this.picList = picList;
    }
}
