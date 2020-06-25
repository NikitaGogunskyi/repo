document.getElementsByName("password")[0].addEventListener("focus",
    function () {
        let tooltip = getTooltip(PASSWORD_TOOLTIP);
        tooltip.innerHTML = PASSWORD_CONVENTION;
        tooltip.className = MESSAGE_CLASS;
        this.after(tooltip);
    });

document.getElementsByName("password")[0].addEventListener("blur", function () {
    let tooltip = getTooltip(PASSWORD_TOOLTIP);
    tooltip.remove();
});

document.getElementsByClassName("registerbtn")[0].addEventListener("click",
    function () {
        let name = document.getElementsByName("name")[0];
        let email = document.getElementsByName("email")[0];
        let password = document.getElementsByName("password")[0];
        let repeatedPassword = document.getElementsByName("passRepeat")[0];

        if (passwordValidation(password, repeatedPassword) &
            validate(email, EMAIL_REGEX, EMAIL_TOOLTIP, WRONG_EMAIL) &
            validate(name, NAME_REGEX, NAME_TOOLTIP, WRONG_NAME) &
            dataAgreement()) {
            document.getElementById("registrationForm").submit();
        } else {

        }
    });