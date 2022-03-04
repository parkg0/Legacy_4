//전역변수 
const pwResult=document.getElementById("pwResult");
const pw = document.getElementById("pw");
const id1 = document.getElementById("id1");
const idResult = document.getElementById("idResult")
const pw2 = document.getElementById("pw2");
const pwResult2 = document.getElementById("pwResult2");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");

//var 은 전역변수로 선언하고 지역변수로 또 선언 가능 
//이걸 개선하고자 let 사용 

//아이디 조건충족, pw 조건충족 체크 
let idCheck=false; //check o -> true 
let pwCheck=false;
let nameCheck=false;
let phoneCheck=false;
let emailCheck=false;

//비밀번호 입력칸 값이 바뀌었을때 
pw.addEventListener("change",function(){
    pwCheck=false;
    pw2.value=''; // 다시 검증하러감 ->pw2 칸 지워짐 
    pwResult2.innerHTML='';
    pw2.focus();
})


// name phone email 작성확인 --
name.addEventListener("blur",function(){
    if(name.value.length!=0){
        nameCheck=true;
    }
})

phone.addEventListener("blur",function(){
    if(phone.value.length!=0){
        phoneCheck=true;
    } 
})
email.addEventListener("blur",function(){
    if(email.value.length!=0){
        emailCheck=true;
    }
})
//----------------------------

btn.addEventListener("click",function(){
    if(idCheck&&pwCheck&&nameCheck&&phoneCheck&&emailCheck){
    frm.submit();
    }else{
        alert('필수요건을 확인하세요');
    }
})


pw.addEventListener("keyup",function(){
    let length=pw.value.length
    let message='잘못된 비번';
    if(length>=8&&length<=12){
        message='사용가능한 비번';
    }
    pwResult.innerHTML=message;
})

//아이디가 비어있으면 메시지 출력 필수입니다. 
//아이디가 입력안된채로 비번 입력하러 갈대 아이디는 필수입니다. 
//패스워드 입력하고 두번째 패스워드 하나 더 입력
//입력하고 빠져나왔을때
//일치하면 패스워드가 일치합니다.
//다르면 패스워드가 일치하지 않습니다.

id1.addEventListener("blur",function(){
    let v =id1.value.length
    let message =""
    if(v==0){
        console.log("비어있다")
        message="아이디는 필수 "
        idCheck=false;
    }else{
        idCheck=true;
        console.log("비어있지 않다")
    }
    idResult.innerHTML=message;
})

pw2.addEventListener("blur",function(){
    let message ="패스워드가 일치하지 않습니다."
    if(pw2.value==pw.value){
        message="패스워드가 일치합니다."
        pwCheck=true;
    }else{
        pwCheck=false;
    }
    pwResult2.innerHTML=message
})