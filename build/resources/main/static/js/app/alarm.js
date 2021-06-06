var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var date = new Date().toISOString().slice(0, 19).replace('T', ' ');

        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val(),
            send_time : date,
            read_mark : "FALSE",
            visibility : "FALSE"
        };
        $.ajax({
            type: 'POST',
            url: '/api/alarms',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('알림이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();