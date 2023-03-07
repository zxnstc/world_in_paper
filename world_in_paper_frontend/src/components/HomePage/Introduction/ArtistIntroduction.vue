<template>

    <div class="read-info">
        <div class="jieshao">
            <div class="jieshao-title">
                <span>作者简介</span>
            </div>

        </div>
        <h3 class="title">{{ name }}</h3>
        <div class="info">
            <ul>
                <li>
                    <em>性别：</em>
                    <span>{{ gender }}</span>
                </li>
                <li>
                    <em>传承级别：</em>
                    <span>{{ level }}</span>
                </li>
                <li>
                    <em>所属地区：</em>
                    <span>{{ area }}</span>
                </li>
                <li>
                    <em1>导语：</em1>
                    <span1>{{ intro }}</span1>
                </li>
            </ul>
        </div>


    </div>
    <!-- <div class="read-detail">
    <div class="f-left detail-info">
        <div class="abstract">
            <h2>传承人简介</h2>
            <div class="intro">
                
            </div>
        </div>
        
    </div>
    <div class="f-right detail-gl"> 
        <h3>相关作品<span class="line"></span></h3>
    </div>
</div> -->



</template>
<script>
export default {
    props: {
        name: {
            type: String,
            required: true,
        },
        gender: {
            type: String,
            required: true,
        },
        level: {
            type: String,
            required: true,
        },
        area: {
            type: String,
            required: true,
        },
        intro: {
            type: String,
            required: true,
        }
    },

}


</script>

<style scoped>
.read-info {
    width: 1200px;
    height: 333px;
    position: absolute;
    left: 8%;
    background-image: url(http://www.ichtianjin.com/themes/simpleboot3/public/whgcms/pc/images/feiyi/fy_huajuan.png);
    background-position-x: center;
    background-position-y: top;
    margin-bottom: 30px;
}

.jieshao {
    position: absolute;
    width: 40px;
    height: 118px;
    background-color: #c3975d;

    color: #fff;
    font-size: 24px;
    text-align: center;

    top: 35px;
    right: 92px;

}

.jieshao-title {
    margin-top: 10px;
}

.title {
    padding-top: 67px;
    font-size: 30px;
    font-weight: 500;
    color: black;
    text-align: center;
}

.info {
    font-size: 18px;
    font-weight: 600;
    color: black;
    padding-left: 100px;

}

.info em {
    width: 100px;
    text-align: right;
    display: inline-block;


}

.info em1 {
    margin-left: 30px;
    margin-top: 20px;
    width: 100px;
    text-align: right;
    text-decoration-line: underline;
    color: #d69137;
    font-size: 15px;
}

.info span {
    margin-left: 20px;
    font-size: 16px;
    font-weight: normal;
    color: #232323;

}

.info span1 {
    margin-top: 10px;
    margin-left: 20px;
    font-size: 10px;
    font-weight: normal;
    color: #363131;
    width: 900px;
    display: inline-block;
    text-align: left;
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
    padding: 60px 30px;
    background: #fff;
    margin-top: 0;
}
</style>