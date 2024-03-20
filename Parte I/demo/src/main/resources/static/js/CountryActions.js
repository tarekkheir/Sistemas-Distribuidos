function update(id) {
    var name = document.getElementById("editCountryName").value;

    if (name === "") {
        alert("Please fill all the fileds !");
        return false;
    }

    var countryData = {
        name: name,
        id: id
    };

    var jsonData = JSON.stringify(countryData);
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("The city has been successfully updated !");
                window.location.href = '/country/show';
            } else {
                console.error("Error while updating city :", xhr.status);
            }
        }
    };

    xhr.open("PUT", "/country/update/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(jsonData);
}

function deleteCountry(id) {
    var confirmDelete = confirm("Are you sure to delete this Country ?");
    if (!confirmDelete) {
        console.log("Delete canceled");
        return false;
    }

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("The country has been successfully deleted !");
                window.location.href = '/country/show';
            } else {
                console.error("Error while deleting the country :", xhr.status);
            }
        }
    };

    xhr.open("DELETE", "/country/delete/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}