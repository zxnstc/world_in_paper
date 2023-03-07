<template>
  <div class="all-paperwork">
    <paperwork-show-page></paperwork-show-page>
  </div>
</template>

<script>
import PaperworkShowPage from '../../components/PaperworkPage/PaperworkShowPage.vue'
export default {
  components: { PaperworkShowPage },
}
</script>

<style scoped>
.all-paperwork {
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
}
</style>