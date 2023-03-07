<template>
  <router-view></router-view>
</template>

<script>
import HomeIntroduction from '../../components/HomePage/HomeIntroduction.vue'
import HomeBanner from '../../components/HomePage/HomeBanner.vue'

export default {
  name: 'HomePageIndex',
  data() {
    return {
      msg: 'zhentamashab',
    }
  },
  components: {
    HomeBanner,
    HomeIntroduction,
  },
}
</script>

<style scoped>
</style>
