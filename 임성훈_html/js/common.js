// 네비게이션 mouseover,mouseout 이벤트
const gnbList = document.querySelectorAll("#gnbList > li");
const snb = document.querySelectorAll(".snb");

gnbList.forEach( gli=>{
    gli.addEventListener("mouseenter", (e)=>{
        if (gli.childNodes.length != 1) {
            e.currentTarget.children[1].style.opacity = 1;            
        }
    })
    gli.addEventListener("mouseleave", (e)=> {
        if (gli.childNodes.length != 1) {
            e.currentTarget.children[1].style.opacity = 0;            
        }
    })
})

// 슬라이더 버튼 click 이벤트 -> 슬라이더 transform 실행
const sliderList = document.getElementById("sliderList");
const sliderBtn = document.querySelectorAll(".sliderBtn a");
const eventBtnWrap = document.querySelectorAll(".eventBtnWrap");


sliderBtn[0].addEventListener("click", ()=> {
    sliderList.style.transform = `translateX(0%)`;   
    sliderList.style.transition = "0.5s";
    eventBtnWrap[0].style.zIndex = 999;

    
})
sliderBtn[1].addEventListener("click", ()=> {
    sliderList.style.transform = `translateX(-33.29%)`;   
    sliderList.style.transition = "0.5s";  
    
})
sliderBtn[2].addEventListener("click", ()=> {
    sliderList.style.transform = `translateX(-66.58%)`; 
    sliderList.style.transition = "0.5s";  
    
})