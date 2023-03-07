<template>
  <div class="user-home">

    <div class="left-main">

      <div class="search-bar">
        <el-input type="textarea"
                  :rows="1"
                  placeholder="请输入你要搜索的用户名"
                  v-model="search_content">
        </el-input>
        <el-button @click="getUserList()">搜索</el-button>
      </div>

      <div v-for="author, index of userList">
        <author-card class="title-card"
                     :imageUrl="author.avatar"
                     :title="author.username"
                     :subtitle="author.introduction"
                     :user_rank="author.rank"
                     :role_id="get_role(author.roleId)"
                     :user_id="author.id"
                     :state="author.state"></author-card>
      </div>
    </div>

  </div>

</template>
<script>
import AuthorCard from './AuthorCard.vue'

export default {
  name: 'UserList',
  data() {
    return {
      userList: [
        {
          //         "id": "1",
          //   "username": "123",
          //   "password": null,
          //   "email": "guoyunhe1@outlook.com",
          //   "avatar": "http://117.50.179.215:8070/images/2022/11/13/R15.jpg",
          //   "introduction": "fsdffdsfsfsdfsfsda",
          //   "rank": "114",
          //   "roleId": 3,
          //   "state": 0
        },
      ],
      search_content: '',
    }
  },
  methods: {
    getUserList() {
      let params = new URLSearchParams()
      let url = '/api/user/getUserList'
      params.append('username', this.search_content)
      this.$http.get(url, { params: params }).then(
        //成功
        (res) => {
          // console.log(res);
          console.log('success')
          this.userList = res.data.data
        },
        //失败
        (err) => {
          console.log('error')
          console.log(err)
        }
      )
    },
    get_role(data) {
      if (data == 3) {
        return '管理员'
      } else if (data == 2) {
        return '艺术家'
      } else if (data == 1) {
        return '普通用户'
      } else {
        return '未知'
      }
    },
  },
  mounted() {
    this.getUserList()
  },
  components: {
    AuthorCard,
  },
}
</script>
<style scoped>
.user-home {
  margin: auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 80%;
  margin-top: 10px;
}
.left-main {
  width: 70%;
  margin: auto;
}
.search-bar {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>