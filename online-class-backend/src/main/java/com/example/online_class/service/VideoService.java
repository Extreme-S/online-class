package com.example.online_class.service;


import com.example.online_class.model.entity.Video;
import com.example.online_class.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> listVideo();

    List<VideoBanner> listBanner();

    Video findDetailById(int videoId);
}
