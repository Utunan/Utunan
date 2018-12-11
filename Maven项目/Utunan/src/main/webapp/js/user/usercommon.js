community = document.getElementById('community');
postinfo = document.getElementById('postinfo');
mycollection = document.getElementById('mycollection');
collection = document.getElementById('collection');
plate=document.getElementById("currentplate").value;

dict={
    "myspace":0,"information":1,"follow":2,"statistics":3,"publishquiz":5,
    "publishanswer":6,"directioncollector":8,"quizcollector":9,
    "questioncollector":10,"settings":11
}

userfunction=document.getElementById("userfunction");
functions=userfunction.getElementsByTagName("li");
functions[dict[plate]].style.backgroundColor="rgba(0,150,136,0.1)";
functions[dict[plate]].style.color="rgba(0,150,136,1)";
com_pull_state = false
col_pull_state = false

community.onclick = function () {
    if (parseInt(postinfo.style.height) == 0) {
        com_pull_state = setInterval(function () {
            postinfo.style.height = parseInt(postinfo.style.height) + 2 + 'px'
            if (parseInt(postinfo.style.height) == 80) {
                clearInterval(com_pull_state)
            }
        }, 1)
    }
    if (parseInt(postinfo.style.height) == 80) {
        com_pull_state = setInterval(function () {
            postinfo.style.height = parseInt(postinfo.style.height) - 2 + 'px'
            if (parseInt(postinfo.style.height) == 0) {
                clearInterval(com_pull_state)
            }
        }, 1)
    }
}

mycollection.onclick = function () {
    if (parseInt(collection.style.height) == 0) {
        col_pull_state = setInterval(function () {
            collection.style.height = parseInt(collection.style.height) + 3 + 'px'
            if (parseInt(collection.style.height) == 120) {
                clearInterval(col_pull_state)
            }
        }, 1)
    }
    if (parseInt(collection.style.height) == 120) {
        col_pull_state = setInterval(function () {
            collection.style.height = parseInt(collection.style.height) - 3 + 'px'
            if (parseInt(collection.style.height) == 0) {
                clearInterval(col_pull_state)
            }
        }, 1)
    }
}