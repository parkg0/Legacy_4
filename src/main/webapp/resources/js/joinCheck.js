/**
 * 
 */

const allck=window.document.getElementsByClassName("rule");
const check=document.getElementsByClassName("check")
const checkall=document.getElementById('checkAll');
const btn = document.getElementById('btn');

//----내가한거 --------------------------
// checkall.addEventListener("click",function(){
//     for(let i=0;i<check.length;i++){
//     check[i].checked=true;
//     }
// });

// ---강사님 -----------------------------
checkall.addEventListener("click",function(){
for(c of check){
    c.checked = checkall.checked;
}
});


//동의1클릭  동의2클릭 동의3클릭 다 동의 되면 전체동의에 체크 들어오도록
//전체동의 누르고 하나 빼면 체크해제되도록 
//click할때마다 각각의 이벤트가 발생해야함 
//----나----------------------------
// for(ck of check){
//     ck.addEventListener("click",function(){
//         console.log(this.checked);
//         if(this.checked==false){
//             checkall.checked=false;
//         }else{
//             checkall.checked=true;
//         }
//     })
   
// }


//----강사님 -----
for(ck of check){
    ck.addEventListener("click",function(){
        let final= true;

       for(c of check){
           if(!c.checked){
               final=false;
           }
       }

    checkall.checked=final;

    });
   
}
//-----------숙제------------------------
btn.addEventListener("click",function(){
    if(checkall.checked){
        window.location.href="./join"
    }else{
        alert("약관에 모두 동의하여야 가입 가능합니다.")
    }
});

//반복문 이용 
// let c =true;
// for(ch of check){
//     if(!ch.checked){
//         c=false;
//     }
// }

//&&연산이용
// if(check[0].check&&check[1].check)