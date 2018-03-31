$(document).ready(function () {
    $.ajax({
        url: '/cart/info',
        method: 'GET',
        success : function (cartInfo) {
            $('#cart-badge').text(cartInfo.count);
        }
    });
});