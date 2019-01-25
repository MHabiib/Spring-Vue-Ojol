<template>
  <div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" class="text-white" text-align="center">List Booking</h1>
      </sui-container>
    </div>
  <div class="list row">
    <div class="col-md-6">
      <h4>Booking List</h4>
      <ul>
        <li v-for="(booking, index) in booking" :key="index">
          <router-link :to="{
                            name: 'List Booking',
                            params: { booking: booking, id: booking.id, memberId: booking.memberId, price: booking.price, driverId: booking.driverId, status: booking.status}}">
            {{booking.memberId, booking.price}}

          </router-link>
        </li>
      </ul>
    </div>
    <div class="col-md-6">
      <router-view @refreshData="refreshList"></router-view>
    </div>
  </div>
  </div>
</template>

<script>
  import http from "../http-common";

  export default {
    name: "booking-list",
    data() {
      return {
        booking: []
      };
    },
    methods: {
      /* eslint-disable no-console */
      retrieveCustomers() {
        http
          .get("/booking")
          .then(response => {
            this.booking = response.data; // JSON are parsed automatically.
            console.log(response.data);
          })
          .catch(e => {
            console.log(e);
          });
      },
      refreshList() {
        this.retrieveCustomers();
      }
      /* eslint-enable no-console */
    },
    mounted() {
      this.retrieveCustomers();
    }
  };
</script>

<style scoped>
  .list {
    text-align: left;
    max-width: 450px;
    margin: auto;
  }
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
