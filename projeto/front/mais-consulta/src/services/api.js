import axios from "axios";

const api = (url) => {

    const maisConsulta = "http://localhost:8080/mais-consulta"
    const viacep = "http://viacep.com.br"

    if (url === "viacep") {
        url = viacep
    } else if (url === "maisconsulta") {
        url = maisConsulta
    }

    return axios.create({
        // baseURL: "https://06f7-2804-420c-104e-2d00-607a-e0d2-6d3-ab03.ngrok.io/mais-consulta"
        baseURL: url
    })
};

export default api;
