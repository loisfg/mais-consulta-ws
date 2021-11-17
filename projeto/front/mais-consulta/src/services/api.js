import axios from "axios";

const api = (url) => {

    const maisConsulta = "http://localhost:8080/mais-consulta"
    // const maisConsulta = "http://9ea7-2804-420c-102d-1900-3dfd-fba6-31db-6902.ngrok.io/mais-consulta";
    const viacep = "http://viacep.com.br"

    if (url === "viacep") {
        url = viacep
    } else if (url === "maisconsulta") {
        url = maisConsulta
    }

    return axios.create({
        baseURL: url
    })
};

export default api;
