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

      <sui-comment-group>
        <sui-comment>
          <sui-grid>
          <sui-grid-column :width="4" vertical-align="middle">
            <sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="tiny" circular />
          </sui-grid-column>

          <sui-grid-column :width="6" vertical-align="middle">

            <sui-icon size="small" name="map marker alternate" /> Destination
          </sui-grid-column>

          <sui-grid-column :width="6" vertical-align="middle">
            <sui-button negative @click="cancel()" floated="right">Cancel</sui-button>
          </sui-grid-column>
        </sui-grid>

          <sui-grid>
            <sui-grid-column :width="4" vertical-align="middle">
              <sui-image src="https://semantic-ui-vue.github.io/static/images/avatar/large/matthew.png" size="tiny" circular />
            </sui-grid-column>

            <sui-grid-column :width="6" vertical-align="middle">

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
