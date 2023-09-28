document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.button1');

    buttons.forEach(button => {
        button.addEventListener('click', (event) => {

            buttons.forEach(otherButton => {
                otherButton.classList.remove('active');
            });

            button.classList.add('active');
        });
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const buttons = document.querySelectorAll('.button2');

    buttons.forEach(button => {
        button.addEventListener('click', (event) => {

            buttons.forEach(otherButton => {
                otherButton.classList.remove('active');
            });

            button.classList.add('active');
        });
    });
});