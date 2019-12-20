function myFunctionForUpdate() {
    var x;
    x = document.getElementById("quantityUpdate").value;

    if (isNaN(x) || x < 0) {
        alert("Wartość musi być cyfrą większą od zera");
        return false;
    } else {
        return true;
    }
}
function myFunctionForAdd() {
    var x;
    x = document.getElementById("quantityAdd").value;

    if (isNaN(x) || x < 0) {
        alert("Wartość musi być cyfrą większą od zera");
        return false;
    } else {
        return true;
    }
}
function myFunctionForRemove() {
    var x;
    x = document.getElementById("quantityRemove").value;

    if (isNaN(x) || x < 0) {
        alert("Wartość musi być cyfrą większą od zera");
        return false;
    } else {
        return true;
    }
}