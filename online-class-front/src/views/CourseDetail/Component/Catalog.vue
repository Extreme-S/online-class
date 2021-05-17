<template>
  <div class="cate_box">
    <div>
      <ul class="content" v-for="(item, index) in chapterList" :key="item.id">
        <h1>第{{ index + 1 }}章 &nbsp; {{ item.title }}</h1>

        <li
          class="sub_cate"
          v-for="(item, subIndex) in chapterList[index].episode_list"
          :key="item.id"
        >
          <span class="sub_title"
            >{{ index + 1 }}-{{ subIndex + 1 }} &nbsp; {{ item.title }}</span
          >
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  //从父组件获取传值信息
  props: {
    chapterList: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
// 目录包裹层设置边距
.cate_box {
  padding: 0 15px 50px;
  background-color: #fff;
  margin: 15px 0;
}

//每一章包裹层
.content {
  padding: 10px;
  // 章标题
  & h1 {
    font-size: 16px;
    width: 100%;
    margin-bottom: 15px;
    font-weight: bolder;
    // 设置章标题过长,超过行宽度省略隐藏
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}

//集包裹层
.sub_cate {
  font-size: 12px;
  padding: 10px 0;
  //集标题
  .sub_title {
    // 设置集标题过长,超过行宽度省略隐藏
    display: block;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}
</style>