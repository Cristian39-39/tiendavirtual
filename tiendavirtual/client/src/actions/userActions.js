import  axios  from 'axios';

import {USER_LOGIN} from '../constants/userConstants.js';

export const userLogin = (user='', password='') => async(dispatch)=>{
    console.log('llego a la action')
    dispatch({
        type: USER_LOGIN,
    });
    try{
        let response;
        const {data} = await axios.get(`/user/login?user=${user}&password=${password}`);
        console.log(response)
        response = data;
        console.log(response)
    }catch(error){
        console.log('algo salio mal')
    }
}