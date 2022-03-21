const fileResult = document.getElementById("fileResult")
const fileAdd=document.getElementById("fileAdd")
const del=document.getElementsByClassName("del")

let count =0;
let num=0; //id용도 

fileAdd.addEventListener("click",function(event){

   

    if(count>4){
        alert('파일 첨부는 최대 5개 까지만 가능합니다. ')
        return;
    }

    count++;

    let div =document.createElement('div')
    div.setAttribute("id","del"+num);


    let file=document.createElement('input') //<input>
    file.setAttribute("type","file") //<input type="file">
    file.setAttribute("name","files") //<input type="file" name="files">

    let button = document.createElement('button');
    button.setAttribute("type","button");
    //class이름 
    button.className="del";
    button.setAttribute("data-num","del"+num)
    button.innerHTML="DEL";

    div.append(file);
    div.append(button);


    fileResult.append(div)
    num++;
   
})

fileResult.addEventListener("click",function(event){
 let cn=  event.target;

 if(cn.classList.contains('del')){
    let delNum = cn.getAttribute("data-num");
    document.getElementById(delNum).remove();
    count--;
 }

})
