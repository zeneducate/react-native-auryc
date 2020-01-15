var webSocket = null;
var allEvents = [];

function WebSocketTest2() {
	if ("WebSocket" in window) {
		var ws = new WebSocket("%%WEBSOCKET_URL%%");
        if (webSocket == null) {
            webSocket = ws;
        }
		ws.onopen = function() {
			// You can send data now
			ws.send("this is the message sent");
            document.write("<br>");
            document.write("Connection Established");
		};
		ws.onmessage = function(evt) {
            var dictionary = JSON.parse(evt.data);
            document.body.style.backgroundColor = "#d1d1cf";
            document.write("<br>");
            
            if (dictionary.type == "define-event") {
                allEvents.push(evt.data);
                if (dictionary.title != null) {
                    document.write("<br>");
                    document.write('<input id="nameInput' + allEvents.length + '" type="text" name="fname" value="' + dictionary.title + '">')
                    document.write("<br>");
                }
                
                if (dictionary.image != null) {
                    document.write("<br>");
                    document.write('<img src="data:image/png;base64,' + dictionary.image + '" width="200">');
                    document.write("<br>");
                }
                
                document.write("<br>");
                document.write('<button id="' + allEvents.length + '" onclick="defineEventAction(this.id)">Define Event</button>');
                document.write("<br>");
            } else {
                document.write("received: " + evt.data);
            }

        };
		ws.onclose = function() {
            alert("websocket is closed");
        };
	}
	else
	{
		alert("Browser doesn't support WebSocket!");
	}
}

function defineEventAction(clicked_id) {
    var eventNameInput = document.getElementById('nameInput' + clicked_id);
    var eventName = eventNameInput.value;
    var dict = {};
    dict["action-type"] = "defineEvent";
    dict["tapped-index"] = clicked_id;
    dict["event-name"] = eventName;
    
    webSocket.send(JSON.stringify(dict));
}
