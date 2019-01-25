<template>
<div>
  <div class="bg1">
    <sui-container class="padding-top-bottom">
      <h1 is="sui-header" style="font-size: 60px;font-family: 'Roboto Thin'" class="text-white" text-align="center">Login Page</h1>
    </sui-container>
  </div>
  <div is="sui-container" class="floating">
    <sui-grid>
      <sui-grid-column :width="8" is="sui-container">
        <sui-segment>
          <sui-form @submit="onSubmit">
            <sui-form-field>
              <label>Email</label>
              <input type="email" placeholder="Email" required v-model="login.email" autofocus>
            </sui-form-field>

            <sui-form-field>
              <label>Password</label>
              <input type="password" placeholder="Password" required v-model="login.password">
            </sui-form-field>
            <sui-button type="submit" primary>Login</sui-button>
            <br><br>
            <sui-button  @click="$router.push('registerMember')" secondary>Register Member</sui-button>
            <sui-button  @click="$router.push('registerDriver')" secondary>Register Driver</sui-button>
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
      console.log(data)
      http
        .post("/auth/login", data)
        .then(response => {
          this.login.name = response.data.name;
          this.login.balance = response.data.balance;
          this.login.role = response.data.role;
          this.login.success = response.data.success;
          if (this.login.success==true){
              let userData = user.user;
              console.log(userData);
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

<style scoped>
  .bg1{
    background-image: linear-gradient(to top right, #1C2236, #4C5C8E);
  }
  .padding-top-bottom{
    padding: 5rem 0;
  }
  .text-white{
    color: white;
  }
  .floating{
    position: relative;
    top: -2rem
  }
</style>
