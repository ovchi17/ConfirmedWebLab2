function careInput(event) {
    const targetInput = event.target;
    const validInputValue = targetInput.value.replace(/[^\d.-]/g, '');
    targetInput.value = validInputValue;
}

function checkInput(){
    let errorShow = document.querySelector('.checkInput');
    const buttons = document.querySelectorAll('.button1');
    const buttons2 = document.querySelectorAll('.button2');
    let valueY = document.getElementById("y-value").value;
    var result = '';
    var verdict = false;
    let isActiveButton1 = false;
    let isActiveButton2 = false;
    errorShow.classList.remove("show");

    buttons.forEach(button => {
        if (button.classList.contains('active')) {
            isActiveButton1 = true;
        }
    });
    buttons2.forEach(button => {
        if (button.classList.contains('active')) {
            isActiveButton2 = true;
        }
    });

    console.log("CHECKER");
    if (isActiveButton1 && isActiveButton2){
        console.log("Кнопка ворк");
        if (!(valueY.trim() === "")){
            console.log("Поля не пустые");
            if (isNumber(valueY)){
                console.log("Числа - числа");
                console.log(parseFloat(valueY) < 3);
                if ((parseFloat(valueY) > -5) && (parseFloat(valueY) < 3)){
                    verdict = true;
                } else {
                    result = 'The values entered in the fields do not fall within the allowed range';
                }
            } else {
                result = 'The values entered in the fields are not numbers';
            }
        } else {
            result = 'Input fields cannot be empty';
        }
    } else {
        result = 'Please, choose X and R values';
    }
    errorShow.innerHTML = result;
    errorShow.classList.add("show");

    return verdict;
}

function isNumber(value) {
    return typeof value === 'string' && /^[-+]?\d+(\.\d+)?$/.test(value);
}