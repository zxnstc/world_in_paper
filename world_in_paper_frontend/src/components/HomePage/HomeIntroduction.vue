<template>
  <div>
    <transition name="animate__animated animate__bounce animate__slow"
                appear
                enter-active-class="animate__fadeInLeftBig">
      <div class="leftbox">
        <!--左侧标题-->
        <div class="title1">剪纸的历史</div>
        <div class="title2">与技巧介绍</div>
        <!--左侧图案-->
        <div class="pattern">
          <img src="/image/view/pattern_round/pattern.png"
               width="200px" />
        </div>
      </div>
    </transition>

    <transition-group name="animate__animated animate__bounce animate__slow"
                      appear
                      enter-active-class="animate__fadeInLeftBig">
      <!--左侧下方拼音-->
      <div class="line1"
           key="1">JIANZHIDELISHI</div>
      <div class="line2"
           key="2">YUJIQIAO</div>
    </transition-group>
    <div class="rightbox">
      <!--上面一排-->
      <div class="rightbox1">
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInTopLeft">
          <div class="square1">
            <div class="span1">
              <img class="pic1"
                   src="/image/view/pattern_round/icon1.png"
                   width="70" />
              <router-link to="history">
                <div class="cha1">各地剪纸的<br />发展历史</div>
              </router-link>
              <div class="eng1">JIANZHILISHI</div>
            </div>
          </div>
        </transition>
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInDown">
          <div class="square2">
            <div class="span1">
              <img class="pic1"
                   src="/image/view/pattern_round/icon2.png"
                   width="70" />
              <router-link to="artist">
                <div class="cha2">剪纸艺术家介绍</div>
              </router-link>
              <div class="eng2">JIANZHIYISHU<br />JIAJIESHAO</div>
            </div>
          </div>
        </transition>
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInTopRight">
          <div class="square1">
            <div class="span1">
              <img class="pic1"
                   src="/image/view/pattern_round/icon3.png"
                   width="70" />
              <router-link to="course">
                <div class="cha1">剪纸的教程</div>

              </router-link>
              <div class="eng1">JIANZHIDE<br />JIAOCHENG</div>
            </div>
          </div>
        </transition>
      </div>

      <!--下面一排-->

      <div class="rightbox2">
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInBottomLeft">
          <div class="square2">
            <span class="span1">
              <img class="pic1"
                   src="/image/view/pattern_round/icon4.png"
                   width="70" />
              <router-link to="tech">
                <div class="cha2">剪纸的技巧</div>
              </router-link>
              <div class="eng2">JIANZHIDE<br />JIQIAO</div>
            </span>
          </div>
        </transition>
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInUp">
          <div class="square1">
            <div class="span1">
              <img class="pic1"
                   src="/image/view/pattern_round/icon5.png"
                   width="70" />
              <router-link to="/paperwork">
                <div class="cha1">著名剪纸作品</div>
              </router-link>
              <div class="eng1">ZHUMINGJIAN<br />ZHIZUOPIN</div>
            </div>
          </div>
        </transition>
        <transition name="animate__animated animate__bounce animate__slow"
                    appear
                    enter-active-class="animate__fadeInBottomRight">
          <div class="square3">
            <span class="span1"> </span>
          </div>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'HomeIntroduction',
}
</script>

<style scoped>
.rightbox {
  display: flex;
  position: absolute;
  left: 30vw;
  top: 10vh;
  justify-content: space-around;
  flex-direction: column;
  /* border: 15px solid red; */
  height: 620px;
}

.rightbox1 {
  display: flex;
  flex-direction: row;
  width: 930px;
  height: 300px;
  justify-content: space-around;
  /* align-items: center; */
}

.rightbox2 {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  width: 930px;
  height: 300px;
}

.square1 {
  display: flex;
  flex-direction: row;
  flex: 0 0 300px;
  background-color: #d0574e;
  justify-content: space-around;
}

.square2 {
  display: flex;
  flex: 0 0 300px;
  flex-direction: row;
  background-color: #c7aa6c;
  justify-content: space-around;
}

.square3 {
  display: flex;
  flex: 0 0 300px;
  flex-direction: row;
  background-color: #c7aa6c;
  justify-content: space-around;
}

.span1 {
  flex: 0 0 250px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  /* border: 5px solid blue;  */
}

.cha1 {
  flex: 0 0 auto;
  /* border: 5px solid red;  */
  font-size: 30px;
  line-height: 1.5;
  color: white;
}

.eng1 {
  flex: 0 0 auto;
  /* border: 5px solid red;  */
  font-size: 20px;
  line-height: 1.5;
  user-select: none;
}

.cha2 {
  flex: 0 0 auto;
  /* border: 5px solid red;  */
  font-size: 30px;
  line-height: 1.5;
  color: aliceblue;
}

.eng2 {
  flex: 0 0 auto;
  /* border: 5px solid red;  */
  font-size: 20px;
  line-height: 1.5;
  color: aliceblue;
  user-select: none;
}

.pic1 {
  flex: 0 0 50px;
  /* border: 5px solid red;  */
  align-self: flex-start;
}

.pattern {
  position: absolute;
  z-index: 1;
  left: 30px;
  top: 40px;
}

.title1 {
  position: absolute;
  width: 20px;
  line-height: 48px;
  font-size: 45px;
  left: 130px;
  top: 170px;
  user-select: none;
}

.title2 {
  position: absolute;
  width: 20px;
  line-height: 48px;
  font-size: 45px;
  left: 80px;
  top: 170px;
  user-select: none;
}

.line1 {
  position: absolute;
  left: 60px;
  bottom: 6vw;
  font-size: 30px;
  color: #c8b586;
  user-select: none;
}

.line2 {
  position: absolute;
  left: 60px;
  bottom: 3vw;
  font-size: 30px;
  color: #c8b586;
  user-select: none;
}
</style>