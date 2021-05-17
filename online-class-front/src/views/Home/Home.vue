<template>
  <div>
    <!-- 轮播图组件 -->
    <home-banner :banners="banners"></home-banner>
    <!-- 视频列表组件 -->
    <video-list :courselist="courselist"></video-list>
    <!-- 底部导航栏组件 -->
    <common-footer></common-footer>
  </div>
</template>

<script>
import HomeBanner from "./Component/Banner";
import VideoList from "./Component/VideoList";
import CommonFooter from "@/components/CommonFooter";
//api引入
import { getBanner, getVideoList } from "@/api/getData.js";

export default {
  name: "Home",
  //注册组件
  components: { HomeBanner, VideoList, CommonFooter },

  //声明数据源
  data() {
    return {
      banners: [],
      courselist: [],
    };
  },

  methods: {
    //获取轮播图列表
    async getBannerData() {
      try {
        const result = await getBanner();
        if (result.data.code == 0) {
          this.banners = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },

    // 获取视频列表数据并赋值到data字段里
    async getVlist() {
      try {
        const result = await getVideoList();
        this.courselist = result.data.data;
      } catch (error) {
        console.log(error);
      }
    },
  },

  //页面渲染完成调用方法获取数据
  mounted() {
    this.getBannerData();
    this.getVlist();
  },
};
</script>

<style lang="scss" scoped>
</style>