<template>

  <body>
    <div class="homepage">
      <!--首页A-->
      <div class="box1"
           div
           v-if="type == 'A'">
        <h1>剪纸艺术家介绍</h1>
        <div class="row">
          <router-link to="/artist/fuzuoren">
            <span class="leftred">
              <div class="fuzuoren">傅作仁</div>
            </span>
          </router-link>

          <router-link to="/artist/gupengquan">
            <span class="rightred">
              <div class="gupengquan">顾朋泉</div>
            </span>
          </router-link>

        </div>
        <div class="column">

          <router-link to="/artist/duanyunli">
            <span class="topyellow">
              <div class="duanyunli"> 段云丽夫妇</div>
            </span>
          </router-link>

          <router-link to="/artist/chenfenwan">
            <span class="bottomyellow">
              <div class="chenfenwan">陈粉丸</div>
            </span>
          </router-link>

        </div>

      </div>

      <!--最下面的横线（只有首页才显示-->
      <div class="bottomline"
           v-show='type === "A"'>
        <img src="http://117.50.179.215:8070/images/2022/11/04/357c7d0f55a0f6b5be3db6a5c49c9c89.png"
             alt="357c7d0f55a0f6b5be3db6a5c49c9c89.png"
             width="20000"
             height="20" />
      </div>
    </div>
  </body>

</template>
  
<script>
export default {
  data() {
    return {
      type: 'A',
    }
  },
}
</script>
     
<style scoped>
.box1 {
  position: absolute;
  width: 80vw;

  top: 50px;
  bottom: 100px;
  left: 5vw;
  right: 10vw;
}

.span {
  position: absolute;
  width: 200;
  height: 200;
}
h1 {
  width: 1em;
  font-size: 60px;
  letter-spacing: 60px;
  user-select: none;
  color: white;
  text-shadow: 0px 0px 20px rgb(142, 62, 29), 0px 0px 10px orange,
    0px 0px 10px orangered, 0px 0px 10px orange;
}

.row {
  position: absolute;
  display: flex;
  flex-direction: row;
  left: 350px;
  top: 200px;
  height: 200px;
  width: 600px;
  justify-content: space-between;
}

.column {
  position: absolute;
  display: flex;
  flex-direction: column;
  top: 0px;
  left: 550px;
  height: 600px;
  width: 200px;
  justify-content: space-between;
}
.topyellow {
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  top: 0;
  left: 0;
  width: 200px;
  height: 200px;
  background-color: #c7aa6c;
}

.topyellow:hover {
  transform: scale(0.9);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  transition: all 0.5s;
}

.bottomyellow {
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  bottom: 0;
  left: 0;
  width: 200px;
  height: 200px;
  background-color: #c7aa6c;
}

.bottomyellow:hover {
  transform: scale(0.9);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  transition: all 0.5s;
}

.leftred {
  display: flex;
  flex: 0 0 200px;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  width: 200px;
  height: 200px;
  left: 300px;
  top: 250px;
  background-color: #d0574e;
}

.leftred:hover {
  transform: scale(0.9);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  transition: all 0.5s;
}

.rightred {
  display: flex;
  flex: 0 0 200px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 200px;
  left: 700px;
  top: 250px;
  background-color: #d0574e;
}

.rightred:hover {
  /* background-color: #d0574e; */
  transform: scale(0.9);
  border-radius: 25px;
  box-shadow: 0 12px 16px 0 rgba(0, 0, 0, 0.24),
    0 17px 50px 0 rgba(0, 0, 0, 0.19);
  transition: all 0.5s;
}

.duanyunli {
  font-size: 40px;
  color: white;
}

.chenfenwan {
  font-size: 40px;
  color: white;
}

.fuzuoren {
  flex: 0 0 auto;
  color: white;
  font-size: 40px;
}

.gupengquan {
  flex: 0 0 auto;
  color: white;
  font-size: 40px;
}

.bottomline {
  position: absolute;
  bottom: 2vh;
}
</style>