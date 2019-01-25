<template>
	<div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" class="text-white" text-align="center"> Welcome  :)</h1>
      </sui-container>
    </div>

    <sui-container class="padding-top">
      <sui-grid>
        <sui-grid-column :width="9">
          <sui-segment raised class="jarak-padding">
            <sui-form @submit="book">
              <h3 text-align="right">Booking</h3>
              <sui-form-field>
                <label>Pickup</label>
                <input type="text" placeholder="Meet me at..." required v-model="addBooking.pickup">
              </sui-form-field>
              <sui-form-field>
                <label>Drop off</label>
                <input type="text" placeholder="I'm going to..." required v-model="addBooking.dropoff)">
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

              <sui-button type="submit" primary>Book Now</sui-button>
              <sui-button  v-on:click="onSubmit2" floated="right">Book Everyday</sui-button>

            </sui-form>
          </sui-segment>
        </sui-grid-column>

        <!-- List Driver -->
        <sui-grid-column :width="7">
          <sui-segment raised class="jarak-padding">

            <sui-comment-group>
              <sui-comment>
                <sui-comment-avatar src="https://semantic-ui-vue.github.io/static/images/avatar/small/matt.jpg" />
                <sui-comment-content>
                  <a is="sui-comment-author">Lorem</a>
                  <sui-comment-metadata>
                    <div>Honda Beat</div>
                  </sui-comment-metadata>
                  <sui-comment-text>BK 1234 AA</sui-comment-text>
                </sui-comment-content>
              </sui-comment>
            </sui-comment-group>
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
      return{
        addBooking:{
          pickup:'',
          dropoff:'',
          paymentMethod:'',
          driverId:'10035',
          memberId:'',
          status:'PENDING',
        }
      }
    },methods: {
      onSubmit(event) {
        event.preventDefault();
        var data = {
          pickup:this.addBooking.pickup,
          dropoff: this.addBooking.dropoff,
          paymentMethod: this.addBooking.paymentMethod,
          driverId: this.addBooking.driverId,
          memberId: this.memberId
        };
        http
          .post("/booking/create", data)
          .then(this.$router.push('/home'))
          .catch(e => {
            console.log(e);
          });

        console.log(this.registerMember.success);
      },methods: {
        onSubmit2(event) {
          event.preventDefault();
          var data = {
            pickup:this.addBooking.pickup,
            dropoff: this.addBooking.dropoff,
            paymentMethod: this.addBooking.paymentMethod,
            driverId: this.addBooking.driverId,
            memberId: this.memberId
          };
          http
            .post("/start", data)
            .then(this.$router.push('/home'))
            .catch(e => {
              console.log(e);
            });

          console.log(this.registerMember.success);
        },
	created() {
      if (data.user) {
        this.user.name = data.user.name;
        this.user.balance = data.user.balance;
        this.user.role = data.user.role
      }
	}}}
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


