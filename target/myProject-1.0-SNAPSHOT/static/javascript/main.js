$(".inval").hide();
$(".login").hide();
$(".logsucc").hide();


$("#registrbut").click(function () {
    var username = $("#username").val();
    var email = $("#email").val();
    var phone = $("#phone").val();
    var password = $("#password").val();
    var confirmationpass = $("#passwordconfirm").val();
    var user = JSON.stringify({username: username, email: email, phone: phone, password: password, confirmationpass: confirmationpass});

    var csrfHeader = $("meta[name='_csrf_header']").attr("content");
    var csrfToken = $("meta[name='_csrf']").attr("content");
    
    var headers = {};
    headers[csrfHeader] = csrfToken;

    $.ajax({
        url: '/saveUser',
        type: 'post',
        headers: headers,
        data:  user,
        contentType: 'application/json',
        success: function (result) {
            $(".logsucc").show();
            $(".inval").hide();
        },
        error: function () {
            $(".inval").show();
            $(".logsucc").hide();
        }
    });
    
    // $.ajax({
    //     url: '/login',
    //     type: 'get',
    //     headers: headers,
    //     data: JSON.stringify(user),
    //     contentType: 'application/json',
    //     success: function () {
    //
    //     },
    //     error: function () {
    //         $(".inval").show();
    //     }
    // })
});
