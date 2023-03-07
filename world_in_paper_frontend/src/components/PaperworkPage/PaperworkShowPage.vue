<template>
  <div class="PaperworkPage"
       ref="paperWorkBack">

    <div class="el-row">
      <transition-group name="animate__animated animate__bounce"
                        appear>
        <div :span="8"
             v-for="(work, index) in result"
             :key="work.id"
             class="animate__fadeInDown el-col el-col-8">
          <div class="work"
               @click="handleShowWork(work.id)">
            <el-image :src="work.img_url"
                      class="workImg">
              <template #placeholder>
                加载中。。。。。
              </template>
            </el-image>
            <div class="workInfo">
              <div class="workTitle">{{work.title}}</div>
              <div class="workDate">{{work.create_time}}</div>
            </div>
          </div>
        </div>
      </transition-group>
    </div>

  </div>

</template>

<script>
import PaperworkShow from './PaperworkShow.vue'
export default {
  components: { PaperworkShow },
  name: 'PaperworkPage',
  data() {
    return {
      index: 0,
      result: [],
      currentPage: 1,
      count: 0,
      totalCount: 0,
    }
  },
  methods: {
    getPaperwork(size) {
      let params = new URLSearchParams()
      let url = 'api/paperwork/getPaperwork'
      params.append('currentPage', this.currentPage)
      params.append('pageSize', 10000)
      this.$http.get(url, { params: params }).then((res) => {
        this.totalCount = res.data.data.length
        this.getPaperworkInner(size)
      })
    },
    getPaperworkInner(size) {
      let params = new URLSearchParams()
      let url = 'api/paperwork/getPaperwork'
      params.append('currentPage', this.currentPage)
      params.append('pageSize', size)
      this.$http.get(url, { params: params }).then((res) => {
        this.result.push(...res.data.data)
        this.count += res.data.data.length
        if (this.count < this.totalCount) {
          this.currentPage++
          setTimeout(() => {
            this.getPaperwork(size)
          }, 100)
        }
      })
    },

    handleShowWork(id) {
      console.log(id)
      this.$router.push('/paperworkview/' + id)
    },
  },
  mounted() {
    this.getPaperwork(3)
  },
}

// 定时器
</script>

<style scoped>
.el-row {
  min-width: 100%;
}

.PaperworkPage {
  min-height: calc(100vh - 56px);
  min-width: 100%;
  width: 100%;
  background: url('/image/bg1.jpg') center 0 no-repeat;
  background-size: 100% 110%;
  background-attachment: fixed;
  /* animation: switch 15s infinite; */
}

@keyframes switch {
  25% {
    background-image: url('/image/bg2.jpg');
  }
  50% {
    background-image: url('/image/bg3.jpg');
  }
  75% {
    background-image: url('/image/bg4.jpg');
  }
  100% {
    background-image: url('/image/bg1.jpg');
  }
}

.work {
  width: 400px;
  height: 300px;
  padding-top: 30px;
  overflow: hidden;
  background-color: rgba(0, 0, 0, 0.8);
  color: white;
  margin: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.work:hover {
  cursor: pointer;
  box-shadow: 0 0 10px rgb(144, 44, 44);
}

.workImg {
  height: 60%;
  cursor: pointer;
}

.workImg:hover {
  transform: scale(1.1);
  transition: all 0.5s;
}

.workInfo {
  height: 40%;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.workTitle {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}

.workAuthor {
  font-size: 16px;
  margin-bottom: 10px;
}

.workDate {
  font-size: 16px;
}

:deep(.el-carousel .el-carousel--vertical) {
  flex: 1;
}
</style>