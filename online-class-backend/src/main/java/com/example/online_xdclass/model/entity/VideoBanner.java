package com.example.online_xdclass.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * 小滴课堂 视频轮播图
 *
 *  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 *   `url` varchar(256) DEFAULT NULL COMMENT '跳转地址',
 *   `img` varchar(256) DEFAULT NULL COMMENT '图片地址',
 *   `create_time` datetime DEFAULT NULL,
 *   `weight` int(11) DEFAULT NULL COMMENT '数字越小排越前',
 *
 */
public class VideoBanner {
    private Integer id;

    private String url;

    private String img;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;


    private Integer weight;

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", weight=" + weight +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
