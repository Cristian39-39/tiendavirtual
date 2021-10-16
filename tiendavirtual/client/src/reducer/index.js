import { combineReducers } from "redux";
import {loginReducer} from './userReducer';

const rootReducer = combineReducers({
    userState: loginReducer
})

export default rootReducer