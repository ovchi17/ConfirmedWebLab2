document.addEventListener('DOMContentLoaded', function () {
    let errorShow = document.querySelector('.checkInput');
    var svg = document.querySelector('.XYcoord svg');
    svg.addEventListener('click', function (event) {
        var x = event.clientX;
        var y = event.clientY;
        var point = svg.createSVGPoint();
        point.x = x;
        point.y = y;
        var transformedPoint = point.matrixTransform(svg.getScreenCTM().inverse());
        checkClickArea(transformedPoint.x, transformedPoint.y);
    });

    function checkClickArea(x, y) {
        var result = '';
        if ((x >= 40 && x <= 345) && (y >= 45 && y<= 350)){
            const buttonsR = document.querySelectorAll('.button2');
            let isActiveButtonR = false;
            buttonsR.forEach(button => {
                if (button.classList.contains('active')) {
                    isActiveButtonR = true;
                }
            });
            if (isActiveButtonR){
                let valueR;
                buttonsR.forEach(button => {
                    if (button.classList.contains('active')) {
                        valueR = button.dataset.value;
                    }
                });
                let toSendX = ((x - 195) / 150 * valueR).toFixed(5);
                let toSendY = ((200 - y) / 155 * valueR).toFixed(5);
                if (toSendX >= -2 && toSendX <= 2 && toSendY >= -5 && toSendY <= 3 ){
                    $.ajax({
                        type: "POST",
                        url: "controllerServlet",
                        async: false,
                        data: { "x": toSendX, "y": toSendY, "r": valueR },
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
                }else{
                    result = 'Выход значений за пределы допустимого';
                }
            }else{
                result = 'Не активирован R';
            }
        }else{
            result = 'Вы не попали в область';
        }
        errorShow.innerHTML = result;
        errorShow.classList.add("show");
    }
});