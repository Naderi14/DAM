function focus() {
    document.getElementById("number").focus();
}

function execute(number) {
    let n = parseInt(number);
    if (checkValues(n)) {
        
        let dice = generateDice(n);
        document.getElementById("title-results").innerHTML = "<h4>Results</h4>";
        showDice(dice);
        showNumbers(dice);
        showTotal(dice);
    }
}

function checkValues(number) {
    if (isNaN(number))
    {   
        document.getElementById("error-msg").innerHTML = '<h5 class="text-danger">Please enter a number</h5>';
        focus();
        return false;
    }
    else if (Number(number) <= 0)
    {
        document.getElementById("error-msg").innerHTML = '<h5 class="text-danger">Please enter a number bigger than 0</h5>';
        focus();
        return false;
    }
    else
    {
        document.getElementById("error-msg").innerHTML = '';
        return true;
    }    
}

function generateDice(number) {
    let dice = [];
    for (let i = 0; i < Number(number); i++)
    {
        dice[i] = Math.floor(Math.random() * 6) + 1;
    }

    return dice;
}

function showDice(dice) {
    let content = '';
    for (let i = 0; i < dice.length; i++)
    {
        content += '<div class="col-md-2 py-2"><img class="w-100" src="assets/images/d6-' + dice[i] + '.png"></div>';
    }

    document.getElementById("results").innerHTML = content;
}

function showNumbers(dice) {

    let content = 'The values are: ';
    for (let i = 0; i < dice.length; i++)
    {
        content += dice[i] + ' ';
    }

    document.getElementById("dice-numbers").innerHTML = content;
}

function showTotal(dice) {
    let sum = 0;
    for (let i = 0; i < dice.length; i++)
    {
        sum += dice[i];
    }

    document.getElementById("dice-total").innerHTML = 'Total: ' + sum;
}