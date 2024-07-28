import React, { useState, useEffect } from 'react';
import { getMessages, sendMessage } from './API/api';

const Chat = ({ senderId, receiverId }) => {
  const [messages, setMessages] = useState([]);
  const [content, setContent] = useState('');

  useEffect(() => {
    const fetchMessages = async () => {
      const response = await getMessages(senderId, receiverId);
      setMessages(response.data);
    };
    fetchMessages();
  }, [senderId, receiverId]);

  const handleSend = async () => {
    const message = { senderId, receiverId, content };
    await sendMessage(message);
    setContent('');
    const response = await getMessages(senderId, receiverId);
    setMessages(response.data);
  };

  return (
    <div>
      <div>
        {messages.map((message) => (
          <div key={message.id}>{message.content}</div>
        ))}
      </div>
      <input
        type="text"
        value={content}
        onChange={(e) => setContent(e.target.value)}
      />
      <button onClick={handleSend}>Send</button>
    </div>
  );
};

export default Chat;
