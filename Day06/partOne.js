"use strict";

//readTextFile("file:///C:/Users/Thies/Documents/Advend of Code 2020/Day06/input06.txt");

function readTextFile(file)
{
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, false);
    rawFile.onreadystatechange = function ()
    {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
                var allText = rawFile.responseText;
                alert(allText);
            }
        }
    }
    rawFile.send(null);
}

fetch('file:///C:/Users/Thies/Documents/Advend of Code 2020/Day06/input06.txt')
  .then(response => response.text())
  .then(text => console.log(text))