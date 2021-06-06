var main = {
    init : function () {
        var _this = this;
        $('#btn-notice-load').on('click', function () {
            _this.noticeSave();
        });

        $('#btn-news-load').on('click', function () {
            _this.newsSave();
        });
    },
    noticeSave : function () {
        $.ajax({
            type: 'GET',
            dataType: "json",
            url: "/api/notices/crawler",
            mimeType: "application/json",
            success: function(result){
                alert("새로고침이 완료되었습니다.");
            }
        });
    },
    newsSave : function () {
        $.ajax({
            type: 'GET',
            dataType: "json",
            url: "/api/news/crawler",
            mimeType: "application/json",
            success: function(result){
                alert("새로고침이 완료되었습니다.");
            }
        }).fail(function (error) {
                alert(JSON.stringify(error));
        });
    }
};
main.init();