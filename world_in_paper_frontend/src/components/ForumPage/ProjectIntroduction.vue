<template>
  <div class="intro">
    <el-row class="about_nsbbs_img">
      <img src="/image/forumview/home_img.png"
           style="width: 100%;">
    </el-row>

    <el-row>
      <el-col :span="24"
              style="position: relative; top: -25px; text-align: center">
        <el-avatar :size="80"
                   src="logo.png" />
      </el-col>
      <el-col :span="24"
              style="text-align: center">
        <div style="line-height: 28px; padding: 0 5px 5px 5px;">
          欢迎来到纸间万象的论坛，淡泊明志，宁静致远。珍惜原创，矢志不渝。
        </div>
      </el-col>
      <el-divider style="font-size: 12px;">
        <p>统计数据</p>
      </el-divider>
      <el-col :span="24"
              style="text-align: center">
        <el-row>
          <el-col :span="8">
            <p>文章</p>
            <el-badge :value="articletotal"
                      :max="9999"
                      type="primary">
            </el-badge>
          </el-col>
          <el-col :span="8">
            <p>评论</p>
            <el-badge :value="all_comment_count"
                      :max="9999"
                      type="primary">
            </el-badge>
          </el-col>
          <el-col :span="8">
            <p>访客</p>
            <el-badge :value="all_visit_count"
                      :max="9999"
                      type="primary">
            </el-badge>
          </el-col>

        </el-row>

      </el-col>

    </el-row>
  </div>

</template>

<script>
import { onMounted } from 'vue'

export default {
  name: 'ProjectIntroduction',
  props: ['articletotal'],
  data() {
    return {
      all_comment_count: 0,
      all_visit_count: 0,
    }
  },
  methods: {
    getCommentCount() {
      let params = new URLSearchParams()
      let url = '/api/forum/getCommentCount'
      this.$http.get(url).then(
        //成功
        (res) => {
          this.all_comment_count = res.data.data.all_comment_count
          console.log('all comments:' + this.all_comment_count)
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
        }
      )
    },
    getVisitCount() {
      let params = new URLSearchParams()
      let url = '/api/forum/getVisitCount'
      this.$http.get(url).then(
        //成功
        (res) => {
          this.all_visit_count = res.data.data.all_visit_count
          console.log('all_visit_count:' + this.all_visit_count)
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
        }
      )
    },
  },
  mounted() {
    this.getCommentCount()
    this.getVisitCount()
  },
}
</script>

<style scoped>
.about_nsbbs_img:after {
  position: absolute;
  content: '';
  width: 100%;
  height: 157px;
  top: 0;
  left: 0;
  box-shadow: 0 -25px 35px 10px #ffffff inset;
}
</style>
  
