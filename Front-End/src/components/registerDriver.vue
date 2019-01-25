<template>
  <div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" style="font-size: 60px;font-family: 'Roboto Thin'" class="text-white" text-align="center">Register Driver Page</h1>
      </sui-container>
    </div>
    <div is="sui-container" class="floating">
      <sui-grid>
        <sui-grid-column :width="8" is="sui-container">
          <sui-segment>
            <sui-form @submit="onSubmit">

              <sui-form-field>
                <label>Name</label>
                <input type="text" placeholder="Name" required v-model="registerDriver.name" autofocus>
              </sui-form-field>

              <sui-form-field>
                <label>Email</label>
                <input type="email" placeholder="Email" required v-model="registerDriver.email" autofocus>
              </sui-form-field>

              <sui-form-field>
                <label>Password</label>
                <input type="password" placeholder="Password" required v-model="registerDriver.password">
              </sui-form-field>

              <sui-form-field>
                <label>Balance</label>
                <input type="number" placeholder="Balance" required v-model="registerDriver.balance">
              </sui-form-field>


              <sui-form-field>
                <label>STNK</label>
                <input type="text" placeholder="STNK" required v-model="registerDriver.stnk">
              </sui-form-field>

              <sui-button type="submit" primary>Register</sui-button>
              <sui-button  @click="$router.push('login')" secondary>Login Page</sui-button>
              <!-- <sui-button>Submit</sui-button> -->
            </sui-form>
          </sui-segment>
        </sui-grid-column>
      </sui-grid>
    </div>
  </div>
</template>

<script>
  import http from '../http-common.js'

  export default {
    name:"RegisterDriver",
    data() {
      return{
        registerDriver:{
          name:'',
          email: '',
          password: '',
          balance:'',
          stnk:''
        }
      }
    },

    methods: {
      onSubmit(event) {
        event.preventDefault();
        var data = {
          name:this.registerDriver.name,
          email: this.registerDriver.email,
          password: this.registerDriver.password,
          balance:this.registerDriver.balance,
          stnk:this.registerDriver.stnk
        };
        http
          .post("/driver/create", data)
          .then(this.$router.push('/login'))
          .catch(e => {
            console.log(e);
          });

        console.log(this.registerDriver.success);
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
