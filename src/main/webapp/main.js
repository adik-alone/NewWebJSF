var x_base;
var y_base = 0;
var r_base = 1;

getStartPoint();

function CheckForm() {
    console.log(x_base);
    console.log(y_base);
    console.log(r_base);
    if (x_base == undefined || r_base == undefined) {
        const fail = "Выбраны не все значения для проверки";
        document.getElementById("error").innerHTML = fail;
        error.removeAttribute("hidden");
    } else {
        const id = localStorage.length;
        const point = x_base + " " + y_base;
        console.log(point);
        localStorage.setItem("point " + id, point);
        drawPoint(x_base, y_base);
        PostToServer(x_base, y_base, r_base);
    }
}
function ChangeY(){
    const y = document.getElementById("shoot-form:y-value").value;
    console.log(y);
    // if (y <= 3){
    //     if (y >= 3){
            y_base = y;
            console.log("y success saved ", y_base);
    //     }
    // }
}
function ChangeX(button){
    const X = button.value;
    x_base = X;
    console.log("x success saved ", x_base);
}

function PostToServer(x, y, r) {

    const data = {
        "x": x,
        "y": y,
        "r": r
    }

    // for (let [name, value] of data) {
    //     console.log(`${name} = ${value}`); // key1=value1, потом key2=value2
    // }
    var formBody = [];
    for (var property in data) {
        var encodedKey = encodeURIComponent(property);
        var encodedValue = encodeURIComponent(data[property]);
        formBody.push(encodedKey + "=" + encodedValue);
    }
    formBody = formBody.join("&");
    //console.log("Выполнили это");

    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState == XMLHttpRequest.DONE && request.status === 200) {
            // newData(request.responseText);
            // location.assign('./index.jsp');
            // window.sayHi();
            handHttpResponse(request.responseText);
        }
    };
    request.open('POST', './check', true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    // console.log(JSON.stringify(data));
    // request.send(JSON.stringify(data));
    request.send(formBody);


    // for (var key of data.keys()) {
    //     console.log(key, data.get(key));
    // }
    // xhr.send(data);
    // alert("there");

}

function clearTable(){
    localStorage.clear();
}
function getStartPoint(){
    localStorage.clear();
    const count_row = document.getElementById("table").childNodes[0].childNodes[0].childNodes[1].childNodes.length;
    // const startpoint = document.getElementsByClassName("text");
    // console.log(startpoint);
    for (let i = 0; i < count_row; i++){
        try{
            const id = localStorage.length;
            const xDateValue = document.getElementById("table:" + i + ":point-x-value");
            const yDateValue = document.getElementById("table:" + i + ":point-y-value");
            const x = xDateValue.innerHTML;
            const y = yDateValue.innerHTML;
            console.log(x, y);
            const point = x + " " + y;
            console.log(point);
            localStorage.setItem("point " + id, point);

        }catch (e){
            console.log(e);
        }
    }
}

function handleStartPoint(json){
    localStorage.clear();
    let text = JSON.parse(json);
    // console.log("before len");
    // console.log(text.points.length);
    // console.log("after");
    // console.log(text.points);
    // console.log(text.points[0]);
    for(let i = 0; i < text.points.length; i++){
        const id = localStorage.length;
        [x, y] = text.points[i].split(' ');
        // const x = text.points[i].x;
        // const y = text.points[i].y;
        const point = x + " " + y;
        // console.log(point);
        localStorage.setItem("point " + id, point);
    }
}

// ############################################### Work with canvas
// /////////////////////////////////////////////////////////////////////////////////////
// /////////////////////////////////////////////////////////////////////////////////////
// /////////////////////////////////////////////////////////////////////////////////////


function checkArea(x, y){
    let result = false;
    if(x >= 0 && y >= 0){
        if(x**2 + y**2 <= r_base**2){
            result = true;
        }
    }
    if(x < 0 && y > 0){
        result = false;
    }
    if(x >= 0 && y <= 0){
        if (y >= x/2 - r_base/2){
            result = true;
        }
    }
    if(x <=0 && y <= 0){
        if(x >= - r_base/2 && y >= -r_base){
            result = true;
        }
    }
    return result;
}

function drawPoint(x, y){

    if(checkArea(x, y)){
        ctx.fillcolor = "rgb(300, 200, 0)";
        ctx.fillStyle = "rgb(300, 200, 20)";
    }else{
        ctx.fillcolor = "rgb(206, 0, 21)";
        ctx.fillStyle = "rgb(206, 0, 21)";
    }


    ctx.beginPath();
    ctx.arc(x * size, y * size, 2, 0, 2 * Math.PI);
    ctx.fill();

    ctx.fillcolor = "#000";
    ctx.fillStyle = "#000";
}


function DrawArea(button){
    BackGroundColor("#fff");
    DrawXandY();
    const R = button.value;
    r_base = R;
    drawFigures(R);
    drawAllPoint();
}

function Changecenter(){
    ctx.translate(w/2, h/2);
    ctx.scale(1, -1);
}

function BackGroundColor(color){
    ctx.fillcolor = color;
    ctx.fillStyle = color;
    ctx.fillRect(-w/2, -h/2, w, h);

    ctx.fillcolor = "#000";
    ctx.fillStyle = "#000";
}

function DrawXandY(){

    ctx.fillRect(-1, h/2 , 1, -h);

    ctx.fillRect(-w/2, 1, w, -1);

    //стерлочки

    ctx.beginPath();
    ctx.moveTo(w/2 - 15, 5);
    ctx.lineTo(w/2, 1);
    ctx.lineTo(w/2, -1);
    ctx.lineTo(w/2 - 15, -5);
    ctx.closePath();
    ctx.fill();


    ctx.font = "20px serif"
    ctx.fillText("X", w/2 - 15, -10);
    ctx.scale(1, -1);
    ctx.fillText("Y", -35, -h/2 + 18);
    ctx.scale(1, -1);

    ctx.beginPath();
    ctx.moveTo(5, h/2 - 15);
    ctx.lineTo(1, h/2);
    ctx.lineTo(-1, h/2);
    ctx.lineTo(-5, h/2 - 15);
    ctx.closePath();
    ctx.fill();
    drawLines();
}
function drawFigures(R){
    // var R = document.getElementById("").value;

    // ctx.fillcolor = "#43aeef";
    // ctx.fillStyle = "#43aeef";
    ctx.fillcolor = "rgba(67, 174, 239, 0.7)";
    ctx.fillStyle = "rgba(67, 174, 239, 0.7)";
    // прямоугольник
    ctx.fillRect(0, -R * size, -R * size/2, R * size);
    // треугольник
    ctx.beginPath();
    ctx.moveTo(R * size, 0);
    ctx.lineTo(0, -R * size/2);
    ctx.lineTo(0, 0);
    ctx.closePath();
    ctx.fill();
    // четверть круга
    ctx.beginPath();
    ctx.arc(0, 0, R * size, 0, Math.PI/2);
    ctx.lineTo(0,0);
    ctx.closePath();
    ctx.fill();
}
function drawLines(){
    ctx.font = "12px serif";
    for (var i = size - 1; i < w/2 - 20; i += size){
        ctx.fillRect(i, size/4, 1, -1 * size/2);
        ctx.scale(1, -1);
        ctx.fillText(Math.floor(i/size + 1), i, size/4 + 15);
        ctx.scale(1, -1);
    }
    for (var i = -size - 1; i > -w/2 - 20; i -= size){
        ctx.fillRect(i, size/4, 1, -1 * size/2);
    }

    for (var j = size -1; j < h/2 - 20; j += size){
        ctx.fillRect(-size/4, j, size/2, 1);
        ctx.scale(1, -1);
        ctx.fillText(Math.floor(j/size + 1), -size/4 - 10, -j);
        ctx.scale(1, -1);
    }
    for (var j = -size - 1; j > -h/2 - 20; j -= size){
        ctx.fillRect(-size/4, j, size/2, 1);
    }
}

function validX(x){
    if (x < -4 || x > 4){
        return false;
    }else{
        return true;
    }
}
function validY(y){
    if(y <= -3 || y >= 3){
        return false;
    }else{
        return true;
    }
}

function handleClick(event) {
    console.log("handler 2");
    const rect = canvas.getBoundingClientRect();
    const x = event.clientX - rect.left - 150;
    const y = -1 * (event.clientY - rect.top - 200);
    drawPoint(x/25, y/25);
    console.log(r_base);
    if (r_base == undefined){
        console.log("here");
        error.innerHTML = "Вы не выбрали радиус";
        error.removeAttribute("hidden");
    }else{
        //validation of x and y
        if(!validX(x/25)){
            error.innerHTML = "X выходит за пределы возможного диапазона";
            error.removeAttribute("hidden");
            return;
        }
        if(!validY(y/25)){
            error.innerHTML = "Y выходит за пределы возможного диапазона";
            error.removeAttribute("hidden");
            return;
        }
        const id = localStorage.length;
        const point = x/25 + " " + y/25;
        console.log(point);
        localStorage.setItem("point " + id, point);
        // error.innerHTML = "";
        // PostToServer((x/25).toFixed(2), (y/25).toFixed(2), r_base);
        console.log(x, y, r_base);
        fillForm((x/25).toFixed(2), (y/25).toFixed(2), r_base);
    }
    // PostToServer(x, y, r_base);
}

function fillForm(x_f, y_f, r_f){
    document.getElementById("shoot-form:x-inv-value").value = x_f;
    // document.getElementById("shoot-form:invisible-button-x").click();
    document.getElementById("shoot-form:y-value").value = y_f;
    document.getElementById("shoot-form:r-inv-value").value = r_f;
    document.getElementById("shoot-form:x").innerHTML = x_f;
    document.getElementById("shoot-form:y").innerHTML = y_f;
    document.getElementById("shoot-form:r").innerHTML = r_f;
    // document.getElementById("shoot-form").submit();
    document.getElementById("shoot-form:inv-button-submit").click();
}
function drawAllPoint(){
    for(let i = 0; i < localStorage.length; i++) {
        const point = localStorage.getItem("point " + i);
        const [x_now, y_now] = point.split(" ");
        // console.log(x_now, y_now);
        drawPoint(x_now, y_now);
        // console.log(point);
    }
}




// fillThetabel();

var error = document.getElementById("error");
// error.setAttribute("hidden");


var canvas = document.getElementById("MyCanvas");
const ctx = canvas.getContext('2d');
canvas.width = 300;
canvas.hieght = 400;


// canvas.addEventListener("click", function (event){
//     console.log("Handler1");
//     drawPoint(event.clientX, event.clientY);
// });

canvas.addEventListener("click", handleClick);




// ctx.beginPath();
// ctx.moveTo(150, 0);
// ctx.lineTo(150, 405);
// ctx.moveTo(0, 202.5);
// ctx.lineTo(300, 202.5);

ctx.fillStyle = "#fff";
ctx.fillcolor = "#fff";
ctx.fillRect(0, 0, 300, 400);

ctx.fillStyle = "black";
ctx.fillcolor = "black";

const w = 300;
const h = 400;
const size = 25;

Changecenter();
BackGroundColor("#fff");
DrawXandY();
drawFigures();
// ctx.fillRect(0, 199, 300, 1);
// ctx.fillRect(149, 0, 1, 400);
// ctx.beginPath();
// ctx.moveTo(285, 194.5);
// ctx.lineTo(300, 199.5);
// ctx.lineTo(285, 205);
// ctx.closePath();
// ctx.fill();
//
// ctx.beginPath();
// ctx.moveTo(145, 15);
// ctx.lineTo(150, 0);
// ctx.lineTo(155, 15);
// ctx.closePath();
// ctx.fill();
// ctx.translate(150, 200);
// ctx.scale(1, -1);

// ctx.fillRect(0, 0, 10, -10);

// for(var i = -141; i < 130; i += 20){
//     ctx.fillRect(i, 5, 1, -9);
// }
// for(var i = -191; i < 170; i += 20){
//     ctx.fillRect(-5, i, 9, -1);
// }
// drawLines(ctx, size, 300, 400);
drawFigures(ctx, size);
drawAllPoint();
// drawFigures(ctx, -100);



