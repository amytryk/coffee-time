$(document).ready(function () {
    $('.update_product').on('submit', function(e){
        e.preventDefault();
        var cartForm = $(this).serialize();
        var action = $(this).attr('action');
        $.ajax({
            url: action,
            method: 'POST',
            data: cartForm,
            success : function (response) {
                if(response){
                    window.location.reload();
                }
            }
        });
    });
});