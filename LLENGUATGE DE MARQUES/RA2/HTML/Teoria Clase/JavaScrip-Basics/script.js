// Exercici 1
function saludar(){ 
    // Hola mundo
    console.log("Hola mundo!")
}

// Exercici 2
function sumarNumeros(){
    // Sumar numeros declarando variables
    let a = 5
    let b = 2 + 2
    let c = a + b
    console.log("Esto es el valor de c: " + c)
    console.log("Valor de b: " + b)
    console.log("Valor de a: " + a)
}

// Exercici 3
function saludarNombre(){
    // Pedir nombre al usuario y saludarlo
    let nombre = prompt("Enter your name")

    console.log("Buenos dias " + nombre)
}

// Exercici 4
function condicional(){
    let a = prompt("Ingresa un numero")
    let result

    if (a % 2 == 0)
        result = "El número es par"
    else
        result = "El número es impar"

    document.getElementById("demo").innerHTML = result
}

// Exercici 5
function contador(){
    let result = ""
    for (let i = 1; i <= 10; i++){
        result += "Contando " + i + "<br>"
    }

    document.getElementById("demo").innerHTML = result
}

// Exercici 6
function arrayThings(){
    let miArray = [1,2,3,4,5,6,7,8,9]
    let total1 = 0
    let total2 = 0

    for (let i = 1; i <= miArray.length; i++){
        total1 += miArray[i-1]
    }

    for (let num of miArray){
        total2 += num
    }

    document.getElementById("demo").innerHTML += "Total for I:" + total1
    document.getElementById("demo").innerHTML += "Total for each:" + total2
}

// Exercici 7
function verifyWord(){
    let palabra = prompt("Introduce la palabra secreta")

    if (palabra.toLowerCase() === "javascript")
        document.getElementById("demo").innerHTML = "Correcto"
    else
        document.getElementById("demo").innerHTML = "Incorrecto"
}

// Exercici 8
function multiplyNumbers(a, b){
    let result = a * b
    document.getElementById("demo").innerHTML = a + " x " + b + " = " + result
}

// Exercici 9
function randomNumber(){
    let numRandom = Math.trunc(Math.random() * 100)
    document.getElementById("demo").innerHTML = "Random number: " + numRandom
}

// Exercici 10
function invertirCadena(){
    let cadena = prompt("Introduce un texto")
    let cadenaInvertida = ""
    for (let index = cadena.length - 1; index >= 0; index--)
    {
        cadenaInvertida += cadena[index]
    }

    document.getElementById("demo").innerHTML = cadenaInvertida
}