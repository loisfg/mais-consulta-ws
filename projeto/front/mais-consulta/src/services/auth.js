
export const TOKEN_KEY = "token";
export const isAuth = () => {
    const id = localStorage.getItem('id');
    const nome = localStorage.getItem('nome');
    const role = localStorage.getItem('role')
    let data = {
        id: +id,
        nome,
        role
    }
    let validateToken = JSON.stringify(data).replaceAll('', '').replaceAll(':', '|');
    let token = localStorage.getItem(TOKEN_KEY);
    return validateToken === token 
}
export const getToken = () => localStorage.setItem(TOKEN_KEY);

export const login = data => {
    
    localStorage.setItem("id", data.id);
    localStorage.setItem("nome", data.nome);
    localStorage.setItem("role", data.role);
    const field = {
        id: data.id,
        nome: data.nome,
        role: data.role
    }
    let token = JSON.stringify(field).replaceAll('', '').replaceAll(':', '|');
    localStorage.setItem("token", token);
};
export const logout = () => {
    localStorage.removeItem("token");
};