<template>
  <div>
    <div class="homepage">
      <HomeView msg="home01" />
    </div>
    <div class="sectionhome">
      <Introduction msg="home02" />
    </div>
  </div>

</template>

<script>
import Introduction from '../components/HomePage/HomeIntroduction.vue'
import HomeView from '../components/HomePage/HomeBanner.vue'

export default {
  name: 'App',
  data() {
    return {
      msg: 'zhentamashab',
    }
  },
  components: {
    HomeView,
    Introduction,
  },
}
</script>

<style>
#app {
  font-family: One;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;
}
</style>
