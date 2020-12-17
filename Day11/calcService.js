"use strict";

(function () {

    function countStableState(nextRoundFunc, outputSelector) {
        let lines = window.dataService.getData().split("\n");
        let nextRoundLines = nextRoundFunc(lines);
        while (roundChanged(lines, nextRoundLines)) {
            if(outputSelector){
                let outputString = "<br><br>";
                for (let line of lines){
                    outputString += line + "<br>";
                }
                document.querySelector(outputSelector).innerHTML += outputString;
            }
            //debugger;
            lines = nextRoundLines;
            nextRoundLines = nextRoundFunc(lines);
        }

        return countOccupied(lines);
    }

    function countOccupied(lines) {
        let counter = 0;
        for (let line of lines) {
            for (let c of line) {
                if (c == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    function roundChanged(currentLines, nextRoundLines) {
        for (let index = 0; index < currentLines.length; index++) {
            if (!(currentLines[index] === nextRoundLines[index])) {
                return true;
            }
        }
        return false;
    }

    function getNextRoundPartOne(currentRoundLines) {
        let nextRoundLines = [];
        for (let lineNr = 0; lineNr < currentRoundLines.length; lineNr++) {
            let line = currentRoundLines[lineNr];
            let nextRoundLine = "";
            for (let pos = 0; pos < line.length; pos++) {
                let c = line[pos];
                if (c == 'L') {
                    nextRoundLine += countOccupiedArroundPartOne(lineNr, pos, currentRoundLines) == 0 ? '#' : 'L';
                } else if (c == '.') {
                    nextRoundLine += '.';
                } else if (c == '#') {
                    nextRoundLine += countOccupiedArroundPartOne(lineNr, pos, currentRoundLines) >= 4 ? 'L' : '#';
                }
            }
            nextRoundLines.push(nextRoundLine);
        }
        return nextRoundLines;
    }

    function countOccupiedArroundPartOne(lineNr, pos, lines) {
        let count = 0;
        for (let lineOffset = -1; lineOffset <= 1; lineOffset++) {
            for (let posOffset = -1; posOffset <= 1; posOffset++) {
                if (lineOffset == 0 && posOffset == 0) {
                    //dont check seat itsself
                    continue;
                } else if ((pos == 0 && posOffset == -1) ||
                    (pos == lines[lineNr].length - 1 && posOffset == 1) ||
                    (lineNr == 0 && lineOffset == -1) ||
                    (lineNr == lines.length - 1 && lineOffset == 1)) {
                    //dont check positions outside array
                    continue;
                } else if (lines[lineNr + lineOffset][pos + posOffset] == '#') {
                    //count occupied seats
                    count++;
                }
            }
        }
        return count;
    }

    function getNextRoundPartTwo(currentRoundLines) {
        let nextRoundLines = [];
        for (let lineNr = 0; lineNr < currentRoundLines.length; lineNr++) {
            let line = currentRoundLines[lineNr];
            let nextRoundLine = "";
            for (let pos = 0; pos < line.length; pos++) {
                let c = line[pos];
                if (c == 'L') {
                    nextRoundLine += countOccupiedArroundPartTwo(lineNr, pos, currentRoundLines) == 0 ? '#' : 'L';
                } else if (c == '.') {
                    nextRoundLine += '.';
                } else if (c == '#') {
                    nextRoundLine += countOccupiedArroundPartTwo(lineNr, pos, currentRoundLines) >= 5 ? 'L' : '#';
                }
            }
            nextRoundLines.push(nextRoundLine);
        }
        return nextRoundLines;
    }

    function countOccupiedArroundPartTwo(lineNr, pos, lines) {
        let count = 0;
        for (let lineOffset = -1; lineOffset <= 1; lineOffset++) {
            for (let posOffset = -1; posOffset <= 1; posOffset++) {
                if (lineOffset == 0 && posOffset == 0) {
                    //dont check seat itsself
                    continue;
                } else {
                    count += occupiedInDirection(lineNr, pos, lineOffset, posOffset, lines);
                }
            }
        }
        return count;
    }

    function occupiedInDirection(lineNr, pos, lineOffset, posOffset, lines) {
        if ((pos == 0 && posOffset == -1) ||
            (pos == lines[lineNr].length - 1 && posOffset == 1) ||
            (lineNr == 0 && lineOffset == -1) ||
            (lineNr == lines.length - 1 && lineOffset == 1) ||
            (lines[lineNr + lineOffset][pos + posOffset] == 'L')) {
            //noone visible
            return 0;
        } else if (lines[lineNr + lineOffset][pos + posOffset] == '#') {
            //count as occupied seat
            return 1;
        }
        return occupiedInDirection(lineNr + lineOffset, pos + posOffset, lineOffset,
            posOffset, lines);

    }

    function calcPart1() {
        return countStableState(getNextRoundPartOne);
    }

    function calcPart2() {
        return countStableState(getNextRoundPartTwo, ".soltionTwoOutput");
    }

    window.calcService = {
        calcPart1,
        calcPart2
    }
})();