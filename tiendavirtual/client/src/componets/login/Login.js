import React, { useEffect, useState } from 'react';
import {useDispatch} from "react-redux";
import { Form, Button } from "react-bootstrap";
import {userLogin} from '../../actions/userActions.js'
import './Login.css'

function Login(){
    const dispatch = useDispatch();

    const [input, setInput] = useState({
        user: '',
        password: ''
    });
    //
    function handleInput(e) {
        setInput({
            ...input,
            [e.target.name]: e.target.value,
        });
    }
    //
    function handleSubmit(e) {
        e.preventDefault();
        
        dispatch(userLogin(input.user, input.password));
        setInput({
            user: '',
            password: ''
        });
        
    }
      //

    return(
        <>
            <h1>Bienvenidos a la Tienda Genérica</h1>
            <Form onSubmit={handleSubmit} className='login'>
                <div>

                <Form.Group className="mb-3">
                    <Form.Control
                        placeholder="Ingrese el usuario"
                        autoComplete='off'
                        type='text'
                        name='user'
                        value={input.user}
                        onChange={handleInput}
                    />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Control
                        placeholder="Ingrese la contraseña"
                        autoComplete='off'
                        type='password'
                        name='password'
                        value={input.password}
                        onChange={handleInput}
                    />
                </Form.Group>
                </div>
                <Button variant="dark" type="submit">
                    Confirmar
                </Button>
            </Form>
        </>

    )
}
export default Login;