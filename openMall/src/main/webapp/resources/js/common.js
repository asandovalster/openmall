var startFrom = 180;//#{systemController.getSessionDuration()}; // Total session time out setting eg 10 sec, Real implementation assign values from jsf controller
var loopTill = 5;//#{systemController.getSessionTimeoutAlertDuration()}; //Count down degins from 6 sec and starts after 4 sec ie 10-6
var reduce = 1;
var handleDialog = null;
var redirectPage = "logon.xhtml";
var countDownDiv = "dialog-countdown";

function resetPageTimer() {
timeoutDialog.hide();
startPageTimer(startFrom, loopTill);
clearInterval(handleDialog);
}

function startDialogTimer(wCounter, timeOutPage) {
var e = null;
if(!e)
e = document.getElementById(countDownDiv);
e.innerHTML = wCounter;
handleDialog = setInterval(function() {
if(wCounter == 0) {
clearInterval(handleDialog);
window.location.href = timeOutPage;
}
else {
wCounter -= reduce;
e.innerHTML = wCounter;
}
}, reduce * 1000);
}

function startPageTimer(wFrom, wReach) {
var handle = null;
handle = setInterval(function() {
if(wFrom == wReach) {
clearInterval(handle);
timeoutDialog.show();
startDialogTimer(loopTill, redirectPage);
}
else {
wFrom -= reduce;
}
}, reduce * 1000);
}
startPageTimer(startFrom, loopTill);