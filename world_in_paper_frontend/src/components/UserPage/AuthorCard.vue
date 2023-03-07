<template>
  <div class="title-card">
    <div class="side-area">
      <img :src="imageUrl" alt="user_avatar" class="title-image">
      <operate-user :user_id="user_id"
                    :user_state="state"
                    :role_id="role_id"></operate-user>

      


    </div>
    <div class="main-area">
      <div class="author-name">
        <span>{{ title }}</span>
        <el-button size="small" class="level-button">Lv.{{ user_rank }}</el-button>
        <el-button size="small" class="role-button">{{ role_id }}</el-button>
      </div>
      <div class="author-introduction">
        <p>个性签名：{{ subtitle }}</p>
      </div>
    </div>


  </div>


</template>

<script>
import OperateUser from './OperateUser.vue';
export default {
  name: 'AuthorCard',
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
    user_rank: {
      type: String,
      required: true,
    },
    role_id: {
      type: String,
      required: true,
    },
    user_id: {
      type: String,
      required: true,
    },
    state: {
      type: String,
      required: true,
    },
  },
  components: {
    OperateUser,
  },

}
</script>

<style scoped>
.title-card {
  display: flex;
  padding: 20px;
  background-color: #fff;
  border-radius: 4px;
  border: #dddddd 1px solid;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.05);
  font-family: 'sans-serif';

}

.side-area {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  flex: none;
}

.title-image {
  width: 120px;
  height: 120px;

}

.main-area {
  padding-left: 20px;
}

.author-name {
  display: flex;
}

.author-name span {
  font-size: 23px;
  font-weight: 700;
  margin-top: 0;
  margin-bottom: 15px;
  margin-right: 15px;

}

.author-introduction p {
  font-size: 14px;
  color: #999;
  margin: 0;

}

.level-button {

  background-color: #b791ae;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 10px;
  font-weight: 700;
  margin-top: 0;

}

.role-button {
  background-color: #a9c7e0;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 10px;
  font-weight: 700;
  margin-top: 0;
  margin-left: 10px;
}

.right-area {
  align-self: flex-end
}


</style>