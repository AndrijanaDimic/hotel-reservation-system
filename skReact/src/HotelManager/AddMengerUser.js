import {Avatar, Button, Grid, Paper, TextField, Typography} from "@material-ui/core";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import {useState} from "react";
import validator from 'validator';
import axios from "axios";
import {useNavigate} from "react-router-dom";

function AddMengerUser() {

    /**
     *
     private Date firstDayAtWork;
     private String username;
     private String password;
     private String firstName;
     private String lastName;
     private String email;
     private String phoneNumber;
     private Long managerId;
     */

    const [firstDayAtWork, setFirstDayAtWork] = useState(new Date());
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstNamed] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [emailError, setEmailError] = useState('')
    const navigate = useNavigate();

    const token = localStorage.getItem('user');

    function handleSubmit() {
        setFirstDayAtWork(new Date());
        setFirstDayAtWork(new Date());
        {
            //new Date('2022-01-12T16:43:14.472Z');
        }

        let user = {firstDayAtWork, username, password, firstName, lastName, email, phoneNumber};
        console.log(user);


        axios.post("http://localhost:8084/api/manager", user, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        }).then(res => {
            if (res.status === 201) {

                console.log()
                console.log(token)
                if (token === null || token.length < 2) {
                    navigate("/");
                    window.location.reload(false);

                } else {
                    navigate("/admin");
                    window.location.reload(false);
                }
            }

            console.log("true")


            //todo redirect to login

        }).catch(reason => {
            console.log(reason);

        }, []);
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
                    <Typography> Register Manager </Typography>

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

export default AddMengerUser;