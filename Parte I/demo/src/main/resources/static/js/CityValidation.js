document.getElementById("cityAddForm").addEventListener("submit", function(event) {
    var country = document.getElementById("addCountry").value;
    var name = document.getElementById("addName").value;

    if (country === "" || name === "") {
        event.preventDefault();
        alert("Please fill all the fileds !");
    }
});
