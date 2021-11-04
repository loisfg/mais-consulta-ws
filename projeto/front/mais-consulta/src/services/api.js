import axios from "axios";
import { getToken } from "./auth";

const api = axios.create({
    baseURL: "https://06f7-2804-420c-104e-2d00-607a-e0d2-6d3-ab03.ngrok.io/mais-consulta"
    // baseURL: "http://localhost:8080/mais-consulta"
    
});

export default api;
