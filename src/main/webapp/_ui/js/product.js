$(document).ready(function() {
    $('.add_to_cart').on('submit', function(e){
        e.preventDefault();
        var cartForm = $(this).serialize();
        var action = $(this).attr('action');
        $.ajax({
            url: action,
            method: 'POST',
            data: cartForm,
            success : function (cartInfo) {
                $('#cart-badge').text(cartInfo.count);
                $('#add-to-cart-alert').show();
                setTimeout(function () {
                    $('#add-to-cart-alert').hide("fade", 1000);
                }, 2000);
            }
        });
    });

    $("input[name='quantity']").TouchSpin({
        initval: 1,
        min: 1
    });
});