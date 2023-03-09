import {AppBar, Box, Button, IconButton, Toolbar, Typography} from "@material-ui/core";
import {Link, useNavigate} from "react-router-dom";

export default function NavBar() {
    let token = '';
    const navigate = useNavigate();

    try {
        token = JSON.parse(window.atob(localStorage.getItem('user').split(".")[1])).role;
    } catch (e) {
        token = '';
    }

    return (
        <Box sx={{flexGrow: 1}}>
            <AppBar position="static">
                <Toolbar className={'px-32'}>
                    {token === 'ROLE_USER' || token === 'ROLE_ADMIN' ?

                        <Link to="/user">
                            <Typography variant="h7" className={'px-16'} component="div" sx={{flexGrow: 1}}>
                                All USERS
                            </Typography>
                        </Link> : ''}
                    <Link to="/register-user">
                        <Typography variant="h7" className={'px-16'} component="div" sx={{flexGrow: 1}}>
                            REGISTER USER
                        </Typography>
                    </Link>
                    <Link to="/register-manager">
                        <Typography variant="h7" className={'px-16'} component="div" sx={{flexGrow: 1}}>
                            REGISTER MANAGER USER
                        </Typography>
                    </Link>
                    {token === 'ROLE_USER' || token === 'ROLE_ADMIN' ?
                        <Link to="/hotel-manager">
                            <Typography variant="h7" component="div" className={'px-16'} sx={{flexGrow: 1}}>
                                HOTEL MANAGER
                            </Typography>
                        </Link>
                        : ""}
                    {token !== '' ?
                        <Link to="/admin">
                            <Typography variant="h7" component="div" className={'px-16'} sx={{flexGrow: 1}}>
                                ADMIN DASHBOARD
                            </Typography>
                        </Link>
                        : ""}
                    {token === ''  ?
                        <Link to="/">
                            <Typography variant="h7" component="div" sx={{flexGrow: 1}} className={'px-16'}>
                                LOGIN
                            </Typography>
                        </Link>
                        : ''}
                    {token !== '' ?

                        <Link to="/">

                            <Typography onClick={()=>{
                                localStorage.removeItem('user');
                                navigate("/" );

                                window.location.reload(false);
                            }} variant="h7" component="div" sx={{flexGrow: 1}} className={'px-16'}>
                                LOGOUT

                            </Typography>
                        </Link>
                        : ''}
                </Toolbar>
            </AppBar>
        </Box>
    );
}