
export const TOKEN_KEY = "role";
export const isAuth = () => localStorage.getItem(TOKEN_KEY);
export const getToken = () => localStorage.setItem(TOKEN_KEY);

export const login = data => {
    // localStorage.setItem("id", data.id);
    localStorage.setItem("nome", data.paciente.nome);
    localStorage.setItem("role", data.role);
};
export const logout = () => {
    localStorage.removeItem("role");
};