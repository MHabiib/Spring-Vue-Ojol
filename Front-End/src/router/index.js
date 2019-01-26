import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/login'
import Home from '@/components/home'
import Profile from '@/components/profile'
import ListBooking from '@/components/list-booking'
import ListDriver from '@/components/list-driver'
import RegisterMember from '@/components/registerMember'
import RegisterDriver from '@/components/registerDriver'

Vue.use(Router);

import data from '../database.js'

export default new Router({
  mode: 'history',
  data:{
    cekUser:{
      role:data.user.role
    }
  },
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path:'/home',
      component: Home,
      beforeEnter: (to, from, next) => {
        if (!data.user.success){
          next('/login')
        } else {
          if(data.user.role==="DRIVER")
          next('list-booking')
          else
            next()
        }
      }
    },
    {
      path: '/list-booking',
      component: ListBooking,
      beforeEnter: (to, from, next) => {
        if (!data.user.success){
          next('/login')
        } else {
          next()
        }
      }
    },
    {
      path: '/list-driver',
      component: ListDriver,
      beforeEnter: (to, from, next) => {
        if (!data.user.success){
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
      path: '/registerDriver',
      component: RegisterDriver
    },
    {
      path: '/registerMember',
      component: RegisterMember
    },
    {
      path: '/profile',
      component: Profile,
      beforeEnter: (to, from, next) => {
        if (!data.user.success){
          next('/login')
        } else {
          next()
        }
      }
    }
  ]
})
