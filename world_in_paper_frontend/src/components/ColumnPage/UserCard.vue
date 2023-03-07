<template>
  <div class="user-card">
    <div class="user-part">
      <img :src="userInfo.avatar"
           alt="用户头像"
           class="user-avatar" />
    </div>

    <div class="main-area">
      <h2>{{userInfo.username}}</h2>
      <p>{{userInfo.introduction}}</p>
    </div>

    <!-- <div class="follow">
      <el-button class="subscribe-user">关注用户</el-button>
    </div> -->

  </div>
</template>
  
  <script>
export default {
  name: 'UserCard',
  props: {
    userInfo: {
      type: Object,
    },
  },
  data() {
    return {
      title: '',
      subtitle: '',
      avatarUrl: 'http://117.50.179.215:8056/123.jpg',
    }
  },
}
</script>
  
<style scoped>
.user-card {
  display: flex;
  /* justify-content: space-between; */
  /* padding: 20px; */
  background-color: #fefbf4;
  border-radius: 4px;
  border-bottom: #dddddd 1px solid;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';
  width: 100%;
  height: 60px;
  padding: 0 10px;
}

.user-part {
  display: flex;
  align-items: center;
}

.user-avatar {
  width: 50px;
  height: 50px;
  /* margin-bottom: 30px; */
  /* 圆角 */
  border-radius: 10%;
}

.main-area {
  padding-left: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.main-area h2 {
  font-size: 16px;
  font-weight: 700;
  margin: 0;
}

.main-area p {
  font-size: 14px;
  color: #999;
  margin: 0;
}
.follow {
  margin-left: auto;
  display: flex;
  align-items: center;
  justify-content: center;
}

.subscribe-user {
  width: 100px;
  height: 30px;
  background-color: rgba(255, 100, 76, 1);
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 14px;
  font-weight: 700;
  margin-right: 20px;
}
</style>