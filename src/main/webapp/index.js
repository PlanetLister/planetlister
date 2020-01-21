let solarSystem = $("#solarSystem");

let updateSolarSystem = function(planets) {
    for (let i = 0; i < planets.length; i++) {
        let offsetAngle = 360 / planets.length;
        let rotateAngle = offsetAngle * i;
        $(planets[i]).css("transform", "rotate(" + rotateAngle + "deg) translate(0, -200px) rotate(-" + rotateAngle + "deg)")
    }
};

$(document).on("click", "#add-planet", function() {
    let planet = $("<li class='planet'><br><br>Planets go here<button class='remove-planet'>Remove</button></li>");
    solarSystem.append(planet);
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

///////////create planet///////////////
$(document).on("click", "#create",function () {
    $("#createPlanet").html(
        "<form class='info' action=\"POST\">" +
        "<label for=\"pname\"><b>Planet Name:</b></label>" +
        "<input type=\"text\" placeholder=\"Enter name of planet\" name=\"pname\" required>" +
        "<br>" +
        "<label for=\"description\"><b>Description:</b></label>" +
        "<textarea style='width: 50%;" +
        " height: 150px;' placeholder=\"Enter Description\" required></textarea>" +
        "<br>" +
        "<button type=\"submit\" class='button'>Create</button>" +
        "</form>"
    );
});
