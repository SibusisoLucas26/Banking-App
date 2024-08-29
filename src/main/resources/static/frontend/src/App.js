import React, { useState } from 'react';
import Log from "./pages/AuthForms";
import Features from "./pages/Features";
import LoggedInComponent from "./pages/LoggedIn";
import Navbar from "./pages/Navbar";
import Panel from "./pages/Panel";

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Move state to App
  const [userInfo, setUserInfo] = useState(null); // Also move userInfo to App

  return (
    <>
      <Navbar />
      <br />
      {isLoggedIn ? (
        // Only render LoggedInComponent and Navbar when logged in
        <LoggedInComponent userInfo={userInfo} setIsLoggedIn={setIsLoggedIn} />
      ) : (
        <>
          <Panel />
          <br />
          <Log setIsLoggedIn={setIsLoggedIn} setUserInfo={setUserInfo} />
          <br />
          <Features />
        </>
      )}
    </>
  );
}

export default App;

