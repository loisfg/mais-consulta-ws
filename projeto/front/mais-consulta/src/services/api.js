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
        baseURL: url
    })
};

export default api;
