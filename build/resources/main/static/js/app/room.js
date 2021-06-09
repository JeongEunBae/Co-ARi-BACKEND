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
            pose : $('#pose_x').val(),
            department : $('#department').val(),
            buildingName : $('#buildingName').val(),
            floor : $('#floor').val()
        };
        alert("dddf");
        var form = $('#anchorForm')[0];

        var formData = new FormData(form);
        formData.append('key', new Blob([JSON.stringify(data)], {type: "application/json"}));

        formData.append('file', document.getElementById('roomVideo').files[0]);
        alert(formData.get('key'));


        $.ajax({
            type: 'POST',
            url: '/api/anchors',
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
