var main = {

    init : function () {
        alert("ddd");
        var _this = this;
        $('#btn-graduate-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {

        var data = {
            name : $('#name').val(),
            interview_content : $('#interview_content').val(),
            company : $('#company').val(),
            companyInfo : $('#companyInfo').val(),
            work : $('#work').val(),
            fileURL : $('#fileURL').val()
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