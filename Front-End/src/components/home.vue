<template>
	<div>
    <div class="bg1">
      <sui-container class="padding-top-bottom">
        <h1 is="sui-header" class="text-white" text-align="center"> Welcome {{user.name}} :)</h1>
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
                <input placeholder="Meet me at..." v-model="username">
              </sui-form-field>
              <sui-form-field>
                <label>Drop off</label>
                <input type="text" placeholder="I'm going to..." v-model="password">
              </sui-form-field>

              <sui-form-fields inline>
                <sui-form-field>
                  <label>Payment Method</label>
                  <sui-checkbox
                    radio
                    name="paymentMethod"
                    value="1"
                    v-model="value"
                  >BliPay - Rp. {{user.balance}}</sui-checkbox>
                </sui-form-field>
                <sui-form-field>
                  <sui-checkbox
                    label="Cash"
                    radio
                    name="paymentMethod"
                    value="1"
                    v-model="value"
                  />
                </sui-form-field>
              </sui-form-fields>

              <sui-button type="submit" primary>Book Now</sui-button>
              <sui-button secondary floated="right">Book Everyday</sui-button>

            </sui-form>
          </sui-segment>
        </sui-grid-column>

        <!-- List Driver -->
        <sui-grid-column :width="7">
          <sui-segment raised class="jarak-padding">
            <h3 text-align="right">List Driver</h3>

            <sui-comment-group>
              <sui-comment>
                <sui-comment-avatar src="https://semantic-ui-vue.github.io/static/images/avatar/small/matt.jpg" />
                <sui-comment-content>
                  <a is="sui-comment-author">Harvine Konga</a>
                  <sui-comment-metadata>
                    <div>Honda Beat</div>
                  </sui-comment-metadata>
                  <sui-comment-text>BK 1234 AA</sui-comment-text>
                </sui-comment-content>
              </sui-comment>
            </sui-comment-group>

            <sui-comment-group>
              <sui-comment>
                <sui-comment-avatar src="https://semantic-ui-vue.github.io/static/images/avatar/small/matt.jpg" />
                <sui-comment-content>
                  <a is="sui-comment-author">Harvine Konga</a>
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

export default {
	data() {
		return{
			user:{
				name: '',
				balance: '',
        role:''
			}
		}
	},
	created() {
      if (data.user) {
        this.user.name = data.user.name;
        this.user.balance = data.user.balance;
        this.user.role = data.user.role
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


