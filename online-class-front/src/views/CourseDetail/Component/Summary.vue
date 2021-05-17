<template>
  <!-- 详情图 -->
  <div><img class="summary" :src="videoInfo.summary" /></div>
</template>

<script>
export default {
  props: {
    videoInfo: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
.summary {
  width: 100%;
  padding-bottom: 50px;
  margin: 15px 0;
}
</style>