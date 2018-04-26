function _change() {
    $("#vCode").attr("src", "/roads/captcha/getCaptchaImage.action?timestamp=" +new Date().getTime());
}
