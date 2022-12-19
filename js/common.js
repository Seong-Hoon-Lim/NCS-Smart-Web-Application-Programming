// 네비게이션 mouseover,mouseout
const gnbList = document.querySelectorAll("#gnbList > li > a");
const snb = document.querySelectorAll(".snb");

gnbList.forEach( (gli, i)=>{
    gli.addEventListener("mouseover", ()=>{
        snb[i-1].style.opacity = "1";
        setTimeout(()=> {
        }, 500);
    })
    gli.addEventListener("mouseout", ()=> {
        snb[i-1].style.opacity = "0";
        setTimeout(()=> {
        }, 500);
    })
})

// 슬라이더 버튼 click
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