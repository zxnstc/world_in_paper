<template>
  <header>
    <div>
      <the-heading />
    </div>
  </header>

  <body>
    <router-view></router-view>
  </body>
  <!-- <hello-world></hello-world> -->

</template>

<script>
import TheHeading from './components/TheHeading.vue'
import HelloWorld from './components/MyEditor.vue'
export default {
  components: {
    TheHeading,
    HelloWorld,
  },
  mounted() {
    let url = 'api/user/keepSession'
    let params = new URLSearchParams()
    this.$http.post(url, params).then((res) => {
      if (res.data.status === 200) {
        this.$global.userId = res.data.data.user_id
        this.$global.userName = res.data.data.user_name
        this.$global.isLogined = true
        this.$global.roleId = res.data.data.role_id
        this.$global.userAvater = res.data.data.user_avatar
        this.$global.userIntroduction = res.data.data.user_introduction
        this.$global.rank = res.data.data.rank
        this.$router.push('/')
      }
    })
  },
}
</script>

<!-- <style src="./style.css">
</style> -->
<style scoped>
</style>