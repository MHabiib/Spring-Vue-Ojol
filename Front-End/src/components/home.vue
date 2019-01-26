<template>
	<div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" class="text-white" text-align="center">Every Day is a Good Day ... Welcome {{user.name}} :)</h1>
      </sui-container>
    </div>

    <sui-container class="padding-top floating">
          <sui-grid>
            <sui-grid-column :width="22">
          <sui-segment raised class="jarak-padding">
            <sui-form @submit="onSubmit">
              <h3 text-align="right">Booking</h3>
              <sui-form-field>
                <label>Pickup</label>
                <input type="text" placeholder="Meet me at..." required v-model="addBooking.pickup">
              </sui-form-field>
              <sui-form-field>
                <label>Drop off</label>
                <input type="text" placeholder="I'm going to..." required v-model="addBooking.dropoff">
              </sui-form-field>
              <sui-form-fields inline>
                <sui-form-field>
                  <label>Payment Method</label>
                  <sui-checkbox
                    radio
                    name="paymentMethod"
                    value="1"
                    v-model="addBooking.paymentMethod"
                  >BliPay</sui-checkbox>
                </sui-form-field>
                <sui-form-field>
                  <sui-checkbox
                    label="Cash"
                    radio
                    name="paymentMethod"
                    value="2"
                    v-model="addBooking.paymentMethod"
                  />
                </sui-form-field>
              </sui-form-fields>

              <sui-button @click="$router.push('list-booking')" type="submit" primary>Book Now</sui-button>
              <sui-button  @click="onSubmit2" floated="right">Book Everyday</sui-button>

            </sui-form>
          </sui-segment>
        </sui-grid-column>
      </sui-grid>
    </sui-container>
  </div>
</template>

<script>
  import data from '../database.js'
  import http from '../http-common.js'
  import axios from 'axios'

  export default {
    name: 'BookingList',
    data(){
      return {
        onSubmit2:null,
        addBooking: {
          pickup: '',
          dropoff: '',
          paymentMethod: '',
          driverId: 10035,
          memberId: data.user.id,
          status: '',
        },
        user:{
          name:data.user.name
        },
        results:[]
      }
    },async mounted(){
      const response = await axios.get('http://localhost:8080/driver')
      this.results=response.data
    },
    methods: {
      onSubmit(event) {
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
          .post("/booking/create", data)
          .catch(e => {
            console.log(e);
          });
      },methods: {
        onSubmit2(event) {
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
            .post("/start", data)
            .catch(e => {
              console.log(e);
            });
        },
      }
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


