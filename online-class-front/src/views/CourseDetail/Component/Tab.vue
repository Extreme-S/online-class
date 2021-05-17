<template>
  <div>
    <cube-tab-bar v-model="selectedLabel" show-slider>
      <cube-tab v-for="item in tabs" :label="item.label" :key="item.label">
      </cube-tab>
    </cube-tab-bar>

    <!--vue的动态组件-->
    <component
      :videoInfo="videoInfo"
      :chapterList="chapterList"
      :is="selectedLabel === '简介' ? 'Summary' : 'Catalog'"
    ></component>
  </div>
</template>

<script>
import Catalog from "./Catalog";
import Summary from "./Summary";

export default {
  //注册组件
  components: {
    Catalog,
    Summary,
  },
  //获取父组件的传值
  props: {
    videoInfo: {
      type: Object,
      required: true,
    },
    chapterList: {
      type: Array,
      required: true,
    },
  },

  data() {
    return {
      selectedLabel: "简介",
      tabs: [
        {
          label: "简介",
        },
        {
          label: "目录",
        },
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
</style>