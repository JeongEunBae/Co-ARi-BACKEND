var main = {

    init : function () {
        var _this = this;
        $('#btn-ok').on('click', function () {
            _this.save();
        });

    },
    save : function () {

        var data = {
            id : $('#user_id').val(),
            password : $('#user_pw').val(),
            kakao_token : "",
            google_token : ""
        };
        alert(JSON.stringify(data));

         $.ajax({
             type: 'POST',
             url: '/api/users',
             dataType: 'json',
             contentType:'application/json; charset=utf-8',
             data: JSON.stringify(data)
         }).done(function() {
             alert('관리자 정보가 등록되었습니다.');
             window.location.href = '/';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
    }

};

main.init();