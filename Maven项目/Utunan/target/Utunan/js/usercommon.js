community = document.getElementById('community');
postinfo = document.getElementById('postinfo');
mycollection = document.getElementById('mycollection');
collection = document.getElementById('collection');


com_pull_state = false
col_pull_state = false

community.onclick = function () {
    if (parseInt(postinfo.style.height) == 0) {
        com_pull_state = setInterval(function () {
            postinfo.style.height = parseInt(postinfo.style.height) + 2 + 'px'
            if (parseInt(postinfo.style.height) == 100) {
                clearInterval(com_pull_state)
            }
        }, 1)
    }
    if (parseInt(postinfo.style.height) == 100) {
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
            if (parseInt(collection.style.height) == 150) {
                clearInterval(col_pull_state)
            }
        }, 1)
    }
    if (parseInt(collection.style.height) == 150) {
        col_pull_state = setInterval(function () {
            collection.style.height = parseInt(collection.style.height) - 3 + 'px'
            if (parseInt(collection.style.height) == 0) {
                clearInterval(col_pull_state)
            }
        }, 1)
    }
}