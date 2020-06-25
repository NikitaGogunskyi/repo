const EMAIL_REGEX = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
const PASSWORD_REGEX = /^(?=.*[A-Z])(?=.*[0-9])\w{8,16}$/;
const NAME_REGEX = /^[a-zA-Z]+([',. -][a-zA-Z]{2,}){1,}$/;

const ERROR_CLASS = "error";
const MESSAGE_CLASS = "message";
const DIV = "div";
const ID = "id";

const EMAIL_TOOLTIP = "tooltipEmail";
const PASSWORD_TOOLTIP = "tooltipPassword";
const NAME_TOOLTIP = "tooltipName";
const REPEATED_PASSWORD_TOOLTIP = "tooltipRepeatedPassword";

const OK_MESSAGE = "OK";
const WRONG_NAME = "* Enter your full name";
const WRONG_EMAIL = "* Wrong format of email";
const WRONG_PASSWORD = "* Your password doesn't conform to secure requirements";
const PASSWORD_DOESNT_MATCHES = "* Passwords doesn't matches";
const PASSWORD_CONVENTION = "Password should contains numbers and caps";

const PASSWORD_INPUT_JQ = "input[name=password]";
const REPEATED_PASSWORD_INPUT_JQ = "input[name=repeatedPassword]";
const NAME_INPUT_JQ = "input[name=name]";
const AGREEMENT_INPUT_JQ = "input[name=agreement]";
const EMAIL_INPUT_JQ = "input[name=email]";
const AGREEMENT_LABEL_JQ = "label[for=agreement]";

const PASSWORD_TOOLTIP_ID = "#tooltipPassword";
const REPEATED_PASSWORD_TOOLTIP_ID = "#tooltipRepeatedPassword";
const EMAIL_TOOLTIP_ID = "#tooltipEmail";
const NAME_TOOLTIP_ID = "#tooltipName";

const DIV_BLOCK = "<div></div>";