var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var time = new Date();
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val(),
            send_time : "time",
            read_mark : "false",
            visibility : "false"
        };
        alert(JSON.stringify(data));
        $.ajax({
            type: "GET",
            async: "false",
            url: "https://co-ari.o-r.kr:8080/api/alarms",
            dataType: "jsonp",
            data: {
                title : $('#title').val(),
                author : $('#author').val(),
                content : $('#content').val(),
                send_time : "time",
                read_mark : "false",
                visibility : "false"
            },
         //***************************** callback
            callback : "list" ,
         // ********************************
            success : function(data) {
                  $(data.addr).each(function(key, val){
                       alert(val.apt); 
                  });
            },
            error : function(){
                   alert("Fail");
            }
          
          
         });
        // $.ajax({
        //     type: 'POST',
        //     url: 'https://wwww.co-ari.o-r.kr:8080/api/alarms',
        //     dataType: 'jsonp',
        //     contentType:'application/json; charset=utf-8',
        //     data: JSON.stringify(data)
        // }).done(function() {
        //     alert('알림이 등록되었습니다.');
        //     window.location.href = '/';
        // }).fail(function (error) {
        //     alert(JSON.stringify(error));
        // });
    }
    
};

main.init();