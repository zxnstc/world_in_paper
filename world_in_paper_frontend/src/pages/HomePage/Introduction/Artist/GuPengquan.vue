<template>

  
  <div class="page">
    <el-container>
      <el-main>
        <artist-introduction :name="authorInfo.name" :gender="authorInfo.gender" :level="authorInfo.level"
          :area="authorInfo.area" :intro="authorInfo.intro" ></artist-introduction>
  
  <div class="read-detail">
    <div class="f-left detail-info">
      <div class="abstract">
        <h2>传承人简介</h2>
        <div class="intro">
          
          几把剪刀，几张彩色剪纸或树叶，经过折叠、剪切，时而呈现出栩栩如生的花鸟虫鱼，时而呈现出感情充沛、精巧细致的各色人物。既有鸿篇巨制的《清明上河图》，又有精细布局的《红楼梦》，还有跃然“叶”上的高飞雄鹰、人物头像。你能想到这一切是出自一个花季少年之手吗 ？
          <br/><br/>
【用纸堆砌的回忆】
<br/>
顾朋泉出身于一个剪纸世家，自小对于剪纸的印象就是两个字———“漂亮”。在他们的那个村落，结婚生子，逢年过节，老人去世，都离不开剪纸，他从心底觉得剪纸是一个很美好的事物。那时起，他就拿起了剪刀，开始了自己儿时的娱乐，当手中的纸变成了他想象中的模样，油然而生的是满满的自豪感和成就感。童年，陪伴他的不是农田梗上硬硬的泥巴，不是果园里香甜的水果，也不是草丛深处的鸣叫蝈蝈，而是漫天飞舞的纸片，红红的大囍字，各种动物图像。渐渐地，这成了他的喜好，生活中不可缺少的一部分。长大后，不曾见他沉迷于网络世界，而是将所有的精力与空余的时间都用在了剪纸上。当被问到为什么会选择剪纸这样一个早已淡出潮流的传统事物时，他回答说：“剪纸，是一个是时代的产物，融合了许多当代的政治经济文化。并且，一般是民间的艺术家手手传承，十分的淳朴，里面有一种很朴实的东西，更多的反映出对美好生活的向往，就是一种生活的艺术吧。”
<br/><br/>
 【在继承中创新的剪纸文化】
 <br/>
剪纸作为一种古老的文化艺术，要在继承中发展，更要在继承中创新。在顾朋泉看来，继承是继承剪纸当中传统的技法，而创新则是在内容上、选材上。“将南刻北剪多种技法相结合，在继承传统中创新”是顾朋泉的作品风格。说到将南剪北刻相结合，这也是不容易的过程。“南方以刻为主，风格严谨细腻，装饰性较强；而北方以剪为主，风格粗犷，线条多变灵活。倘若能把两者结合起来，岂不是会有实质性的飞跃吗？”顾朋泉在琢磨中探索，从自制的刻刀，到技法的融合，一步步探索着。
树叶上雕刻，这种形式在古代就存在，“汉妃抱娃窗前耍，巧刻桐叶照窗纱” ，“我只不过是把这种传统古老的东西还原回来了。”为了找到合适的树叶，顾朋泉也是没少费功夫。选叶，压制，以及保存。叶子在长时间后会氧化变成黄色，还有种高贵的感觉，不过顾朋泉已经在叶雕作品上涂上清漆减慢氧化，附上药物防虫蛀。他还在积极思考怎样解决氧化问题。
		不论是南刻北剪的结合，还是叶雕的防氧化方面，顾朋泉都在继承古老的传统中有所创新，同时又继承了剪纸文化的精髓。
		顾朋泉的执着与努力，使他在各种规模的比赛中荣获大奖，取得了如今的成就。
    <br/><br/>
【回归质朴 感恩成长】
<br/>
当问到在他剪纸的道路上，谁对他的影响最大，他讲到，小的时候受家庭祖辈的影响比较大，姥姥就是一位剪纸能手，经常会给他指点，母亲作为一位农民 ，遵从他自己的喜好天然发展，在这一点上，他十分感谢自己的母亲。当谈及书画剪纸界名人对自己的启迪时，顾朋泉满怀感激的回答，每一位前辈大师在不同方面都让自己受益匪浅。
让剪刀在手中起舞，让树叶因雕刻而绽放生命的魅力，顾朋泉，用剪刀剪出了自己的梦想，用剪刀剪出了自己精彩的人生 </div>
      </div>
      <div class="abstract">
        <h2>图片｜视频</h2>
        <div class="intro">
          <img src="http://117.50.179.215:8070/images/2022/12/22/jPWu.jpg" alt="jPWu.jpg" border="0" /><br/>
          <img src="http://117.50.179.215:8070/images/2022/12/22/jupx.jpg" alt="jupx.jpg" border="0" />
             </div>
      </div>


    </div>
    <div class="f-right detail-gl">
      <h3>相关作品<span class="line"></span></h3>
      <div class="content">
        2012年,顾朋泉8m长的的剪纸作品《清明上河图》在山东省美术馆展出
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
      name: '顾朋泉',
      gender: '男',
      level: '中国工艺美术学会会员、中华民族文化促进会剪纸艺术委员会会员、山东民俗学会会员',
      area: '山东',
      intro: '他是一位优秀的剪纸艺术传承人，从小热爱剪纸，历经岁月沉淀，钻研创造，奖誉盛多，他数载坚持，只为做自己热爱的事，他东奔西走，只为搜集那些被世人遗忘的剪纸藏品，他悉心教授，只为让这个时代更多的人感受剪纸的魅力。  ',
      
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

.content {
  padding: 30px;
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