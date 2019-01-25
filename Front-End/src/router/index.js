import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login'
import Home from '@/components/home'
import Profile from '@/components/profile'

Vue.use(Router)

import data from '../database.js'

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path:'/home',
      component: Home,
      beforeEnter: (to, from, next) => {
        if (!data.user){
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/login',
      component: Login
    },
    {
      path: '/profile',
      component: Profile
    }
  ]
})
