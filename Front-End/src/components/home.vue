<template>
	<div>
		<div class="bg1">
			<sui-container class="padding-top-bottom">

				<h1 is="sui-header" class="text-white" text-align="center">Selamat Datang {{user.nama}}</h1>

				<!-- <sui-grid>
						<sui-grid-column :width="4" vertical-align="middle">
						<sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="small" circular />
						</sui-grid-column>
						<sui-grid-column :width="12" vertical-align="middle">
						<h2 is="sui-header" class="text-white">{{user.nama}}</h2>
						<p class="text-white">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quod qui beatae, saepe ullam voluptatibus veniam molestiae asperiores porro ducimus quis aspernatur in neque nihil aperiam ratione perspiciatis, atque at consectetur.</p>
						
						</sui-grid-column>
				</sui-grid> -->
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
				username: '',
				password: '',
				nama: '',
				email: ''
			}
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
</style>


