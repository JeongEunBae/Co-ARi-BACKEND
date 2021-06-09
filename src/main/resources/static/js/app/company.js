var main = {

    init : function () {
        alert("ddd");
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
                    pose : $('#pose_x').val() + ":" + $('#pose_y').val() ":" + $('#pose_z').val(),
                    department : $('#department').val(),
                    buildingName : $('#buildingName').val(),
                    floor : $('#floor').val()
        };

         $.ajax({
             type: 'POST',
             url: '/api/graduates',
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