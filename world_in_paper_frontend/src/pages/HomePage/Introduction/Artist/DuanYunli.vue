<template>


  <div class="page">
    <el-container>
      <el-main>
        <artist-introduction :name="authorInfo.name" :gender="authorInfo.gender" :level="authorInfo.level"
          :area="authorInfo.area" :intro="authorInfo.intro"></artist-introduction>

        <div class="read-detail">
          <div class="f-left detail-info">
            <div class="abstract">
              <h2>传承人简介</h2>
              <div class="intro">
                【守艺人】
                <br />
                非遗剪纸：纸屑里的时光

                一纸成形态，一刀剪神态。纸与剪的结合，勾勒出最美轮廓，刻剪出最美图案。段云丽以纸作画，以剪作工，平淡无奇的纸张在她的刀下便不再普通，世间万物在她的刀下便也有了灵性。

                段云丽与母亲一样，都是昆明市非物质文化遗产传承人。她出生在剪纸世家，是剪纸家传谱系的第四代传承人。在家族的熏陶下，年少的她拿起剪刀，展现出了极高的剪纸天赋。

                每一幅作品都是段云丽对生活的所见所感受，亦是她对未来美好愿望的呈现。四十余年的剪纸生涯，早已练就了段云丽的精准与细腻。她在家族传统技法的基础上，不断创新，融入现代元素，形成了独具特色的艺术风格。她善于用线条表现细节，线条越细，工艺就越精湛。她剪出的是图案，但她倾注的是感情。只需要短短的几分钟时间，段云丽就能把脑海中的图案还原在红纸上，灵动唯美。

                剪纸不仅充盈了段云丽的生活，也为她带来了自己的爱人。段云丽的爱人汪元素有“神来之剪”的美誉。他是土生土长的云南人，云南这片土地孕育了他的豪迈越刚毅。不同于段云丽专研的传统剪纸，汪源自成一派，主攻人物剪影。在他看来，每个人都有与生俱来的特征与气质，而他则将不同的人物特性通过剪影的形式呈现在汪源的作品中，人是永远的主题，他剪刀下的人物剪影都神形具备，栩栩如生，古有侠客闯荡江湖，今有段汪神剪天涯。在生活中，段云丽和汪元常常互相交流，共同探讨剪纸记忆。两人术业专攻联手剪纸，尽显夫妻恩爱。他们因剪纸相识，也因剪纸相爱，而这项拥有千年底蕴的记忆也成了两人爱情的最好见证。
              </div>
            </div>
            <div class="abstract">
              <h2>图片｜视频</h2>
              <div class="intro">
                <img src="http://117.50.179.215:8070/images/2022/12/22/jeWG.png" alt="jeWG.png" border="0" />
                <br />
                <img src="http://117.50.179.215:8070/images/2022/12/22/j4pV.png" alt="j4pV.png" border="0" />
                <br />
                <img src="http://117.50.179.215:8070/images/2022/12/22/jKqT.png" alt="jKqT.png" border="0" />
              </div>
            </div>


          </div>
          <div class="f-right detail-gl">
            <h3>相关作品<span class="line"></span></h3>

            <div class="content">
              2014年第四届全国非物质文化遗产联展中剪纸作品《鞋花》荣获铜奖。<br />
              2014年云南首届剪纸成果展中作品《丰收》荣获优秀作品奖。<br />
              2014年作品《蝴蝶姑娘》被选参加马来西亚剪纸巡回展。<br />
              2016年剪纸作品《剪花姑娘》参加云南省职工创新创意成果展中荣获银奖。
            </div>
          </div>

        </div>
      </el-main>
    </el-container>
  </div>


</template>
    
<script>
import ArtistIntroduction from '../../../../components/HomePage/Introduction/ArtistIntroduction.vue';
export default {

  components: {
    ArtistIntroduction
  },
  data() {
    return {
      authorInfo: {
        name: '段云丽夫妇',
        gender: '男&女',
        level: '神剪王',
        area: '云南',
        intro: '中国有着五千年悠久的历史，绵绵历史的厚重与温情，奋斗与智慧，很多都寄托在流传了千年的传统手工艺文化中，手艺人是传统手工技艺的守护神，在他们手中的每一件工艺品都体现了他们赤诚的内心，用心尽情，匠心独运。 非遗传承人段云丽夫妇因剪纸相识，也因剪纸相爱，而这项拥有千年底蕴的技艺，也成了两人爱情的最好见证。 ',

      },
    };
  },
}

</script>
       
<style scoped>
.page {
  display: flex;
  position: relative;
  width: 100vw;
  height: 500vh;
  background-image: url(http://www.ichtianjin.com/themes/simpleboot3/public/whgcms/pc/images/feiyi/fyml_detail.png);

}

.content {
  padding: 30px;
}

.read-detail {
  position: absolute;
  top: 400px;
  left: 8%;

}

.read-detail h2 {
  width: 807px;
  height: 50px;

  Line-height: 50px;
  background: #C3975D;
  color: #fff;
  font-size: 20px;
  text-indent: 33px;
  margin-bottom: 0;
}

.detail-gl h3 {
  width: 100%;
  height: 22px;
  font-size: 22px;
  font-weight: 500;
  color: #111111;
  position: relative;
  margin: 30px 0 20px 0;
  text-indent: 23px;
}

.detail-gl h3 .line {
  width: 129px;
  height: 1px;
  background: #393939;
  position: absolute;
  top: 10px;
  right: 20px;
}

.f-left {
  float: left;
}

.f-right {
  float: right;
}

.detail-info {
  width: 870px;
  margin-bottom: 119px;
}

.detail-gl {
  width: 300px;
  height: 406px;
  background-color: #fff;

}

.abstract {
  margin-bottom: 28px;
}


.intro {
  width: 807px;
  /* height: 124px; */
  font-size: 16px;
  font-weight: 400;
  color: #080808;
  line-height: 36px;
  padding: 60px 60px;
  background: #fff;
  margin-top: 0;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
</style>