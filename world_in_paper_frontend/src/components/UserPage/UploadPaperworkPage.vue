<template>
  <div class="add-paperwork-page">
    <div class="title-with-button">
      <h2>我的剪纸作品</h2>
      <el-button type="primary"
                 @click="uploadPaperwork">上传剪纸作品</el-button>
    </div>
    <div class="content">
      <!-- 显示属于自己的剪纸作品的表格 -->
      <el-table :data="paperworkList"
                table-layout="auto">
        <el-table-column prop="id"
                         label="剪纸作品ID"
                         width="180">
        </el-table-column>
        <el-table-column prop="title"
                         label="剪纸作品名称"
                         width="180">
        </el-table-column>
        <el-table-column prop="content"
                         label="剪纸作品描述"
                         width="180">
        </el-table-column>
        <el-table-column prop="paperwork_cover"
                         label="剪纸作品"
                         width="180">
          <template #default="scope">
            <img :src="scope.row.img_url"
                 style="width: 100px; height: 100px;">
          </template>
        </el-table-column>
        <el-table-column>
          <template #default="scope">
            <el-button type="danger"
                       size="mini"
                       @click="deletePaperwork(scope.row.id)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <upload-paperwork ref="uploadPaperwork"
                      @upload-paperwork="getPaperworkList"></upload-paperwork>
  </div>
</template>

<script>
import UploadPaperwork from './UploadPaperwork.vue'
export default {
  name: 'UploadPaperworkPage',
  components: {
    UploadPaperwork,
  },
  data() {
    return {
      paperworkList: [],
    }
  },
  methods: {
    uploadPaperwork() {
      this.$refs.uploadPaperwork.init()
    },
    getPaperworkList() {
      let url = 'api/paperwork/getPaperworkByAuthorId'
      let params = new URLSearchParams()
      params.append('id', this.$global.userId)
      this.$http
        .get(url, { params })
        .then((res) => {
          this.paperworkList = res.data.data
        })
        .catch((err) => {
          console.log(err)
        })
    },
    deletePaperwork(id) {
      ElMessageBox.confirm('此操作将永久删除该剪纸作品, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let url = 'api/paperwork/deletePaperworkById'
          let params = new URLSearchParams()
          params.append('id', id)
          this.$http
            .delete(url, { params })
            .then((res) => {
              this.getPaperworkList()
              ElMessage({
                type: 'success',
                message: '删除成功!',
              })
            })
            .catch((err) => {
              console.log(err)
            })
        })
        .catch(() => {
          ElMessage({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
  },
  mounted() {
    this.getPaperworkList()
  },
}
</script>

<style scoped>
.add-paperwork-page {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.title-with-button {
  width: 100%;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 20px;
}

.content {
  height: 100%;
  padding: 0 20px;
}
</style>