document.getElementById("clubAddForm").addEventListener("submit", function(event) {
    var name = document.getElementById("addClubName").value;

    if (name === "") {
        event.preventDefault();
        alert("Please fill all the fileds !");
    }
});
