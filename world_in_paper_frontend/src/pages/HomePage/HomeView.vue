<template>
  <div @mousewheel="handleMousewheel">
    <div class="homepage">
      <home-banner msg="home01"
                   v-show="bannerShow" ref="banner"/>
    </div>
    <div class="sectionhome">
      <home-introduction msg="home02"
                         v-show="introductionShow" ref="introduction"/>
    </div>
  </div>

</template>

<script>
import HomeIntroduction from '../../components/HomePage/HomeIntroduction.vue'
import HomeBanner from '../../components/HomePage/HomeBanner.vue'
import AddColumn from '../../components/UserPage/AddColumn.vue'
import UploadPaperwork from '../../components/UserPage/UploadPaperwork.vue'

export default {
  name: 'HomeView',
  data() {
    return {
      bannerShow: true,
      introductionShow: true,
    }
  },
  components: {
    HomeBanner,
    HomeIntroduction,
    AddColumn,
  },
  methods: {
    UploadPaperworkndleMousewheel(e) {
        // // 禁用鼠标滚轮事件
        // e.preventDefault()
        // // 鼠标滚轮向下滚动
        // if (e.deltaY > 0) {
        //   this.bannerShow = false
        //   this.$refs.introduction.scrollIntoView()
        //   this.introductionShow = true

        // }
        // // 鼠标滚轮向上滚动
        // if (e.deltaY < 0) {
        //   this.bannerShow = true
        //   this.introductionShow = false
        // }

    },
  },
}
</script>

<style scoped>
</style>
