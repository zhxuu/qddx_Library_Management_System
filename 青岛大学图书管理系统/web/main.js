var label_email = document.getElementsByClassName('emaillabel')[0];
var label_password = document.getElementsByClassName('passwordlabel')[0];
var username = document.getElementById('username');
var password = document.getElementById('password');
username.addEventListener('blur', function(){
    if(username.value){
        label_email.className = 'labelactive';
    }else{
        label_email.className = '';
    }
});
password.addEventListener('blur', function(){
    if(password.value){
        label_password.className = 'labelactive';
    }else{
        label_password.className = '';
    }
});
