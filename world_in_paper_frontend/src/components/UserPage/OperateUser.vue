<template>
  <el-form-item class="operate-buttons">

    <el-button v-if="user_state == '0'" @click="disableUser()" round :disabled="ban" size="small"
      type="danger" class="disable-button">禁用
    </el-button>
    <el-button v-if="user_state == '1'" @click="enableUser()" round  :disabled="unban" size="small"
      type="success" class="disable-button">解禁
    </el-button>

   
    <el-button  @click="centerDialogVisible = true"
                round size="small" type="warning" class="update-button">修改权限
    </el-button>

    <el-dialog v-model="centerDialogVisible" title="Warning" width="30%" center>
      <span>
        目前该用户为{{ role_id }}，
        请选择要授予该用户的权限：
      </span>
      <el-checkbox-group v-model="checkedCities" :min="0" :max="1">
        <el-checkbox  :disabled="this.role_id=='普通用户'" label="普通用户"/>
        <el-checkbox  :disabled="this.role_id=='艺术家'" label="艺术家"/>
        <el-checkbox  :disabled="this.role_id=='管理员'" label="管理员"/>
        

  </el-checkbox-group>

      <template #footer>
        <span class="dialog-footer">
          <el-button @click="centerDialogVisible = false">Cancel</el-button>
          <el-button type="primary" @click="updateRoleId">
            Confirm
          </el-button>
        </span>
      </template>
    </el-dialog>

  </el-form-item>
  <el-popover
    placement="bottom"
    title="标题"
    width="200"
    trigger="click"
    content="这是一段内容,这是一段内容,这是一段内容,这是一段内容。">
    <el-button slot="reference">click 激活</el-button>
  </el-popover>



</template>
<script>
export default {
  name: 'OperateUser',
  props: {
    user_id: {
      type: String,
      required: true,
    },
    user_state: {
      type: String,
      required: true,
    },
    role_id: {
      type: String,
      required: true,
    },
  },

  data() {
    return {
      ban: false,
      unban: false,
      centerDialogVisible: false,
      checkedCities: [],
      

    }

  },

  methods: {
    get_role(){
        if(this.checkedCities[0]=="管理员"){
            return '3';
        }
        else if(this.checkedCities[0]=="艺术家"){
            return '2';
        }
        else if(this.checkedCities[0]=="普通用户"){
            return '1';
        }
    },
    updateRoleId(){
      this.centerDialogVisible = false;
      let params = new URLSearchParams()
      let url = '/api/user/updateUserRole'
      params.append('id', this.user_id)
      params.append('roleId', this.get_role())
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: res.data.message,
            type: 'success',
          })
          
        } else {
          ElMessage({
            message: res.data.message,
            type: 'error',
          })
        }
      })
      this.checkedCities= []
    },
    disableUser() {
      let params = new URLSearchParams()
      let url = '/api/user/disableUser'
      params.append('id', this.user_id)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: res.data.message,
            type: 'success',
          })
          this.ban = true
          this.unban = false

        } else {
          ElMessage({
            message: res.data.message,
            type: 'error',
          })
        }
      })
    },
    enableUser() {
      let params = new URLSearchParams()
      let url = '/api/user/enableUser'
      params.append('id', this.user_id)
      this.$http.post(url, params).then((res) => {
        if (res.data.status === 200) {
          ElMessage({
            message: res.data.message,
            type: 'success',
          })
          this.unban = true
          this.ban = false

        } else {
          ElMessage({
            message: res.data.message,
            type: 'error',
          })
        }
      })
    },
  }

}
</script>
<style scoped>
.operate-buttons {
  margin-top: 15px;
  margin-bottom: 0px;
}
.dialog-footer button:first-child {
    margin-right: 10px;
  }
</style>