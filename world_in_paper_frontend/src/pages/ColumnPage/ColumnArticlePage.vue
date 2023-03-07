<template>
  <div class="column-article-page">
    <div class="cover-image"
         v-if="coverUrl">
      <img :src="coverUrl"
           alt="cover" />
    </div>
    <h1>{{title}}</h1>
    <user-card :user-info="user"></user-card>
    <div v-html="articleContent"
         class="article-area"></div>
    <!-- <article-tool-bar></article-tool-bar> -->
    <comment-card class="comment-card"
                  :articleId=this.$route.params.id></comment-card>
  </div>
</template>

<script>
import CommentCard from '../../components/ColumnPage/CommentCard.vue'
export default {
  name: 'ColumnArticlePage',
  components: {
    CommentCard,
  },
  data() {
    return {
      title: '',
      articleContent: '',
      user: {},
      coverUrl: '',
    }
  },
  methods: {
    getArticle() {
      let url = 'api/article/getArticle'
      let params = new URLSearchParams()
      params.append('articleId', this.$route.params.id)
      this.$http.get(url, { params: params }).then((res) => {
        console.log(res.data.data)
        this.user = res.data.data.creator
        this.title = res.data.data.title
        this.coverUrl = res.data.data.cover_img
        this.articleContent = res.data.data.content
      })
    },
  },
  mounted() {
    this.getArticle()
  },
}
</script>

<style scoped>
.column-article-page {
  width: 1000px;
  margin: 0 auto;
}

.article-area {
  font-family: sans-serif;
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  background-color: #fefbf4;
  border-radius: 5px;
}

.cover-image img {
  width: 100%;
  height: 300px;
  object-fit: cover;
}
</style>