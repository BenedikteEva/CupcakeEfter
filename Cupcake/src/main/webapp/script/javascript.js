/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global get */

function wrongLoginInMessage() { 
    alert("Wrong username or password! Try again!") ;
}

function validate()
{
var username = document.Form1.username.value;
var password = document.Form1.password.value;
if (username===null || username==="")
{
alert("Username cannot be blank");
return false;
}
else if(password===null || password==="")
{
alert("Password cannot be blank");
return false;
}
}
function creditExceeded(){
   
    var tempBalance = getElementsByName("tempBalance").values();
    if (tempBalance<10){
        alert("You do not have sufficient credit in your account");
    }
}
function doNotPush(){
    document.getElementsByID("cancel");
    alert("Do not push the red button");
}
