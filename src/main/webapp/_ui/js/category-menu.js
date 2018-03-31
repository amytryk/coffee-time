$(document).ready(function () {
    $.ajax({
        url: '/category/root',
        method: 'GET',
        success: function (rootCategory) {
            rootCategory.subcategories.forEach(function (category) {
                var e = document.createElement('li');
                e.className = 'dropdown';
                var link = document.createElement('a');
                link.className = 'dropbtn';
                link.setAttribute('href',  '/category/' + category.id + '/products');
                link.innerHTML = category.name;
                e.appendChild(link);

                $('#category-menu').append(e);
            });
        }
    });
});