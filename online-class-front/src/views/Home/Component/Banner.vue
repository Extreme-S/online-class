<template>
  <div>
    <cube-slide :data="banners">
      <cube-slide-item v-for="(item, index) in banners" :key="index">
        <a :href="item.url">
          <img :src="item.img" style="width: 100%" />
        </a>
      </cube-slide-item>
    </cube-slide>
  </div>
</template>

<script>
export default {
  name: "Banner",
  // 获取父组件传的数据
  props: {
    banners: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
</style>