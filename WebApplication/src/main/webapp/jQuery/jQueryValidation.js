$(document).ready(function () {

    function passwordConvention() {
        let password = $(PASSWORD_INPUT_JQ);
        let tooltip = $(PASSWORD_TOOLTIP_ID).length ? $(PASSWORD_TOOLTIP_ID) : $(DIV_BLOCK);
        if (!PASSWORD_REGEX.test(password.val())) {
            tooltip.html(PASSWORD_CONVENTION);
            tooltip.attr(ID, PASSWORD_TOOLTIP);
            tooltip.attr("class", ERROR_CLASS);
        } else {
            tooltip.html(OK_MESSAGE);
            tooltip.attr(ID, PASSWORD_TOOLTIP);
            tooltip.attr("class", MESSAGE_CLASS);
        }
        password.after(tooltip);
    }

    function passwordValidation() {
        let password = $(PASSWORD_INPUT_JQ);
        if (!PASSWORD_REGEX.test(password.val())) {
            password.val("");
            let tooltip = $(PASSWORD_TOOLTIP_ID).length ? $(PASSWORD_TOOLTIP_ID) : $(DIV_BLOCK);
            tooltip.html(WRONG_PASSWORD);
            tooltip.attr(ID, PASSWORD_TOOLTIP);
            tooltip.attr("class", ERROR_CLASS);
            password.after(tooltip);
            return false;
        }
        return true;
    }

    function emailValidation() {
        let email = $(EMAIL_INPUT_JQ);
        if (!EMAIL_REGEX.test(email.val())) {
            let tooltip = $(EMAIL_TOOLTIP_ID).length ? $(EMAIL_TOOLTIP_ID) : $(DIV_BLOCK);
            tooltip.html(WRONG_EMAIL);
            tooltip.attr(ID, EMAIL_TOOLTIP);
            tooltip.attr("class", ERROR_CLASS);
            email.after(tooltip);
            return false;
        }
        return true;
    }

    function nameValidation() {
        let name = $(NAME_INPUT_JQ);
        if (!NAME_REGEX.test(name.val())) {
            let tooltip = $(NAME_TOOLTIP_ID).length ? $(NAME_TOOLTIP_ID) : $(DIV_BLOCK);
            tooltip.html(WRONG_NAME);
            tooltip.attr(ID, NAME_TOOLTIP);
            tooltip.attr("class", ERROR_CLASS);
            name.after(tooltip);
            return false;
        }
        return true;
    }

    function isPasswordMatches() {
        let password = $(PASSWORD_INPUT_JQ);
        let repeatedPassword = $(REPEATED_PASSWORD_INPUT_JQ);
        if ((password.val() !== repeatedPassword.val())) {
            repeatedPassword.val("");
            let tooltip = $(REPEATED_PASSWORD_TOOLTIP_ID).length ? $(REPEATED_PASSWORD_TOOLTIP_ID) : $(DIV_BLOCK);
            tooltip.html(PASSWORD_DOESNT_MATCHES);
            tooltip.attr(ID, REPEATED_PASSWORD_TOOLTIP);
            tooltip.attr("class", ERROR_CLASS);
            repeatedPassword.after(tooltip);
            return false;
        }
        return true;
    }

    function dataAgreement() {
        let agreement = $(AGREEMENT_INPUT_JQ);
        if (!agreement.is(':checked')) {
            $(AGREEMENT_LABEL_JQ).css("color", "red");
            return false;
        }
        $(AGREEMENT_LABEL_JQ).css("color", "black");
        return true;
    }

    $(PASSWORD_INPUT_JQ).on("focus", passwordConvention);
    $(PASSWORD_INPUT_JQ).on("input", passwordConvention);
    $(PASSWORD_INPUT_JQ).on("blur", function () {
        $(PASSWORD_TOOLTIP_ID).remove();
    });

    $(".registerbtn").on("click", function () {
        if (passwordValidation() & isPasswordMatches() & emailValidation() & nameValidation() & dataAgreement()) {
            $("#registrationForm").submit();
            return true;
        } else {
            return false;
        }
    });
});