<template>
  <div>
<div class="bg1">
  <sui-container class="padding-top-bottom">
    <h1 is="sui-header" class="text-white" text-align="center"><sui-icon size="small" name="briefcase" />Enjoy Your Journey</h1>
  </sui-container>
</div>
<div>
  <sui-container class="padding-top floating">
    <sui-segment raised class="jarak-padding">

      <div class="ui middle aligned divided list" v-for="result in results" :key="result.id">
        <div class="item">
          <div >
            <div class="content" >
              <br/><h4>Booking ID : {{result.id}}</h4>
              <h4>Booked By : {{result.memberName}} <br/>
              Driver : {{result.driverName}} <br/>
              Price : {{result.price}}<br/>
              Pickup Location : {{result.pickup}}  -------------->
              Destination : {{result.dropoff}}<br/>
              Payment Method : {{result.paymentMethod}}<br/>
              Status : {{result.status}}</h4>
            </div><br/>
            <div class="ui button">Accept</div>
            <div class="ui button">Cancel</div>
            <br/>
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
    name: 'BookingList',
    data(){
      return {
        results:[]
      }
    },async mounted(){
      const response = await axios.get('http://localhost:8080/booking')
      this.results=response.data
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
