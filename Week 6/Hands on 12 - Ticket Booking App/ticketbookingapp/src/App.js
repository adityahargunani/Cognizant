import React, { useState } from "react";

import Greeting from "./components/Greeting";
import LoginButton from "./components/LoginButton";
import LogoutButton from "./components/LogoutButton";

function App() {

    const [isLoggedIn, setIsLoggedIn] = useState(false);

    function handleLogin() {

        setIsLoggedIn(true);

    }

    function handleLogout() {

        setIsLoggedIn(false);

    }

    let button;

    if (isLoggedIn) {

        button =

            <LogoutButton
                onClick={handleLogout}
            />;

    }

    else {

        button =

            <LoginButton
                onClick={handleLogin}
            />;

    }

    return (

        <div
            style={{
                marginLeft: "40px"
            }}
        >

            <Greeting
                isLoggedIn={isLoggedIn}
            />

            <br />

            {button}

        </div>

    );

}

export default App;