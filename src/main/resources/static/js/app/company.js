var main = {

    init : function () {
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
            work : $('#work').val()
        };

        var form = $('#graduateForm')[0];

        var formData = new FormData(form);
//        var blob = new Blob()
        formData.append('key', new Blob([JSON.stringify(data)], {type: "application/json"}));
//        formData.append('key', new Blob([JSON.stringify(data)], {type: "application/json"});
//        formData.append('file', $('#image'));
        formData.append('file', document.getElementById('image').files[0])
        alert(formData.get('key'));

         $.ajax({
             type: 'POST',
             url: '/api/graduates',
             processData: false,
             contentType: false,
             data: formData
         }).done(function() {
             alert('졸업생 정보가 등록되었습니다.');
             window.location.href = '/';
         }).fail(function (error) {
             alert(JSON.stringify(error));
         });
    }
};

main.init();