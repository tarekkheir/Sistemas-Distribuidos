function update(id) {
    var name = document.getElementById("editClubName").value;
    var city = document.getElementById("editClubCity").value;
    var country = document.getElementById("editClubCountry").value;

    if (name === "" || city == "" || country == "") {
        alert("Please fill all the fileds !");
        return false;
    }

    var clubData = {
        country: country,
        city: city,
        name: name,
        id: id
    };

    var jsonData = JSON.stringify(clubData);
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("The club has been successfully updated!");
                window.location.href = '/club/show';
            } else {
                console.error("Error while updating the club :", xhr.status);
            }
        }
    };

    xhr.open("PUT", "/club/update/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(jsonData);
}

function deleteClub(id) {
    var confirmDelete = confirm("Are you sure to delete this Club ?");
    if (!confirmDelete) {
        console.log("Delete canceled");
        return false;
    }

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("The club has been successfully deleted !");
                window.location.href = '/club/show';
            } else {
                console.error("Error while deleting the club :", xhr.status);
            }
        }
    };

    xhr.open("DELETE", "/club/delete/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}