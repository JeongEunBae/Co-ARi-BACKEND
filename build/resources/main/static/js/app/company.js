var main = {
    init : function () {
        var _this = this;
        $('#btn-anchor-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
                    roomNumber : $('#roomNumber').val(),
                    roomName : $('#roomName').val(),
                    roomContent : $('#roomContent').val(),
                    pose : ,
                    department : $('#department').val(),
                    buildingName : $('#buildingName').val(),
                    floor : $('#floor').val()
        };
        alert(JSON.stringify(data));

         $.ajax({
             type: 'POST',
             url: '/api/anchors',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
         }).done(function() {
             alert('졸업생 정보가 등록되었습니다.');
             window.location.href = '/';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
    }
};

main.init();