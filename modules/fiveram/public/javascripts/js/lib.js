jQuery(document).ready(function($) {
    //导航
    $(".nav li").hover(function(){
        $(this).find('dl').stop().slideToggle();
    })


    $(".g-right-menu").mouseenter(function(){
        $(this).fadeOut();
        $("#g-right").addClass('ok');
    });

    $("#g-right").mouseleave(function(){
        $(this).removeClass('ok');
        $(".g-right-menu").fadeIn();
    })


    //动画效果        
    if (! (/msie [6|7|8|9]/i.test(navigator.userAgent))) {
       var wow = new WOW(
         {
           boxClass:     'wow',      // animated element css class (default is wow)
           animateClass: 'animated', // animation css class (default is animated)
           offset:       0,          // distance to the element when triggering the animation (default is 0)
           mobile:       true,       // trigger animations on mobile devices (default is true)
           live:         true       // act on asynchronously loaded content (default is true)
         }
       );
       wow.init();
    };
});