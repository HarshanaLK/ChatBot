import axios from 'axios';

const API_URL = 'http://localhost:8080/api/chat';

export const registerUser = async (user) => {
  return axios.post(`${API_URL}/register`, user);
};

export const sendMessage = async (message) => {
  return axios.post(`${API_URL}/send`, message);
};

export const getMessages = async (senderId, receiverId) => {
  return axios.get(`${API_URL}/messages`, {
    params: { senderId, receiverId },
  });
};
