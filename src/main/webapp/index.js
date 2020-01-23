
///////////INDEX////////////////////
let solarSystem = $("#solarSystem");

let updateSolarSystem = function(planets) {
    for (let i = 0; i < planets.length; i++) {
        let offsetAngle = 360 / planets.length;
        let rotateAngle = offsetAngle * i;
        $(planets[i]).css("transform", "rotate(" + rotateAngle + "deg) translate(0, -200px) rotate(-" + rotateAngle + "deg)")
    }
};

$(window).on("load", function () {
    let planets = $(".planet");
    updateSolarSystem(planets);
});

$(document).on("click", ".remove-planet", function() {
    $(this).parent().remove();
    let planets = $(".planet");
    updateSolarSystem(planets);
});


////////////////NAVBAR////////////////////
const input = document.getElementById("search-input");
const searchBtn = document.getElementById("search-btn");

const expand = () => {
    searchBtn.classList.toggle("close");
    input.classList.toggle("square");
};

searchBtn.addEventListener("click", expand);


////////////planet/////////
$(document).on("click", "#buy",function () {
    alert("Thank you for your purchase.");
});

$(document).on("click", "#update",function (){
    $("#updateUserForm").toggle();
    if($("#createPlanet").css('display') == "block")
    {
     $("#createPlanet").toggle();
    }
});

///////////create planet///////////////

$(document).on("click", "#create",function () {
    $("#createPlanet").toggle();
    if($("#updateUserForm").css('display') == 'block')
    {
        $("#updateUserForm").toggle();
    }
});