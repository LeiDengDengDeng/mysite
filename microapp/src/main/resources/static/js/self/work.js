function loadImages() {
    $.ajax({
        url: "/images/getAll",
        type: "GET",
        data: {},
        async: false,
        timeout: 5000,
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var li = $('<li></li>');
                li.addClass("box");
                var a = $('<a></a>');
                a.attr("href", data[i].url);
                a.addClass("magnifier");
                var img = $('<img/>');
                img.attr("alt", data[i].description);
                img.attr("src", data[i].url);
                img.attr("height", "270px");
                img.attr("width", "370px");
                img.appendTo(li);
                img.appendTo(a);
                a.appendTo(li);
                li.appendTo($("#images"));
            }
        },
        error: function (xhr, textStatus) {
        }
    })
}