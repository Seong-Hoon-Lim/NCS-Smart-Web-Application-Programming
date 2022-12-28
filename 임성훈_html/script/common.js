// 외부파일은 head나 body 둘 다 가능합니다.
// 문제 1. 웹문서 로딩시 1초뒤에 로고가 3초에 걸쳐서 서서히 나타나도록
setTimeout(function() {
    $("#mainHeader h1").animate({ opacity: 1 }, 3000);
}, 1000)
// 문제 2. 네비게이션이 숨겨져 있도록 설정
$("#navigation .navWrap").hide();
// 문제 3. #navigation h2 버튼 클릭시 메뉴 펼침, 숨김 구현
$("#navigation h2").toggle( 
    function() {
    $("#navigation .navWrap").slideDown(500);
},  function() {
    $("#navigation .navWrap").slideUp(500);
})
// 문제 4. #navigation li 클릭시 해당 섹션으로 슬라이딩되도록
$("#navigation li").on("click", function(e) {
    e.preventDefault();
	let idName = $(this).children('a').attr("href");
	let pos = $(idName).position().top;
	$("html, body").animate({ scrollTop: pos });
})
// 문제 5. .btnList span 클릭시 슬라이더 애니메이션 구현
$(".sliderList span").hide();
$(".btnList span").on("click", function() {
    let btnList = $(this).index();
    console.log(btnList);
    $(this).addClass("on");
    $(".btnList span").not($(this)).removeClass("on");
    $(".sliderList").animate({ marginLeft: -(btnList * 100)+"%" })
})
$(window).on("scroll", function() {
    let winScroll = $(this).scrollTop();
    let sldScroll = $("#sliderWrap").position().top - 100;
    if ( sldScroll <= winScroll ) {
        $(".sliderList span").fadeIn("slow");
    }
})
// 문제 6. 코딩교육프로그램 섹션의 span 태그를 이용해서 아코디언 효과 적용
$(".program").removeClass("pro");
$(".program span").text("+");
$(".program span").on("click", function() {
    $(this).text("-");
    $(".program span").not($(this)).text("+");
    $(this).parents(".program").addClass("pro").slideDown(1000);    
    $(".program").not($(this).parents(".program.pro")).removeClass("pro").slideToggle(1000);
})
// $(".program span").toggle(    
//     function() {
//         ($(this).parents(".program").addClass("pro")).animate({ transition: "1s" });
//         $(this).text("-");
// },  function() {
//         ($(this).parents(".program").removeClass("pro")).animate({ transition: "1s" });
//         $(this).text("+");
//         console.log($(".program span").not($(this)));
// })
// 문제 7. .contentWrap1에 도달시 컨텐츠가 나타나기
$(".sectionHeader").hide();
$(".contentFirst").hide();
$(".contentSecond").hide();
$(window).on("scroll", function() {
    let winScroll = $(this).scrollTop();
    let conScroll = $(".contentWrap1").position().top - 200;
    console.log(winScroll);
    console.log(conScroll);
    if ( conScroll <= winScroll ) {
        $(".sectionHeader").fadeIn("slow");
        $(".contentFirst").fadeIn("slow");
        $(".contentSecond").fadeIn("slow");
    }
    else {
        $(".sectionHeader").fadeOut("slow");
        $(".contentFirst").fadeOut("slow");
        $(".contentSecond").fadeOut("slow");
    }

})