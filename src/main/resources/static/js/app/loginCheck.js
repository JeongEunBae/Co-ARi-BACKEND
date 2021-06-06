

    var main = {

        init : function () {
            var _this = this;
            $('#btn-ok').on('click', function () {
                _this.save();
            });

        },
        save : function () {
        var id = $('#user_id').val();
        var password = $('#user_password').val()

        $.ajax({
                dataType: "json",
                url: "/api/users/" + id ,
                mimeType: "application/json",
                success: function(result){
                    var user_id = "";
                    var user_pw = "";

                    $.each(result, function(index, value) {
                        user_id = value.id;
                        user_pw = value.password;
                        if ((user_id == id) && (user_pw==password)){
                            alert("로그인 성공했습니다.");
                            location.href="/";
                        }else{
                            alert("아이디 혹은 비밀번호를 확인해 주십시오");
                        }

                    });

                }
            });


        }

    };

    main.init();
