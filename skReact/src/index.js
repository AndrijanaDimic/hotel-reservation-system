import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {render} from "@testing-library/react";
import LoginPage1 from "./login-register/LoginPage1";
import HotelManager from "./HotelManager/HotelManager";
import RegisterUser from "./login-register/RegisterUser";
import ClientPage from "./client/ClientPage";
import NavBar from "./Navbar/NavBar";
import AddMengerUser from "./HotelManager/AddMengerUser";
import AdminDashboardPage from "./admindeshbord/AdminDashboardPage";

const rootElement = document.getElementById("root");

render(

    <BrowserRouter>
        <NavBar/>
        <Routes>

            <Route exact path='/' element={<LoginPage1 />} />
            <Route path='/register-user' element={<RegisterUser />} />
            <Route path='/register-manager' element={<AddMengerUser />} />
            <Route  path='/user' element={<ClientPage />} />
            <Route  path='/hotel-manager' element={<HotelManager />} />
            <Route  path='/admin' element={<AdminDashboardPage />} />
        </Routes>
    </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
