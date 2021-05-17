package com.example.online_class.service.impl;

import com.example.online_class.config.CacheKeyManager;
import com.example.online_class.mapper.VideoMapper;
import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;
import com.example.online_class.service.VideoService;
import com.example.online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private BaseCache baseCache;

    @Override
    public List<Video> listVideo() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEL_LIST, () -> {
                List<Video> videoList = videoMapper.listVideo();
                System.out.println("数据库查询视频列表");
                return videoList;
            });

            if (cacheObj instanceof List) {
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //可以返回兜底数据，业务系统降级-》SpringCloud专题课程
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("从数据库里面查询轮播图列表");
                return bannerList;
            });

            if (cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
        try {
            Object cacheObject = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);
                System.out.println("数据库查询视频详情"+videoId);
                return video;
            });

            if (cacheObject instanceof Video) {
                Video video = (Video) cacheObject;
                return video;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
