import axios from "axios";

const API_URL = "http://localhost:8084/api";

class AuthService {


    login(user) {
        return axios
            .post(API_URL + "/user/login", user)
            .then(response => {

                if (response.data.token !== null && !response.data.token.isEmpty) {

                    localStorage.setItem("user", JSON.stringify(response.data.token.replaceAll("\"", "")));
                }
                const token = localStorage.getItem("user");
                const role = JSON.parse(window.atob(token.split(".")[1])).role;
                console.error('There was an aaaaaaa!', role);

                return response.data;
            })
            .catch(error => {
                return axios
                    .post(API_URL + "/manager/login", user)
                    .then(response => {

                        if (response.data.token !== null && !response.data.token.isEmpty) {

                            localStorage.setItem("user", JSON.stringify(response.data.token.replaceAll("\"","")));
                        }
                        const token = localStorage.getItem("user");
                        const role = JSON.parse(window.atob(token.split(".")[1])).role;
                        console.error('There was an aaaaaaa!', role);

                        return response.data;
                    })


            });
    }


}

export default new AuthService();