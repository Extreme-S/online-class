<template>
  <div>
    <div class="container">
      <div class="p_top">
        <div>
          <img :src="info.head_img || defaultHeadImg" alt="头像" />
          <router-link v-if="getToken === ''" to="/login">
            <p>立刻登录</p>
          </router-link>
          <p v-else>{{ info.name }}</p>
        </div>
      </div>
      <button v-if="getToken !== ''" class="green" @click="signOut">
        退出登录
      </button>
    </div>
    <common-footer></common-footer>
  </div>
</template>

<script>
import CommonFooter from '@/components/CommonFooter'
import { getUserInfo } from '@/api/getData.js'
import defaultHeadImg from '@/assets/logo.png'
export default {
  components: {
    CommonFooter,
  },
  data() {
    return {
      info: {},
      defaultHeadImg: defaultHeadImg,
    }
  },
  //属性的获取
  computed: {
    getToken() {
      return this.$store.state.token
    },
  },

  //方法的定义
  methods: {
    //获取用户信息
    async getInfo() {
      try {
        const result = await getUserInfo(this.getToken)
        if (result.data.code === 0) {
          this.info = result.data.data
        }
      } catch (error) {
        console.log(error)
      }
    },
    //退出登录
    async signOut() {
      //清除token
      await this.$store.dispatch('clearToken')
      localStorage.removeItem('token')

      //刷新页面
      location.reload()
    },
  },
  //页面渲染完成时执行的方法
  mounted() {
    //获取用户信息
    if (this.getToken) {
      this.getInfo()
    }
  },
}
</script>

<style lang="scss" scoped>
.container {
  // 顶部头像区域
  .p_top {
    width: 100%;
    // display: flex;
    // flex-direction: column;
    // align-items: center;
    padding: 20px 0;
    background-color: #2c3f54;
    div {
      text-align: center;
      img {
        width: 60px;
        height: 60px;
        border-radius: 50px;
      }
      p {
        font-size: 16px;
        color: #fff;
        margin-top: 10px;
      }
    }
  }
}
// 退出登录
.green {
  display: block;
  background-color: #3bb149;
  border: none;
  // outline: none;
  width: 80%;
  height: 40px;
  margin: 20px auto;
  color: #fff;
  border-radius: 20px;
}
</style>
