var main = {
    init : function () {
        var _this = this;
        $('#btn-re').on('click', function () {
            _this.save();
        });
    },
    save : function () {
    $.ajax({
            type: 'GET',
            dataType: "json",
            url: "/api/anchors/search/",
            mimeType: "application/json",
            success: function(result){
                alert("새로고침이 완료되었습니다.");
            }
        });
    }
};
main.init();