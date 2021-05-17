<template>
  <div class="tab">
    <cube-tab-bar v-model="selectedLabelDefault" @click="changeHandler">
      <!--:value="item.path" 是传给changeHandler 的值-->
      <cube-tab
        v-for="item in tabs"
        :icon="item.icon"
        :label="item.label"
        :key="item.path"
        :value="item.path"
      ></cube-tab>
    </cube-tab-bar>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selectedLabelDefault: '/',
      tabs: [
        {
          label: '首页',
          icon: 'cubeic-home',
          path: '/',
        },
        {
          label: '我的订单',
          icon: 'cubeic-like',
          path: '/order',
        },
        {
          label: '个人中心',
          icon: 'cubeic-person',
          path: '/personal',
        },
      ],
    }
  },
  methods: {
    // 点击tab跳转
    changeHandler(path) {
      //this.$route.path 是当前路由
      if (path !== this.$route.path) {
        this.$router.push(path)
      }
    },
  },
  created() {
    //默认选择的路由，比如刷新当前页面，需要重新进到浏览器的路由
    this.selectedLabelDefault = this.$route.path
  },
}
</script>

<style lang="scss" scoped>
.tab {
  position: fixed;
  bottom: 0;
  z-index: 999;
  background-color: #fff;
  width: 100%;
  border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
}
.cube-tab_active {
  color: #3bb149;
}
</style>
