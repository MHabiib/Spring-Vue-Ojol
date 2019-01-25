<template>
  <div id="app">
    <sui-menu pointing secondary class="no-margin-bottom padding-top-bottom bg-white">
      <div is="sui-container">
        <a
          is="sui-menu-item"
          v-for="item in items"
          :active="isActive(item.title)"
          :key="item.title"
          :content="item.title"
          @click="select(item)"
        />
        <sui-menu-menu position="right" v-if="adaYangLogin">
          <a
            is="sui-menu-item"
            :active="isActive('Logout')"
            content="Logout"
            @click="logout"
          />
        </sui-menu-menu>
        <sui-menu-menu position="right" v-if="!adaYangLogin">
          <a
            is="sui-menu-item"
            :active="isActive('Login')"
            content="Login"
            @click="select({link: '/login'})"
          />
        </sui-menu-menu>
      </div>
      
    </sui-menu>
    <router-view/>
  </div>
</template>

<script>
import data from './database.js'

export default {
  name: 'App',
  data() {
    return {
      adaYangLogin: false,
      active: 'Home',
      items: [
        {
          title: 'Home',
          link: '/home'
        },
        {
          title:' Profile',
          link: '/profile'
        },
        {
          title:'Friends',
          link: '/friends'
        }],
    };
  },
  methods: {
    isActive(name) {
      return this.active === name;
    },
    select(item) {
      this.active = item.title 
      this.$router.push(item.link)
    },
    logout () {
      data.user = null
      this.$router.push('/login')
    }
  },
  updated: function() {
    this.adaYangLogin = !!data.user
  }
}
</script>
<style scoped>
.no-margin-bottom{
  margin-bottom: 0;
}
.padding-top-bottom{
  padding: 1rem 0;
}
</style>


