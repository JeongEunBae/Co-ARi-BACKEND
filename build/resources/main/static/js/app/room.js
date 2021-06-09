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
            pose : $('#pose_x').val() + ":" + $('#pose_y').val() ":" + $('#pose_z').val(),
            department : $('#department').val(),
            buildingName : $('#buildingName').val(),
            floor : $('#floor').val()
        };

        var form = $('#anchorForm')[0];
        //
        var formData = new FormData(form);
        ////        var blob = new Blob()
        formData.append('key', new Blob([JSON.stringify(data)], {type: "application/json"}));
        ////        formData.append('key', new Blob([JSON.stringify(data)], {type: "application/json"});
        ////        formData.append('file', $('#image'));
        formData.append('file', document.getElementById('roomVideo').files[0]);
        alert(formData.get('key'));
//        alert(JSON.stringify(data));

        $.ajax({
            type: 'POST',
            url: '/api/anchors',
//             dataType: 'json',
//             contentType:'application/json; charset=utf-8',
//             data: JSON.stringify(data)
           processData : false,
           contentType : false,
           data : formData
        }).done(function() {
            alert('호실 정보가 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
