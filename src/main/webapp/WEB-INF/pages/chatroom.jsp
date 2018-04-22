<%@ include file="../tiles/view/taglib.jsp"%>
<security:authentication var="user" property="principal" />
    <div id="chat-page" class="hidden">
        <div class="chat-container">
            <div class="chat-header">
                <h2>Spring WebSocket Chat Demo</h2>
            </div>
            <div class="connecting">
                Connecting...
            </div>
            <ul id="messageArea">

            </ul>
            <form id="messageForm" name="messageForm" >
                <div class="form-group">
                    <div class="input-group clearfix">
                    		<input type="hidden" id="receiverId" name="receiverId" value="${receiverId}" />
                    		<input type="hidden" id="eventId" name="eventId" value="${eventId}"/>
                    		<input type="hidden" id="senderId" name="senderId" value="${senderId}"/>
                    		<input type="hidden" id="chatroomId" name="chatroomId" value="${chatroomId}"/>
                    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                        <button type="submit" class="primary">Send</button>
                    </div>
                </div>
            </form>
        </div>
    </div>