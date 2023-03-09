import {useEffect, useMemo, useState} from "react";
import axios from "axios";
import {
    Button,
    Grid, MenuItem,
    Paper,
    Select,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@material-ui/core";
import {CardTravel} from "@material-ui/icons";
let page = 0;
let maxPage = 0;
let perPage = 5;
let sort = 'ASC';

function HotelManager(factory, deps) {


    const [data, setData] = useState([]);
    const token =localStorage.getItem('user').replaceAll("\"","");

    useEffect(() => {
        resendRequst();
    },[]);

    function resendRequst() {
        axios.get(`http://localhost:8084/api/manager?page=${page}&size=${perPage}&sort=${sort}`, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        }).then(res => {
            setData(res.data.content);
            maxPage = res.data.totalPages-1;


        }).catch(reason => {
            console.log(reason);

        });

    }
    function setPage(type) {
        if (type === 1) {
            if (page !== 0)
                --page;
        } else {

            if(maxPage>page)

                page++;
        }
    }

    const handleChange = (event) => {
        perPage = event.target.value;
        resendRequst();
    };

    return (
        <div className={'container m-auto' }>
            <Grid>
                <Button onClick={() => {
                    setPage(1);
                    resendRequst();
                }}>Previous Page</Button>
                <Button onClick={() => {
                    setPage(2);
                    resendRequst();
                }}>Next Page</Button>
                <Select
                    labelId="demo-simple-select-label"
                    id="demo-simple-select"
                    defaultValue={5}
                    value={perPage}
                    label="Age"
                    onChange={handleChange}
                >
                    <MenuItem value={5}>5</MenuItem>
                    <MenuItem value={10}>10</MenuItem>
                    <MenuItem value={20}>20</MenuItem>
                    <MenuItem value={0}>All</MenuItem>
                </Select>
            </Grid>
            <TableContainer component={Paper}>
                <Table  aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="center">First Day at work</TableCell>
                            <TableCell align="center">Username</TableCell>
                            <TableCell align="center">Password</TableCell>
                            <TableCell align="center">First Name</TableCell>
                            <TableCell align="center">Last Name</TableCell>
                            <TableCell align="center">Email</TableCell>
                            <TableCell align="center">Phone number</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>


                                {/* loop over the books */}
                                {data.map((row, index) => (
                                    <TableRow
                                        key={row.name}
                                        sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                    >
                                        <TableCell align="center">{row.firstDayAtWork}</TableCell>
                                        <TableCell align="center">{row.username}</TableCell>
                                        <TableCell align="center">{row.password}</TableCell>
                                        <TableCell align="center">{row.firstName}</TableCell>
                                        <TableCell align="center">{row.lastName}</TableCell>
                                        <TableCell align="center">{row.email}</TableCell>
                                        <TableCell align="center">{row.phoneNumber}</TableCell>
                                    </TableRow>
                                ))}


                    </TableBody>
                </Table>
            </TableContainer>


        </div>
    )


}

export default HotelManager;