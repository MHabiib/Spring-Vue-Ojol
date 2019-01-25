<template>
	<div>
		<div class="bg1">
			<sui-container class="padding-top-bottom">
				<sui-grid>
						<sui-grid-column :width="4" vertical-align="middle">
						<sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="small" circular />
						</sui-grid-column>
						<sui-grid-column :width="12" vertical-align="middle">
						<h1 is="sui-header" style="font-size: 60px;font-family: 'Roboto Thin'" class="text-white">{{user.name}}</h1>
						</sui-grid-column>
				</sui-grid>
			</sui-container>
		</div>
		<div>
		<sui-container>
			<sui-grid class="floating">
				<sui-grid-column :width="11">
					<sui-segment raised class="jarak-padding">
						<h4 is="sui-header">You are a "{{user.role}}"</h4>
						<h3 is="sui-header">Saldo Blipay : Rp. {{user.balance}} </h3>
					</sui-segment>
				</sui-grid-column>
				<sui-grid-column :width="5" class="middle-aligned">
					<sui-segment raised class="jarak-padding">
						<h4>Contact & Personal Info</h4>
						<h5 is="sui-header">
							<sui-icon name="mail outline" />
							<sui-header-content>
								Email :
								<sui-header-subheader>{{user.email}}</sui-header-subheader>
							</sui-header-content>
						</h5>
					</sui-segment>

				</sui-grid-column>
			</sui-grid>
		</sui-container>
		</div>
	</div>

</template>

<script>
import data from '../database.js'

export default {
  data() {
    return{
      user:{
        name: '',
        balance: '',
        role:'',
        email:''
      }
    }
  },
  created() {
    if (data.user) {
      this.user.name = data.user.name;
      this.user.balance = data.user.balance;
      this.user.role = data.user.role;
      this.user.email = data.user.email;
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
</style>


