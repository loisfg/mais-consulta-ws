
export const TOKEN_KEY = "@nada";
export const isAuth = () => localStorage.getItem(TOKEN_KEY);
export const getToken = () => localStorage.setItem(TOKEN_KEY);

export const login = token => {
    localStorage.setItem(TOKEN_KEY, token);
};
export const logout = () => {
    localStorage.removeItem(TOKEN_KEY);
};
// export const isAuth = () => false; 