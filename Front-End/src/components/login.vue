<template>
<div>
  <div is="sui-container" class="padding-nav">
    <sui-grid>
      <sui-grid-column :width="8" is="sui-container">
        <sui-segment>
          <sui-form @submit="onSubmit">
            <h3 text-align="right">Login</h3>
            <sui-form-field>
              <label>Username</label>
              <input placeholder="Username" v-model="username">
            </sui-form-field>
            <sui-form-field>
              <label>Password</label>
              <input type="password" placeholder="Password" v-model="password">
            </sui-form-field>
            <sui-form-field>
              <sui-checkbox label="I agree to the Terms and Conditions" />
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
import data from '../database.js'

export default {
  data() {
		return{
			username: '',
			password: '',
      setuju:'',
      message:''
		}
  },
  methods:{
    onSubmit (event) {
      event.preventDefault();
      // cek dulu database, adakah nama terdapat dalam users?
      let user = data.users[this.username]
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
    }
  }
};
</script>

