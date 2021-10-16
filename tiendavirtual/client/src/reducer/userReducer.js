import { USER_LOGIN } from "../constants/userConstants";

export function loginReducer(
    state={
        user:'',
        password:'',
        status:false
    },
    action
){
    switch(action.type){
        case USER_LOGIN:
            return{
                ...state,
                user: action.payload.user,
                password: action.payload.password,
                status: action.payload.status
            }
        default:
            return state
    }
}