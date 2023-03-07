<template>
  <div class="homepage">
    <div class="title">
      <h1>立体剪纸</h1>
    </div>
    <div class="content">
      <div class="section">
        <p><span class="words">&emsp;在日常生活中，我们最为常见的剪纸是窗花，逢年过节，家家户户窗户上贴着的窗花，寄托着我们的祝福，也为节日增加了更多的喜庆元素。这些展现在面前的窗花都是平面的，一张纸，通过取舍剪制，留下的也都是平面的影像，适合贴在窗户上，服服帖帖，图案内容一目了然。</span></p>
      </div>

      <div class="section">
        <p><span class="words">&emsp;其实，还有一种剪纸，可以带来更多的立体感，同样是在一张平平的纸上，按照一定的纹理走向剪刻，揭起部分剪好的图案，依照一定次序排列，再搭配上合适的底衬颜色，呈现出来的便是一幅幅绝美的立体剪纸作品。</span></p>
      </div>
      <div class="section">
        <p><span class="words">&emsp;立体剪纸既可是单色，也可是彩色的。它采用了绘画、剪刻、折叠、黏合等综合手法产生的一种近于雕塑、浮雕的新型剪纸，它吸取了现代美术的技巧，充分体现了写实与美术浪漫的特点，使剪纸由平面感变为立体化，可用于观赏造型及儿童的手工制作等</span></p>
      </div>

      <div class="image"><img src="/image/techview/stereoscopic/1.png"
             class="img_class">
      </div>
      <div class="image"><img src="/image/techview/stereoscopic/2.png"
             class="img_class">
      </div>
      <div class="image"><img src="/image/techview/stereoscopic/3.png"
             class="img_class">
      </div>
      <div class="image"><img src="/image/techview/stereoscopic/4.png"
             class="img_class">
      </div>
    </div>
  </div>

</template>
          
    <script>
export default {}
</script>
          
      <style scoped>
.homepage {
  height: 100%;
  display: flex;
  flex-direction: column;
}
.title {
  background: url('/image/course/title.png');
  width: 600px;
  height: 250px;
  background-size: 100% 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
}
h1 {
  display: flex;
  align-items: center;
  color: #f55858;
}
.content {
  width: 70%;
  height: 100%;
  display: flex;
  flex-direction: column;
  margin-left: 15%;
  background: rgb(254, 251, 244);
  background-size: 100% 100%;
  border: 2px solid #e5e5e5;
  margin-bottom: 40px;
}

.section {
  display: flex;
  flex-direction: column;
  margin: 1.5%;
}

.image {
  max-width: 40%;
  display: flex;
  align-self: center;
  margin-bottom: 40px;
}
</style>