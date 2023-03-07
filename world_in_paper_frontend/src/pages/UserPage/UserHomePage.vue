<template>

  <el-container class="homepage">
    <el-aside class="menu">
      <Menu @changeIndex="changeIndex"></Menu>
    </el-aside>
    <el-main>
      <div class="myHomePage"
           v-if="this.activeIndex ==='1'">
        <MyHomePage></MyHomePage>
      </div>
      <div class="updateUserInformation"
           v-if="this.activeIndex ==='2'">
        <UpdateUserInfoPage></UpdateUserInfoPage>
      </div>
      <div class="userList"
           v-if="this.activeIndex ==='3'">
        <UserList></UserList>
      </div>
      <div class="createColumn"
           v-if="this.activeIndex ==='4'">
        <add-column-page></add-column-page>
      </div>
      <div class="uploadPaperwork"
           v-if="this.activeIndex ==='5'">
        <upload-paperwork-page></upload-paperwork-page>
      </div>
    </el-main>

  </el-container>

</template>
  
  <script>
import AddColumnPage from '../../components/UserPage/AddColumnPage.vue'
import Menu from '../../components/UserPage/Menu.vue'
import MyHomePage from '../../components/UserPage/MyHomePage.vue'
import UpdateUserInfoPage from '../../components/UserPage/UpdateUserInfoPage.vue'
import UserList from '../../components/UserPage/UserList.vue'
import UploadPaperworkPage from '../../components/UserPage/UploadPaperworkPage.vue'
export default {
  name: 'UserHomePage',
  components: {
    Menu,
    MyHomePage,
    UpdateUserInfoPage,
    UserList,
    AddColumnPage,
    UploadPaperworkPage,
  },
  data() {
    return {
      activeIndex: '1',
    }
  },
  methods: {
    changeIndex(index) {
      this.activeIndex = index
      console.log(this.activeIndex)
    },
  },
}
</script>
     
<style scoped>
:deep(.el-aside) {
  width: 200px;
}
.homepage {
  /* 禁用滚动条 */
  overflow: hidden;
  margin-top: 0px;
  height: calc(100vh - 56px);
}
.menu {
  text-align: center;
}
.myHomePage {
  margin-top: 0px;
  width: 100%;
  height: 100%;
}
</style>