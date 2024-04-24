import axios from "axios";
import { BASE_API_URL } from "../common/constants";


const BASE_URL=BASE_API_URL +'/api/authentication'

class AuthenticationService{

    login(user){
        return axios.post(BASE_URL + '/sign-in',user)
    }

    register(user){
        return axios.post(BASE_URL + '/sign-up',user)
    }

}

export default new AuthenticationService();
