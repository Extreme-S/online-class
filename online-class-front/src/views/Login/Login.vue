<template>
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">
      <cube-form-group>
        <!-- 手机号 -->
        <cube-form-item :field="fields[0]"></cube-form-item>
        <!-- 密码 -->
        <cube-form-item :field="fields[1]"></cube-form-item>
      </cube-form-group>
      <cube-form-group>
        <cube-button type="submit">登录</cube-button>
      </cube-form-group>
    </cube-form>
    <router-link to="/register" class="reg"><span>注册</span></router-link>
  </div>
</template>

<script>
import { loginApi } from '@/api/getData.js'
export default {
  data() {
    return {
      model: {
        phoneValue: '',
        pwdValue: '',
        namevalue: '',
      },
      fields: [
        {
          type: 'input',
          modelKey: 'phoneValue',
          label: '手机号',
          props: {
            placeHolder: '请输入手机号',
          },
          rules: {
            required: true,
          },
          message: {
            required: '手机号不能为空',
          },
        },

        {
          type: 'input',
          modelKey: 'pwdValue',
          label: '密码',
          props: {
            placeHolder: '请输入密码',
            type: 'password',
            eye: {
              open: false,
            },
          },
          rules: {
            required: true,
          },
          message: {
            required: '密码不能为空',
          },
        },
      ],
    }
  },

  methods: {
    //登录表单提交处理
    submitHandler(e, model) {
      e.preventDefault()
      loginApi(model.phoneValue, model.pwdValue).then((res) => {
        if (res.data.code === 0) {
          localStorage.setItem('token', res.data.data)

          this.$store.dispatch('setToken', res.data.data)

          //登陆成功，跳转到个人中心
          this.$router.push({ path: '/' })
        } else {
          const toast = this.$createToast({
            txt: '登录失败',
            type: 'error',
            time: 1500,
          })
          toast.show()
        }
      })
    },
  },
}
</script>

<style lang="scss" scoped>
.main {
  padding: 50px 5% 0;
  text-align: center;
}
// 登录
.cube-btn {
  margin-top: 20px;
}
//注册
.reg {
  display: inline-block;
  margin-top: 30px;
  font-size: 18px;
}
</style>
