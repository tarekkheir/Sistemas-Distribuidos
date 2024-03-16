document.getElementById("countryAddForm").addEventListener("submit", function(event) {
    var name = document.getElementById("addCountryName").value;

    if (name === "") {
        event.preventDefault();
        alert("Please fill all the fileds !");
    }
});
