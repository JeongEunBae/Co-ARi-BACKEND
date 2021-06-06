var main = {

    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

    },
    save : function () {

        var data = {
            Image : $('#Image').val(),
            name : $('#name').val(),
            interview_content : $('#interview_content').val(),
            company : $('#company').val(),
            companyInfo : $('#companyInfo').val(),
            work : $('#work').val()
        };
        alert(JSON.stringify(data));

         $.ajax({
             type: 'POST',
             url: '/api/graduates',
             dataType: 'json',
             contentType:'application/json; charset=utf-8',
             data: JSON.stringify(data)
         }).done(function() {
             alert('교수 정보가 등록되었습니다.');
             window.location.href = '/';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
    }

};

main.init();