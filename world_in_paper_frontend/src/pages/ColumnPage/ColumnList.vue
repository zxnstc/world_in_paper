<template>
  <div class="column-list">
    <div class="title">所有专栏</div>
    <transition-group name="animate__animated animate__bounce"
                      tag="div"
                      class="row el-row "
                      :appear="true">
      <div v-for="(o, index) in columns"
           :key="o.id"
           class="el-col el-col-6 animate__fadeInDown"
           :style="{'animation-delay':(index * 200)+'ms'}">
        <el-card :body-style="{ padding: '0px' }"
                 class="card">
          <img :src="o.cover_img"
               class="image" />
          <div>
            <h2>{{o.title}}</h2>
            <div class="bottom">
              <span>{{o.column_favor_count}}关注</span>
              <span>{{o.column_art_count}}文章</span>
              <div>
                <el-button primary
                           bg
                           class="button"
                           @click="handleEnterColumn(o.id)">进入</el-button>
                <el-button type="danger"
                           bg
                           class="button"
                           v-if="'3'===$global.roleId"
                           @click="handleDeleteColumn(o.id)">删除</el-button>
              </div>

            </div>
          </div>
        </el-card>
      </div>
    </transition-group>
  </div>

</template>

<script>
import 'animate.css'
export default {
  name: 'ColumnList',
  data() {
    return {
      currentDate: new Date(),
      columns: [],
    }
  },
  methods: {
    getColumns() {
      let url = 'api/column/getAllColumns'
      let params = new URLSearchParams()
      params.append('userId', this.$global.userId + '')
      //   console.log(this.$global.userId+'')
      this.$http.get(url, { params: params }).then((res) => {
        console.log(res)
        this.columns = res.data.data
      })
    },
    handleEnterColumn(id) {
      this.$router.push({ path: '/column/columnHome/' + id })
    },
  },
  mounted() {
    this.getColumns()
  },
}
</script>

<style scoped>
:deep(.row) {
  min-height: 500px;
  width: 1200px;
  margin: 30px auto;
}

:deep(.card) {
  padding: 5px;
  margin: 30px;
  font-family: 'sans-serif';
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

:deep(.button) {
  padding: 0;
  min-height: auto;
  width: 50px;
}

.image {
  width: 100%;
  height: 200px;
  object-fit: cover;
  display: block;
}

.title {
  text-align: center;
  font-size: 40px;
  height: 150px;
  width: 300px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url(/image/ColumnPage/bk.png);
  background-size: 100% 100%;
  background-repeat: no-repeat;
  background-position: center;
}

:deep(.fade-enter-active),
:deep(.fade-leave-active) {
  transition: opacity 0.5s;
}

:deep(.fade-enter),
:deep(.fade-leave-to) {
  opacity: 0;
}

:deep(.fade-enter-to),
:deep(.fade-leave) {
  opacity: 1;
}
</style>
