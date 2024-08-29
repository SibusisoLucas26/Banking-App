
// Navbar.js

import React from "react";

function Navbar() {

    return (
        <>
            <div className="navbar">
                <ul className="list">
                    <li className="nav-item">
                        <a className="nav-link" href="/home">Home</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/">Features</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/">About</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" href="/">Contact</a>
                    </li>



                </ul>
            </div>
        </>

    );


}

export default Navbar;
