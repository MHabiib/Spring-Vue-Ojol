<template>
<div>
  <div is="sui-container" class="padding-nav">
    <sui-grid>
      <sui-grid-column :width="8" is="sui-container">
        <sui-segment>
          <sui-form @submit="onSubmit">
            <h3 text-align="right">Login</h3>
            <sui-form-field>
              <label>Email</label>
              <input type="email" placeholder="Email" required v-model="login.email" autofocus>
            </sui-form-field>

            <sui-form-field>
              <label>Password</label>
              <input type="password" placeholder="Password" required v-model="login.password">
            </sui-form-field>
            <sui-button type="submit" primary>Login</sui-button>

            <!-- <sui-button>Submit</sui-button> -->
          </sui-form>
        </sui-segment>
      </sui-grid-column>
    </sui-grid>
  </div> 
  </div>
</template>

<script>
import user from '../database.js'
import http from '../http-common.js'

export default {
  name:"Login",
  data() {
		return{
      login:{
        email: 'sana@jwp.com',
        password: 'sana123',
        success:'false'
      }
		}
  },

  methods: {
    onSubmit(event) {
      event.preventDefault();
      var data = {
        email: this.login.email,
        password: this.login.password
      };
      http
        .post("/auth/login", data)
        .then(response => {
          this.login.name = response.data.name;
          this.login.balance = response.data.balance;
          this.login.role = response.data.role;
          this.login.success = response.data.success;
          if (this.login.success==true){
              let userData = user.user;
              Object.assign(userData,response.data)
            // console.log(userData)
            this.$router.push('/home');
          }

          // console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });

      console.log(this.login.success);
    }
  }
};
</script>
<!--
/*
event.preventDefault();
// cek dulu database, adakah nama terdapat dalam users?
let user = data.users[this.email]
if (user) { // database terdapat user bersangkutan
data.user = {} // isikan state 'user', ini menandakan sedang ada user yang login
Object.assign(data.user, data.users[this.username]) //Cloning object, Object.assign(target, ...sources)

// data.user.username = user.username;
// data.user.password = user.password;
// data.user.nama = user.nama;
if(this.password == data.users[this.username].password)
this.$router.push('/home') // rute home akan mengecek state 'user'
else
alert("Password Salah")
} else { // database tidak terdapat user bersangkutan
alert("Username Salah")
}
}*/-->

