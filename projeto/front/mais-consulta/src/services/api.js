import axios from "axios";
import { getToken } from "./auth";

const api = axios.create({
    baseURL: "http://192.168.0.78:8080/mais-consulta"
});

export default api;