import {Avatar, Button, Grid, Paper, TextField, Typography} from "@material-ui/core";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import {useState} from "react";
import validator from 'validator';
import axios from "axios";
import {useNavigate} from "react-router-dom";
function RegisterUser() {

    const [reservationCount, setReservationCount] = useState("");
    const [passportNumber, setPassportNumber] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstNamed] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [emailError, setEmailError] = useState('')
    const token =localStorage.getItem('user');
    const navigate = useNavigate();


    function handleSubmit() {
        let user = {reservationCount,passportNumber ,username, password,firstName,lastName,email,phoneNumber  };

        axios.post("http://localhost:8084/api/user",user,{
            headers: {
                'Authorization': `Bearer ${token}`
            }
        }).then(res => {

            if(res.status === 201){
                if (token === null || token.length < 2) {
                    navigate("/");
                    window.location.reload(false);

                } else {
                    navigate("/admin");
                    window.location.reload(false);
                }
            }



        }).catch(reason => {
            console.log(reason);

        },[]);
        
    };

    const validateEmail = (e) => {
        let email = e.target.value

        if (validator.isEmail(email)) {
            setEmailError('');
            setEmail(email)
        } else {
            setEmailError('Enter valid Email!')
        }
    }
    return (

        <Grid>
            <Paper elevation={10} className={"p-20  w-2/12 m-auto mt-20"}>
                <Grid align={"center"}>

                    <Avatar><LockOutlinedIcon/></Avatar>
                    <Typography> Register User </Typography>

                    <TextField label={'Reservation Count'} name={'reservationCount'}
                               placeholder={'Enter Reservation Count'}
                               onChange={(e) => setReservationCount(e.target.value)} fullWidth required/>
                    <TextField label={'Passport Number'} name={'passportNumber'} placeholder={'Enter Passport number'}
                               onChange={(e) => setPassportNumber(e.target.value)} fullWidth required/>
                    <TextField label={'Username'} name={'username'} placeholder={'Enter username'}
                               onChange={(e) => setUsername(e.target.value)} fullWidth required/>
                    <TextField label={'Password'} name={'password'} placeholder={'Enter password'}
                               onChange={(e) => setPassword(e.target.value)} fullWidth required/>
                    <TextField label={'First Name'} name={'firstName'} placeholder={'Enter first name'}
                               onChange={(e) => setFirstNamed(e.target.value)} fullWidth required/>
                    <TextField label={'Last Name'} name={'lastName'} placeholder={'Enter last name'}
                               onChange={(e) => setLastName(e.target.value)} fullWidth required/>
                    <TextField label={'Email'} name={'email'} placeholder={'Enter email'} type={"email"}
                               onChange={(e) => validateEmail(e)} fullWidth required/>
                    <span style={{
                        fontWeight: 'bold',
                        color: 'red',
                    }}>{emailError}</span>
                    <TextField label={'Phone Number'} name={'phoneNumber'} placeholder={'Enter phone number'}
                               onChange={(e) => setPhoneNumber(e.target.value)} fullWidth required/>

                    <Button className={'btn btn-primary'} onClick={handleSubmit}> Add</Button>


                </Grid>
            </Paper>
        </Grid>
    )

}

export default RegisterUser;