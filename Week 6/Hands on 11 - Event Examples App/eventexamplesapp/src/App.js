import React, { useState } from "react";

import CurrencyConvertor from "./components/CurrencyConvertor";

function App() {

    const [count, setCount] = useState(0);

    function increment() {

        setCount(count + 1);

    }

    function decrement() {

        setCount(count - 1);

    }

    function sayHello() {

        alert("Hello!! Member");

    }

    function increase() {

        increment();

        sayHello();

    }

    function sayWelcome(message) {

        alert(message);

    }

    function clickMe() {

        alert("I was clicked");

    }

    return (

        <div style={{ marginLeft: "40px" }}>

            <h2>{count}</h2>

            <button
                onClick={increase}
            >
                Increment
            </button>

            <br /><br />

            <button
                onClick={decrement}
            >
                Decrement
            </button>

            <br /><br />

            <button
                onClick={() =>
                    sayWelcome("Welcome")
                }
            >
                Say Welcome
            </button>

            <br /><br />

            <button
                onClick={clickMe}
            >
                Click on me
            </button>

            <br /><br />

            <CurrencyConvertor />

        </div>

    );

}

export default App;