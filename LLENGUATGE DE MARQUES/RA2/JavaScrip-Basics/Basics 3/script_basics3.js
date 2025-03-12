function salute(text){
    document.getElementById("result1").innerHTML = "Propicios dias " + text;
}

function calculate(num){
    return num % 2 == 0 ? "even" : "odd";
}

function check(text){
    return text.toLowerCase() === "javascript" ? "Correct" : "Incorrect";
}

function multiply(x1, x2){
    return x1 * x2;
}

function randomNumber(max, min){
    return Math.floor(Math.random() * (Number(max) - Number(min) + 1)) + Number(min);
}

function reverseString(st){
    return st.split("").reverse().join("");
}

function squareRoot(num){
    if (num < 0)
        return "Number can't be negative";
    else
        return Math.sqrt(num);
}

function average(num1, num2, num3){
    return (Number(num1) + Number(num2) + Number(num3)) / 3;
}