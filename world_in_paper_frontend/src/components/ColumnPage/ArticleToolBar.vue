<template>
  <div class="acticle-tool-bar">
    <el-button :class="['thumbup-button',thumbed?'thumbed':'']"
               @click="handleThumbup">
      <i :class="['iconfont',thumbed?'icon-dianzan1':'icon-dianzan']"></i>
      <span>{{thumbed?'已':''}}点赞 {{article.thumbs_count}}</span>
    </el-button>
    <el-button class="other-button">
      <i class="iconfont icon-pinglun"></i>
      <span>评论 {{article.comment_count}}</span>
    </el-button>
    <!-- <el-button :class="['other-button',favored?'favored':'']"
               @click="handleFavor">
      <i :class="['iconfont', favored?'icon-shoucang1':'icon-shoucang']"></i>
      <span>{{favored?'已':''}}收藏</span>
    </el-button> -->
  </div>
</template>

<script>
export default {
  name: 'ColumnArticlePage',
  props: {
    article: {
      type: Object,
      default: 0,
    },
  },
  data() {
    return {
      likeNum: 0,
      commentNum: 0,
      thumbed: false,
      favored: false,
    }
  },
  methods: {
    handleThumbup() {
        let url = 'api/article/thumbUpArticle'
        let params = new URLSearchParams()
        params.append('articleId', this.article.id)
        params.append('userId', this.$global.userId)
        this.$http.post(url, params).then((res) => {
          if (res.data.status === 200) {
            this.thumbed = !this.thumbed
            if (this.thumbed) {
              this.article.thumbs_count += 1
            } else {
              this.article.thumbs_count -= 1
            }
          }
        })
    }
  },
  mounted() {
    this.thumbed = this.article.is_thumb
  },
}
</script>

<style src="../../assets/iconfont/column/iconfont.css" scoped></style>

<style scoped>
.acticle-tool-bar {
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 0 20px;
  background-color: transparent;
  border-radius: 4px;
  font-family: 'sans-serif';
  margin: 15px;
}

.acticle-tool-bar:deep(.el-button) {
  border: 0;
  font-size: 15px;
}

.thumbup-button {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40px;
  border-radius: 4px;
  border: 0;
  background-color: #fdd9d6;
  color: #ac2d23;
  font-size: 14px;
  cursor: pointer;
}

.thumbup-button:hover,
.thumbup-button.thumbed {
  background-color: #ac2d23;
  color: #fff;
}

.other-button {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40px;
  border-radius: 4px;
  border: 0;
  background-color: transparent;
  color: #999;
  font-size: 14px;
  cursor: pointer;
}

.other-button:hover {
  color: #ac2d23;
}

.other-button.favored {
  color: #ac2d23;
}

:deep(.iconfont) {
  margin-right: 5px;
}
</style>