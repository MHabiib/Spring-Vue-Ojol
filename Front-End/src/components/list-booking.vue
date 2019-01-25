<template>
  <div>
<div class="bg1">
  <sui-container class="padding-top-bottom">
    <h1 is="sui-header" class="text-white" text-align="center"><sui-icon size="small" name="briefcase" />Enjoy Your Journey</h1>
  </sui-container>
</div>
<div>
  <sui-container class="padding-top">
    <sui-segment raised class="jarak-padding">

      <sui-comment-group>
        <sui-comment>
          <sui-grid>
            <sui-grid-column :width="4" vertical-align="middle">
              <sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="tiny" circular />
            </sui-grid-column>

            <sui-grid-column :width="6" vertical-align="middle">
              <h2 is="sui-header">{{user.nama}}</h2>

              <div>
                <li v-for=""booking in bookings>{{booking.driverId}}</li>
              </div>

              <sui-icon size="small" name="map marker alternate" /> Destination
            </sui-grid-column>

            <sui-grid-column :width="6" vertical-align="middle">
              <sui-button negative @click="cancel()" floated="right">Cancel</sui-button>
            </sui-grid-column>
          </sui-grid>
        </sui-comment>
      </sui-comment-group>


    </sui-segment>
  </sui-container>
</div>
</div>

</template>

<script>
  import data from '../database.js'
  import axios from 'axios'
  export default {
    /*data() {
      return{
        user:{
          username: '',
          password: '',
          nama: '',
          email: '',
          value: ''
        }
      }
    },*/
    data:{
      bookings:[],
    },mounted(){
      fetch("http://localhost:8080/booking")
        .then(response => response.json())
        .then((data)=>{this.bookings=data})
    },
    methods:{
      cancel(){
      }
    },
    created() {
      if (data.user) {
        this.user.username = data.user.username
        this.user.password = data.user.password
        this.user.nama = data.user.nama,
          this.user.email = data.user.email
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
  .padding-top{
    padding-top: 2rem;
  }
</style>
