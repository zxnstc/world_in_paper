<template>
    <div class="homepage">
        <router-view></router-view>
    </div>
</template>
   
<script>
import PaperworkShowPage from '../../components/PaperworkPage/PaperworkShowPage.vue'
export default {
  name: 'PaperworkIndex',
  components: {
    PaperworkShowPage,
  },
}
</script>
   
<style scoped>

</style>