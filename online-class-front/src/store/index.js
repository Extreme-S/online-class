import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: localStorage.getItem('token') || '',
  },
  //同步修改state的值

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
  },
  //异步调用mutations里的方法
  //context.commit 利用上下文触发mutations里的方法
  //在vue中 this.$store.dispatch触发action里面定义的方法
  actions: {
    setToken(context, token) {
      context.commit('SET_TOKEN', token)
    },
    clearToken(context, token) {
      context.commit('SET_TOKEN', '')
    },
  },
  modules: {},
})
