document.getElementById("clubAddForm").addEventListener("submit", function(event) {
    var name = document.getElementById("addClubName").value;
    var city = document.getElementById("addClubCity").value;
    var country = document.getElementById("addClubCountry").value;

    if (name === "" || city == "" || country == "") {
        event.preventDefault();
        alert("Please fill all the fileds !");
    }
});
