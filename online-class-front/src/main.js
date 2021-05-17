import Vue from 'vue'
import './cube-ui'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

//路由拦截，拦截所有路由判断
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  //筛选需要token的路由
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    //根据是否有token,判断是否要调到登陆页面
    if (token) {
      next()
    } else {
      next({ path: '/login' })
    }
  } else {
    next()
  }
})

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app')
