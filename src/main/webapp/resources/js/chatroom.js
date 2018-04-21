//https://www.callicoder.com/spring-boot-websocket-chat-example/

var connectingElement = document.querySelector('.connecting');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var senderId = document.querySelector('#senderId');
var receiverId = document.querySelector('#receiverId');
var eventId = document.querySelector('#eventId');

var colors = [ '#2196F3', '#32c787', '#00BCD4', '#ff5652', '#ffc107',
		'#ff85af', '#FF9800', '#39bbb0' ];

function connectWebSocket() {
	var socket = new SockJS('/ws');
	stompClient = Stomp.over(socket);

	stompClient.connect({}, onConnected, onError);
}

function onConnected() {
	// Subscribe to the Public Topic
	stompClient.subscribe('/topic/public', onMessageReceived);

	connectingElement.classList.add('hidden');
}

function onError(error) {
	connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	connectingElement.style.color = 'red';
}

function sendMessage(event) {
	alert('envio mensaje');
	var messageContent = messageInput.value.trim();
	if (messageContent && stompClient) {
		alert('envio mensaje2');
		var chatMessage = {
			receiverId : receiverId.value,
			eventId : eventId.value,
			senderId: senderId.value,
			message : messageContent
		};
		stompClient.send("/chat.sendMessage", {}, JSON.stringify(chatMessage));
		messageInput.value = '';
	}
	event.preventDefault();
}

function onMessageReceived(payload) {
	var message = JSON.parse(payload.body);

	var messageElement = document.createElement('li');

	messageElement.classList.add('chat-message');

	var avatarElement = document.createElement('i');
	var avatarText = document.createTextNode(message.senderUsername);
	avatarElement.appendChild(avatarText);
	avatarElement.style['background-color'] = getAvatarColor(message.senderUsername);

	messageElement.appendChild(avatarElement);

	var usernameElement = document.createElement('span');
	var usernameText = document.createTextNode(message.senderUsername);
	usernameElement.appendChild(usernameText);
	messageElement.appendChild(usernameElement);

	var textElement = document.createElement('p');
	var messageText = document.createTextNode(message.message);
	textElement.appendChild(messageText);

	messageElement.appendChild(textElement);

	messageArea.appendChild(messageElement);
	messageArea.scrollTop = messageArea.scrollHeight;
}

function getAvatarColor(messageSender) {
	var hash = 0;
	for (var i = 0; i < messageSender.length; i++) {
		hash = 31 * hash + messageSender.charCodeAt(i);
	}
	var index = Math.abs(hash % colors.length);
	return colors[index];
}

messageForm.addEventListener('submit', sendMessage, true)

connectWebSocket();