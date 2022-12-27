// 외부파일은 head나 body 둘 다 가능합니다.
// 문제 1. 웹문서 로딩시 1초뒤에 로고가 3초에 걸쳐서 서서히 나타나도록
// 문제 2. 네비게이션이 숨겨져 있도록 설정
setTimeout(loadEvent(), 1000);
function loadEvent() {
    $(window).on("load", function() {
        $("#mainHeader h1").animate({ opacity: 1 }, 3000);
        $("#navigation .navWrap").hide();
        // $("#navigation .navWrap").css({ overflow: "visible" })
        //                          .css({ opacity: 0 })
    })
}
clearTimeout(loadEvent());
// 문제 3. #navigation h2 버튼 클릭시 메뉴 펼침, 숨김 구현
$("#navigation h2").on("click", function() {
    $("#navigation .navWrap").show();
})
// bind 연결
// $("#navigation h2").on({
//     click: function() {
//     $("#navigation .navWrap").show();
// }, click: function() {
//     $("#navigation .navWrap").hide();
// }
// })
// toggle 방식
// $("#navigation h2").toggle(
//     function() { $("#navigation .navWrap").show(); },
//     function() { $("#navigation .navWrap").hide(); }
// );

// 문제 4. #navigation li 클릭시 해당 섹션으로 슬라이딩되도록
$("#navigation li").on("click", function(e) {
    e.preventDefault();
	let idName = $(this).children('a').attr("href");
	let pos = $(idName).position().top;
	$("html, body").animate({ scrollTop: pos });
})
// 문제 5. .btnList span 클릭시 슬라이더 애니메이션 구현
$(".btnList span").on("click", function() {
    let num = 0;
    let btnNum = $(this).index();
    console.log(btnNum);
    $(this).addClass("on");
    $(".btnList span").not($(this)).removeClass("on");
    $(".sliderList").animate({ marginLeft: -(btnNum * 100)+"%" })
})
// 문제 6. 코딩교육프로그램 섹션의 span 태그를 이용해서 아코디언 효과 적용
// 문제 7. .contentWrap1에 도달시 컨텐츠가 나타나기
