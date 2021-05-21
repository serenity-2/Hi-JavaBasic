function clickMe() {
    alert("hello js")
    const url = "http://127.0.0.1/user/get";
    $.get(url, function (data, status) {
        console.log('${data}');

    })

}