<template>
  <div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" class="text-white" text-align="center">Success is the result of perfection, hard work, learning from failure, loyalty, and persistence. ...</h1>
      </sui-container>
    </div>
    <div>
      <sui-container class="padding-top floating">
        <sui-segment raised class="jarak-padding">
              <div class="ui massive horizontal divided list" v-for="result in results" :key="result.id">
                <div class="item">
                  <sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="small" circular />
                  <div class="content">
                    <div class="header">{{result.name}}</div>
                    {{result.stnk}}&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                  </div>
                </div>
              </div>
        </sui-segment>
      </sui-container>
    </div>
  </div>

</template>

<script>
  import axios from 'axios'

  export default {
    name: 'DriverList',
    data(){
      return {
        results:[]
      }
    },async mounted(){
      const response = await axios.get('http://localhost:8080/driver')
      this.results=response.data
    },onSubmit(event) {
      event.preventDefault();
      var data = {
        pickup:this.addBooking.pickup,
        dropoff: this.addBooking.dropoff,
        paymentMethod: this.addBooking.paymentMethod,
        driverId: this.addBooking.driverId,
        memberId: this.addBooking.memberId,
        status:'PENDING'
      };
      http
        .put("/booking/", data)
        .catch(e => {
          console.log(e);
        })
    }
  }
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
    top: -4rem
  }
  .padding-top{
    padding-top: 2rem;
  }
</style>
