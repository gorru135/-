const checkObj = { 
    "inputId" : false,
    "inputPw" : false,
    "inputPwConfirm" : false
};

// 아이디 유효성 검사
const inputId = document.getElementById("inputId");

inputId.addEventListener("change", function(){

    const regExp = /^[a-z][\w!@#$%^&*_-]{5,13}$/;

    if(regExp.test(this.value)){
        this.style.background = "green";
        this.style.color ="white";
        checkObj.inputId = true;

    } else{
        this.style.background = "red";
        this.style.color ="white";
        checkObj.inputId = false;
    }
});

// 비밀번호 일치하는지 검사
const inputPw = document.getElementById("inputPw");
const inputPwConfirm = document.getElementById("inputPw2");

inputPwConfirm.addEventListener("keyup", function(){
    if(inputPw.value.length == 0){
        this.value = "";

        alert("비밀번호를 먼저 입력해주세요");
        inputPw.focus();
        checkObj.inputPw = false;

    }

});

const pwMessage = document.getElementById("pwMessage");

inputPw.addEventListener("keyup", function(){
    if((inputPw.value == inputPwConfirm.value)&& inputPw.value.length !=0 ){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm")
        pwMessage.classList.remove("error")
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error")
        pwMessage.classList.remove("confirm")
        checkObj.inputPwConfirm = false;

    }
});

inputPwConfirm.addEventListener("keyup", function(){
    if((inputPw.value == inputPwConfirm.value)&& inputPw.value.length !=0 ){
        pwMessage.innerText = "비밀번호 일치";
        pwMessage.classList.add("confirm")
        pwMessage.classList.remove("error")
        checkObj.inputPw = true;
        checkObj.inputPwConfirm = true;

    } else{
        pwMessage.innerText = "비밀번호 불일치";
        pwMessage.classList.add("error")
        pwMessage.classList.remove("confirm")
        checkObj.inputPwConfirm = false;

    }
});




function validate(){

    for(let key in checkObj){
        if( !checkObj[key] ){
            alert("유효성 검사가 완료되지 않았습니다.")
            return false;
        }
    }
    return true;
};
