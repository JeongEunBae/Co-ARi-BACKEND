var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val(),
            send_time : $('#send_time').val(),
            read_mark : $('#read_mark').val(),
            visibility : $('#visibility').val()
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
    },
    update : function () {
        var data = {
            read_mark : $('#read_mark').val(),
            visibility : $('#visibility').val()
        };

        var alarm_id = $('#alarm_id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/alarms/' + alarm_id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('알림이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var alarm_id = $('#alarm_id').val();

        $.ajax({
            type : 'DELETE',
            url: '/api/alarms/' + alarm_id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('알림이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();