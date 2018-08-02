
// function checkForDoubles(){
//     var pwd1=document.getElementById('pwd');
//     var pwd2=document.getElementById('pwd_confirm');
//     var pwdDao=document.getElementById('pwdDao');
//     if(pwd1.value=="" && pwd1.value==""){
//         console.log('non sto cambiando la password');
//         pwd1.setAttribute("disabled", "disabled");
//         pwd2.setAttribute("disabled", "disabled");
//         // disableDouble('pwd1');
//         // disableDouble('pwd2');
//     }
//     else{
//         console.log('sto cambiando la password');
//         pwd1.setAttribute("disabled", "disabled");
//         pwdDao.setAttribute("disabled", "disabled");
//         // disableDouble('pwd1');
//         // disableDouble('pwdDao');
//     }
// }
//
// function disableDouble(el){
//     console.log('disabilito il campo');
//     console.log(document.getElementById(el).value);
//     document.getElementById(el).setAttribute("disabled", "disabled");
// }


var check = function() {
    if (document.getElementById('pwd').value ==
        document.getElementById('pwd_confirm').value) {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'matching';
    } else {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'not matching';
    }
}

function removeEmpties() {
    var form = document.getElementById("theForm");
    var inputs = form.children;
    var remove = [];
    for(var i = 0; i < inputs.length; i++) {
        if(inputs[i].value == "") {
            remove.push(inputs[i]);
        }
    }

    if(remove.length == inputs.length - 1)
        return false;

    for(var i = 0; i < remove.length; i++)
        form.removeChild(remove[i]);
    return true;
}