var main = {

    init : function () {
        var _this = this;
        $('#btn-ok').on('click', function () {
            _this.save();
        });

    },
    save : function () {

        var data = {
            roomNumber : $('#roomNumber').val(),
            roomName : $('#roomName').val(),
            roomContent : $('#roomContent').val(),
            roomVideo : $('#roomVideo').val(),
            pose_x : $('#pose_x').val(),
            pose_y : $('#pose_y').val(),
            pose_z : $('#pose_z').val(),
            department : $('#department').val(),
            buildingName : $('#buildingName').val(),
            floor : $('#floor').val(),
            startPoint : $('#startPoint').val(),
            planeWidthSize : $('#planeWidthSize').val(),
            planeHeightSize : $('#planeHeightSize').val()
        };
        alert(JSON.stringify(data));

         $.ajax({
             type: 'POST',
             url: '/api/anchors',
             dataType: 'json',
             contentType:'application/json; charset=utf-8',
             data: JSON.stringify(data)
         }).done(function() {
             alert('호실 정보가 등록되었습니다.');
             window.location.href = '/';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
    }

};

main.init();