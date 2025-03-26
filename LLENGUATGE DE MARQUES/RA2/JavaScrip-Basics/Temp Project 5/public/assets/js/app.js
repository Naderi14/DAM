function calculate(temp, tempfrom, tempto) {
    //TODO
    //Check values of tempfrom and tempto and call the corresponding function
    if (tempfrom == 'celsius' && tempto == 'fahrenheit') {
        let t = c2f(temp);
        //After calling the function, show result and formulae
        document.getElementById('result').innerHTML = round(t, 2) + "ºF";
        document.getElementById('formula').innerHTML = "F = XXXXX";

    }
}

function c2f(c) {
    //TODO
    return 0;
};

function c2k(c) {
    //TODO
    return 0;
};

function c2r(c) {
    //TODO
};

function f2c(f) {
    //TODO
}

function f2k(f) {
    //TODO
}

function f2r(f) {
    //TODO
}

function k2c(k) {
    //TODO
}


function k2f(k) {
    //TODO
}


function k2r(k) {
    //TODO
}

function r2c(r) {
    //TODO
}


function r2f(r) {
    //TODO
}


function r2k(r) {
    //TODO
}

function round(num, dec) {
    //TODO
    //Round a number (num) to a specified number of decimals (dec)
    return 0;
}