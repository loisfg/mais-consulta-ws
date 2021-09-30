// import { render } from "@testing-library/react";
import React, { Component } from "react";
import Logo from "../../assets/logo.svg";
import { Form, Container } from "./styles";

class SignUp extends Component {
    constructor(props) {
        super(props)
        this.state = {
            nome: '',
            dtNascimento : '',
            numeroCartaoSus : '',
            cep : '',
            cidade : '',
            estado : '',
            bairro : '',
            logradouro : '',
            numero : '',
            complemento : '',
            cpf : '',
            email : '',
            password : '',
            telefone : '',
            error : '',
            sexo: [
                { id: 0, text: 'Selecione o sexo: '},
                { id: 1, text: 'M' },
                { id: 2, text: 'F' },
                { id: 3, text: 'Outros' }
            ],
            selectItem: 0
        };
        this.handleSelectItem = this.handleSelectItem.bind(this);
    };

    handleSelectItem(e) {
        this.setState({ selectItem: e.target.value });
    };


    handleSignUp = e => {
        e.preventDefault();
        alert("Bem vindo usuário");
    };

    render() {
        return (
            <Container>
                <Form onSubmit={this.handleSignUp}>
                    <img src={Logo} />
                    {this.state.error && <p> {this.state.error}</p>}
                </Form>
                <input type="text"
                    placeholder="Nome completo"
                    onChange={e => this.setState({ nome: e.target.value })} />
                <input type="password"
                    placeholder="CPF"
                    onChange={e => this.setState({ cpf: e.target.value })} />
                <input type="text"
                    placeholder="RG"
                    onChange={e => this.setState({ rg: e.target.value })} />
                <input type="text"
                    placeholder="RG"
                    onChange={e => this.setState({ rg: e.target.value })} />

            </Container>
        );
    };


};

export default SignUp;
