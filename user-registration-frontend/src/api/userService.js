import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/users"; 

export const createUser = (user) => axios.post(API_BASE_URL, user);

export const getAllUsers = () => axios.get(API_BASE_URL);

export const updateUser = (id, user) => axios.put(`${API_BASE_URL}/${id}`, user);

export const deleteUser = (id) => axios.delete(`${API_BASE_URL}/${id}`);
