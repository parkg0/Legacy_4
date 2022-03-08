console.log('js');

const writer = document.getElementById("writer")
const title = document.getElementById("title")
const btn = document.getElementById("btn")
const frm = document.getElementById("frm")

let writerCheck= false;
let titleCheck= false;


writer.addEventListener("blur",function(){
    if(writer.value!=''){
        writerCheck=true;
    }
})

title.addEventListener("blur",function(){
    if(title.value!=''){
        titleCheck=true;
    }
})

btn.addEventListener("click",function(){
    if(writerCheck&&titleCheck){
        frm.submit();
    }else{
        alert('작성자와 제목은 필수')
    }
});
