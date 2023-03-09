import {Avatar, Button, Grid, Paper, TextField, Typography} from "@material-ui/core";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import {useState} from "react";
import axios from "axios";
import AuthService from "../auth/AuthService";
import HotelManager from "../HotelManager/HotelManager";
import { useNavigate } from "react-router-dom";
function LoginPage1() {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const [resMessage,setResMessage] = useState('');

    function handleSubmit() {
     let user = {username, password};

     AuthService.login(user)
         .then(
             () => {
                 console.log(JSON.parse(localStorage.getItem('user')));
                 navigate("../admin" );
                 window.location.reload(false);
                 setResMessage('')
             },
             error => {
                 setResMessage("Wrong username or password");


                 console.log(resMessage);
             });
 }
    return (

        <Grid>
            <Paper elevation={10} className={"p-20  w-2/12 m-auto mt-20"}>
                <Grid align={"center"}>

                    <Avatar><LockOutlinedIcon/></Avatar>
                    <Typography> Sing in </Typography>
                    {resMessage}

                        <TextField label={'Username'} name={'username'} placeholder={'Enter username'}
                                   onChange={(e) => setUsername(e.target.value)} fullWidth required/>
                        <TextField label={'Password'} name={'password'} placeholder={'Enter password'}
                                   onChange={(e) => setPassword(e.target.value)} fullWidth required/>
                        <Button  className={'btn btn-primary'} onClick={handleSubmit}> Login</Button>
                </Grid>
            </Paper>
        </Grid>
    )

}

 export default LoginPage1;