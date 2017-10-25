$("#afm").focusout(function (e) {
    var url=document.getElementById("afm").value;
    console.log(url);
    $.ajax({
        type: "GET",
        url: "/admin/api/".concat(url),
        success: function() {
            document.getElementById("afm").style.borderColor = "green";
            var resetBtn = document.getElementById("btn");
            resetBtn.disabled = false;
        },
        error: function(){
            document.getElementById("afm").style.borderColor = "red";
            var resetBtn = document.getElementById("btn");
            resetBtn.disabled = true;
        }

    });
});