layui.use(['carousel'], function(){
    var carousel = layui.carousel
        ,form = layui.form;

    //图片轮播
    carousel.render({
        elem: '#lunbo'
        ,full: true
        ,anim: 'fade'
        ,interval: 2000
    });

});