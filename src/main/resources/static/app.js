var stompClient = null;
var firstConnection = true;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/public', function (message) {
            var obj = JSON.parse(message.body)
            if (firstConnection) {
                for (let i = 0; i < Object.keys(obj).length; i++) {
                    var id = obj[i].messageId;
                    var context = obj[i].context;
                    var sender = obj[i].sender;
                    var str = "ID: " + id + "\tMESSAGE: " + context + "\tSENDER: " + sender;
                    showMessage(str);
                }
                firstConnection = false;
            }
            else {
                var id_2 = obj.messageId;
                var context_2 = obj.context;
                var sender_2 = obj.sender;
                var str_2 = "ID: " + id_2 + "\tMESSAGE: " + context_2 + "\tSENDER: " + sender_2;
                showMessage(str_2);
            }
        });
    });

}


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
    firstConnection = true;
}

function sendMessage() {
    stompClient.send("/app/chat/send-message", {}, JSON.stringify({'context': $("#context").val(), 'sender': $("#sender").val()}));
}

function getAllMessages() {
    stompClient.send("/app/chat/get-all", {})
}

function showMessage(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
    $( "#get-all" ).click(function() { getAllMessages(); });
});