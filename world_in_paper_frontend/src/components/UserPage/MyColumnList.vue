<template>
  <div class="column-list">
    <h2 class="none"
        ref="none">无</h2>
    <el-row class="row">
      <el-col v-for="(o, index) in columns"
              :key="o.id"
              :span="6">
        <el-card :body-style="{ padding: '0px' }"
                 class="card">
          <img :src="o.cover_img"
               class="image" />
          <div>
            <h2>{{o.title}}</h2>
            <div class="bottom">
              <span>{{o.column_favor_count}}点赞</span>
              <span>{{o.column_art_count}}文章</span>
              <div>
                <el-button type="default"
                           plain
                           class="button"
                           @click="handleOpenColumn(o.id)">进入</el-button>
                <el-button type="danger"
                           bg
                           class="button"
                           @click="handleDeleteColumn(o.id)">删除</el-button>
              </div>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>

</template>
  
  <script>
export default {
  name: 'MyColumnList',
  data() {
    return {
      currentDate: new Date(),
      columns: [],
    }
  },
  methods: {
    getColumns() {
      let params = new URLSearchParams()
      let url = 'api/column/getColumnByUserId'
      params.append('keyUserId', this.$global.userId)
      this.$http.get(url, { params: params }).then((res) => {
        console.log(res)
        this.columns = res.data.data
        if (this.columns.length === 0) {
          this.$refs.none.style.display = 'block'
        }
      }),
        (error) => {
          console.log(error)
          if (this.columns.length === 0) {
            this.$refs.none.style.display = 'block'
          }
        }
    },
    handleOpenColumn(id) {
      this.$router.push('/column/columnHome/' + id)
    },
    handleDeleteColumn(id) {
      ElMessageBox.confirm('此操作将永久删除该专栏, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).then(() => {
        let params = new URLSearchParams()
        let url = 'api/column/deleteColumn'
        params.append('id', id)
        this.$http.post(url, params).then((res) => {
          if (res.data.status === 200) {
            ElNotification.success({
              title: '删除成功',
              duration: 2000,
            })
            this.getColumns()
          } else {
            ElNotification.error({
              title: '删除失败',
              message: res.data.message,
              duration: 2000,
            })
          }
        }),
          (error) => {
            alert(error)
          }
      })
    },
  },
  mounted() {
    this.getColumns()
  },
}
</script>
  
<style scoped>
.none {
  height: 400px;
  margin-left: 20px;
  display: none;
}

:deep(.row) {
  width: 100%;
  margin: 30px auto;
}

:deep(.card) {
  padding: 5px;
  width: 90%;
  margin: 20px;
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
</style>
