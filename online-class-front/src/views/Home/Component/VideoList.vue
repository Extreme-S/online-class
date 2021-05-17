<template>
  <div class="list-content">
    <div class="list">
      <!-- 遍历视频 -->
      <router-link
        v-for="item in courselist"
        :key="item.id"
        :to="{ path: '/coursedetail', query: { video_id: item.id } }"
        class="course"
      >
        <div class="item_img">
          <img :src="item.cover_img" />
        </div>
        <div class="video_info">
          <div class="c_title">{{ item.title }}</div>
          <div class="price">￥ {{ item.price / 100 }}</div>
        </div>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  // 获取父组件传的数据
  props: {
    courselist: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
//列表包裹层边距
.list-content {
  margin-top: 20px;
  padding: 0 13px;
}
//视频包括层
.list {
  display: flex; //设置flex布局
  flex-wrap: wrap; //换行排列
  justify-content: space-between; //两端对齐
  padding-bottom: 55px;
}
//视频个体层
.course {
  width: 48%;
  margin-bottom: 17px;
}
//视频图片
.item_img {
  font-size: 0; //消除图片元素产生的间隙
  box-shadow: 0 4px 11px 0 rgba(43, 51, 59, 0.6); //设置图片阴影，rgba前三个参数是颜色编码，最后一个是透明度
  border-radius: 8px; //设置图片圆角
  img {
    width: 100%;
    border-radius: 8px;
  }
}
.c_title {
  //设置超过两行隐藏 start
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  word-break: break-all;
  //设置超过两行隐藏 end
  font-size: 11px;
  height: 26px;
  line-height: 13px;
  margin-top: 10px;
  color: #2b333b;
}
//价格
.price {
  margin-top: 8px;
  font-size: 12px;
  color: #d93f30;
}
</style>