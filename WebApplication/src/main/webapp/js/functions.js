function validate(parent, regex, tooltipName, tooltipMessage) {
    let element = getTooltip(tooltipName);
    if (!regex.test(parent.value)) {
        element.className = ERROR_CLASS;
        element.innerHTML = tooltipMessage;
        parent.after(element);
    }
    return true;
}

function dataAgreement() {
    let agreement = document.getElementsByName("agreement")[0];
    if (!agreement.checked) {
        agreement.parentElement.style.color = "red";
        return false;
    }
    agreement.checked = false;
    return true;
}

function passwordValidation(password, repeatedPassword) {
    let pass = getTooltip(PASSWORD_TOOLTIP);
    let passRepeat = getTooltip(REPEATED_PASSWORD_TOOLTIP);
    if (!PASSWORD_REGEX.test(password.value)) {
        pass.className = ERROR_CLASS;
        pass.innerHTML = WRONG_PASSWORD;
        password.after(pass);
        password.value = "";
        repeatedPassword.value = "";
        return false;
    }

    if (password.value != repeatedPassword.value) {
        passRepeat.className = ERROR_CLASS;
        passRepeat.innerHTML = PASSWORD_DOESNT_MATCHES;
        repeatedPassword.after(passRepeat);
        password.value = "";
        repeatedPasswor.value = "";
        return false;
    }
    return true;
}

function getTooltip(elementId) {
    let tooltip = document.getElementById(elementId);
    if (tooltip == null) {
        tooltip = document.createElement(DIV);
    }
    tooltip.setAttribute(ID, elementId);
    return tooltip;
}
