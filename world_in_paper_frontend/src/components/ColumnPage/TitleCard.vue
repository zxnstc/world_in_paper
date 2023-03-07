<template>
  <div class="title-card">
    <div class="side-area">
      <el-image :src="imageUrl"
                alt="专栏图片"
                class="title-image" />
      <el-button @click="favor"
                 class="subscribe-button"
                 :class="{'active':subscribe}">{{subscribe?'取消':''}}关注{{ subscribe?'':'专栏'}}</el-button>
    </div>
    <div class="main-area">
      <h2>{{ title }}</h2>
      <p>{{ subtitle }}</p>
    </div>
  </div>

</template>

<script>
export default {
  name: 'TitleCard',
  props: {
    title: {
      type: String,
      required: true,
    },
    subtitle: {
      type: String,
      required: true,
    },
    imageUrl: {
      type: String,
      required: true,
    },
    subscribe: {
      type: Boolean,
      required: true,
    },
  },
  methods: {
    favor() {
      if (!this.subscribe) {
        console.log('关注')
        let params = new URLSearchParams()
        let url = '/api/column/favorColumn'
        params.append('columnId', this.$route.params.id)
        params.append('userId', this.$global.userId)

        this.$http.post(url, params).then((res) => {
          if (res.data.status === 200) {
            this.$emit('getColumnInfo')
          }
        })
      } else {
        console.log('取消关注')
        let params = new URLSearchParams()
        let url = '/api/column/notFavorColumn'
        params.append('columnId', this.$route.params.id)
        params.append('userId', this.$global.userId)

        this.$http.post(url, params).then((res) => {
          if (res.data.status === 200) {
            this.$emit('getColumnInfo')
          }
        })
      }
    },
  },
}
</script>

<style scoped>
.title-card {
  display: flex;
  padding: 20px;
  background-color: #fefbf4;
  border-radius: 4px;
  border: #dddddd 1px solid;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';
}

.side-area {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.title-image {
  min-width: 100px;
  height: 100px;
  margin-bottom: 30px;
}

.main-area {
  padding-left: 20px;
}

.main-area h2 {
  font-size: 20px;
  font-weight: 700;
  margin-top: 0;
  margin-bottom: 15px;
}

.main-area p {
  font-size: 14px;
  color: #999;
  margin: 0;
}

.subscribe-button {
  width: 100px;
  height: 30px;
  background-color: #ac2d23;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  font-weight: 700;
}

.subscribe-button:hover {
  background-color: #d2544b;
  color: #fff;
}

.subscribe-button.active {
  background-color: #fefbf4;
  color: #a93434;
  border: #ac2d23 2px solid;
}
</style>