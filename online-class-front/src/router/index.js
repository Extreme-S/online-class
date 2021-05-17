import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('../views/Home/Home.vue'),
  },
  {
    path: '/order',
    name: 'Order',
    component: () => import('../views/Order/Order.vue'),
    meta: { requiresAuth: true },
  },
  {
    path: '/personal',
    name: 'Personal',
    component: () => import('../views/Personal/Personal.vue'),
    meta: { requiresAuth: true },
  },
  //课程详情页面
  {
    path: '/coursedetail',
    name: 'detail',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/CourseDetail/CourseDetail.vue'),
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login/Login.vue'),
  },
  {
    path: '/register',
    name: 'Register',
    component: () => import('../views/Register/Register.vue'),
  },
  {
    path: '/pay',
    name: 'Pay',
    component: () => import('../views/Pay/Pay.vue'),
    meta: { requiresAuth: true },
  },
]

const router = new VueRouter({
  routes,
})

export default router
