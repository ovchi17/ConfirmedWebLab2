function redirectToURL() {
    //window.location.href = "urlsInfo.jsp";
    $.ajax({
        type: "POST",
        url: "controllerServlet",
        async: false,
        data: { "urlInfo": "true"},
        success: function (data) {
            window.location.replace('./urlsInfo.jsp');
        },
        error: function (xhr, textStatus, err) {
            console.log("readyState: " + xhr.readyState + "\n"+
                "responseText: " + xhr.responseText + "\n"+
                "status: " + xhr.status + "\n"+
                "text status: " + textStatus + "\n" +
                "error: " + err);
        }
    });
}