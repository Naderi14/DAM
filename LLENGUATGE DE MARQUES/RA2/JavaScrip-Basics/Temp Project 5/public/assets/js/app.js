function calculate(temp, tempfrom, tempto) {
    //TODO
    document.getElementById('result').value = "Hola mundo";
    //Check values of tempfrom and tempto and call the corresponding function
    if (tempfrom == 'celsius' && tempto == 'fahrenheit') {
        let t = c2f(temp);
        //After calling the function, show result and formulae
        document.getElementById('result').value = round(t, 2) + "ºF";
        document.getElementById('formula').innerHTML = "F = XXXXX";
    }
    else if (tempfrom == 'fahrenheit' && tempto == 'celsius') {
        let t = f2c(temp);

        document.getElementById('result').value = round(t, 2) + "ºC";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'celsius' && tempto == 'kelvin') {
        let t = c2k(temp);

        document.getElementById('result').value = round(t, 2) + "ºK";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'celsius' && tempto == 'rankine') {
        let t = c2r(temp);

        document.getElementById('result').value = round(t, 2) + "ºR";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'fahrenheit' && tempto == 'kelvin') {
        let t = f2k(temp);

        document.getElementById('result').value = round(t, 2) + "ºK";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'fahrenheit' && tempto == 'rankine') {
        let t = f2r(temp);

        document.getElementById('result').value = round(t, 2) + "ºR";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'kelvin' && tempto == 'celsius') {
        let t = k2c(temp);

        document.getElementById('result').value = round(t, 2) + "ºC";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'kelvin' && tempto == 'fahrenheit') {
        let t = k2f(temp);

        document.getElementById('result').value = round(t, 2) + "ºF";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'kelvin' && tempto == 'rankine') {
        let t = k2r(temp);

        document.getElementById('result').value = round(t, 2) + "ºR";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'rankine' && tempto == 'celsius') {
        let t = r2c(temp);

        document.getElementById('result').value = round(t, 2) + "ºC";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'rankine' && tempto == 'fahrenheit') {
        let t = r2f(temp);

        document.getElementById('result').value = round(t, 2) + "ºF";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else if (tempfrom == 'rankine' && tempto == 'kelvin') {
        let t = r2k(temp);

        document.getElementById('result').value = round(t, 2) + "ºK";
        document.getElementById('formula').innerHTML = "C = XXXXX";
    }
    else{
        document.getElementById('result').value = temp;
    }
    
}

function c2f(c) {
    return c * (9 / 5) + 32;
};

function c2k(c) {
    return c + 273.15;
};

function c2r(c) {
    return c * (9 / 5) + 32 + 459.67;
};

function f2c(f) {
    return (f - 32) * 5 / 9;
}

function f2k(f) {
    return (f - 32) * 5 / 9 + 273.15;
}

function f2r(f) {
    return f + 459.67;
}

function k2c(k) {
    return k - 273.15;
}

function k2f(k) {
    return k * (9 / 5) - 459.67;
}

function k2r(k) {
    return k * 9 / 5;
}

function r2c(r) {
    return (r - 32 - 459.67) * 9 / 5;
}

function r2f(r) {
    return r - 459.67;
}

function r2k(r) {
    return r * 5 / 9;
}

function round(num, dec) {
    //TODO
    //Round a number (num) to a specified number of decimals (dec)
    return Math.round((num) * dec) / dec;
}