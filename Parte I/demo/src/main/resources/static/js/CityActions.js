function update(id) {
    var country = document.getElementById("editCityCountry").value;
    var name = document.getElementById("editCityName").value;

    if (country === "" || name === "") {
        alert("Please fill all the fileds !");
        return false;
    }

    var cityData = {
        country: country,
        name: name,
        id: id
    };

    var jsonData = JSON.stringify(cityData);
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("La ville a été mise à jour avec succès !");
                window.location.href = '/city/show';
            } else {
                console.error("Erreur lors de la mise à jour de la ville :", xhr.status);
            }
        }
    };

    xhr.open("PUT", "/city/update/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(jsonData);
}

function deleteCity(id) {
    var confirmDelete = confirm("Are you sure to delete this City ?");
    if (!confirmDelete) {
        console.log("Delete canceled");
        return false;
    }

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log("La ville a été supprimé avec succès !");
                window.location.href = '/city/show';
            } else {
                console.error("Erreur lors de la suppression à jour de la ville :", xhr.status);
            }
        }
    };

    xhr.open("DELETE", "/city/delete/"+id, true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send();
}