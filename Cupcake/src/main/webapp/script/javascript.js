/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*Registration validation
 * Denne function kalder de andre functions der bruges til validation
 * */
function formValidation()
{
    var passid = document.Form1.password;
    var uname = document.Form1.username;
    var uemail = document.Form1.email;
    var passid_repeat = document.Form1.passwordrepeat;
    {
        if (passid_validation(passid, 7, 12))
        {
            if (allLetter(uname))
            {
                if (ValidateEmail(uemail))
                {
                    if (check_database(uname,uemail))
                    {
                        if (passid_same_as_reapeat(passid, passid_repeat))
                        {
                        }
                    }
                }
            }
        }
    }

    return false;
}
function passid_validation(passid, mx, my)
{
    var passid_len = passid.value.length;
    if (passid_len === 0 || passid_len >= my || passid_len < mx)
    {
        alert("Password should not be empty / length be between " + mx + " to " + my);
        passid.focus();
        return false;
    }
    return true;
}
function allLetter(uname)
{
    var letters = /^[A-Za-z]+$/;
    if (uname.value.match(letters))
    {
        return true;
    } else
    {
        alert('Username must have alphabet characters only');
        uname.focus();
        return false;
    }
}
function ValidateEmail(uemail)
{
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (uemail.value.match(mailformat))
    {
        return true;
    } else
    {
        alert("You have entered an invalid email address!");
        uemail.focus();
        return false;
    }
}
function check_database(uname,uemail)
{
    
}
function passid_same_as_reapeat(passid, passid_repeat)
{
    if (passid.value !== passid_repeat.value)
    {
        {
            alert("Your repeated password did not match your password");
            passid.focus();
            return false;
        }
    } else
    {
        alert('Form Succesfully Submitted');
        window.location.login.jsp; //Redirections to login page
        return true;
    }
}








/* global get */

function wrongLoginInMessage() {
    alert("Wrong username or password! Try again!");
}

function validate()
{
    var username = document.Form1.username.value;
    var password = document.Form1.password.value;
    if (username === null || username === "")
    {
        alert("Username cannot be blank");
        return false;
    } else if (password === null || password === "")
    {
        alert("Password cannot be blank");
        return false;
    }
}
function creditExceeded() {

    var tempBalance = getElementsByName("tempBalance").values();
    if (tempBalance < 10) {
        alert("You do not have sufficient credit in your account");
    }
}
function doNotPush() {
    document.getElementsByID("cancel");
    alert("Do not push the red button");
}

