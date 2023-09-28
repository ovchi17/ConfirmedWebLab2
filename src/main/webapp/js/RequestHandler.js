function  confirmValues(){
    checkInput();
    console.log("We are here");
    console.log(checkInput());
    if (checkInput()){
        console.log("!!!");
        let valueY = document.getElementById("y-value").value;
        let valueX;
        const buttons = document.querySelectorAll('.button1');
        buttons.forEach(button => {
            if (button.classList.contains('active')) {
                valueX = button.dataset.value;
            }
        });
        let valueR;
        const buttons2 = document.querySelectorAll('.button2');
        buttons2.forEach(button => {
            if (button.classList.contains('active')) {
                valueR = button.dataset.value;
            }
        });

        $.ajax({
            type: "POST",
            url: "controllerServlet",
            async: false,
            data: { "x": valueX, "y": valueY, "r": valueR },
            success: function (data) {
                window.location.replace('./conclusion.jsp');
            },
            error: function (xhr, textStatus, err) {
                console.log("readyState: " + xhr.readyState + "\n"+
                    "responseText: " + xhr.responseText + "\n"+
                    "status: " + xhr.status + "\n"+
                    "text status: " + textStatus + "\n" +
                    "error: " + err);
            }
        });

        console.log(valueX, valueY, valueR)
    }

}