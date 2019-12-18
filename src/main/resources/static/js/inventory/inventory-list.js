function myFunction() {
    var x;
    x = document.forms["myForm"]["quantity"].value;

    if (isNaN(x) || x < 0) {
        alert("Wartość musi być cyfrą większą od zera");
        return false;
    } else {
        return true;
    }
}