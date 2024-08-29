import axios from 'axios';
import React, { useState } from 'react';

function AuthForms({ setIsLoggedIn, setUserInfo }) {  // Accept props from App
    const [showLoginForm, setShowLoginForm] = useState(false);
    const [showRegisterForm, setShowRegisterForm] = useState(false);
    const [loginData, setLoginData] = useState({ username: '', password: '' });
    const [registerData, setRegisterData] = useState({ username: '', firstname: '', lastname: '', password: '' });
    const [message, setMessage] = useState('');

    const toggleLoginForm = () => {
        setShowLoginForm(!showLoginForm);
        setShowRegisterForm(false);
        setMessage('');
    };

    const toggleRegisterForm = () => {
        setShowRegisterForm(!showRegisterForm);
        setShowLoginForm(false);
        setMessage('');
    };

    const handleLoginChange = (e) => {
        setLoginData({ ...loginData, [e.target.name]: e.target.value });
    };

    const handleRegisterChange = (e) => {
        setRegisterData({ ...registerData, [e.target.name]: e.target.value });
    };

    const handleLoginSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/login', loginData);
            setMessage('Login successful!');
            setIsLoggedIn(true);
            setUserInfo({
                username: loginData.username,
                balance: 1000.00,
                accountNumber: '1234567890',
            });
            console.log(response.data);
        } catch (error) {
            setMessage('Login failed. Please check your credentials.');
            console.error(error);
        }
    };

    const handleRegisterSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/register', registerData);
            setMessage('Registration successful!');
            console.log(response.data);
        } catch (error) {
            setMessage('Registration failed. Please try again.');
            console.error(error);
        }
    };

    return (
        <div className="auth-forms">
            <ul className="log-list">
                <li className="auth-item">
                    <button className="login-button" onClick={toggleLoginForm}>Login</button>
                    {showLoginForm && (
                        <div className="dropdown-form">
                            <h3>Login</h3>
                            <form onSubmit={handleLoginSubmit}>
                                <label>Username:</label>
                                <input type="text" name="username" value={loginData.username} onChange={handleLoginChange} placeholder="Enter your username" required />
                                <label>Password:</label>
                                <input type="password" name="password" value={loginData.password} onChange={handleLoginChange} placeholder="Enter your password" required />
                                <button type="submit">Submit</button>
                            </form>
                        </div>
                    )}
                </li>
                <li className="auth-item">
                    <button className="reg-button" onClick={toggleRegisterForm}>Register</button>
                    {showRegisterForm && (
                        <div className="dropdown-form">
                            <h3>Register</h3>
                            <form onSubmit={handleRegisterSubmit}>
                                <label>Username:</label>
                                <input type="text" name="username" value={registerData.username} onChange={handleRegisterChange} placeholder="Enter your username" required />
                                <label>Firstname:</label>
                                <input type="text" name="firstname" value={registerData.firstname} onChange={handleRegisterChange} placeholder="Enter your firstname" required />
                                <label>Lastname:</label>
                                <input type="text" name="lastname" value={registerData.lastname} onChange={handleRegisterChange} placeholder="Enter your lastname" required />
                                <label>Password:</label>
                                <input type="password" name="password" value={registerData.password} onChange={handleRegisterChange} placeholder="Enter your password" required />
                                <button type="submit">Submit</button>
                            </form>
                        </div>
                    )}
                </li>
            </ul>
            {message && <p>{message}</p>}
        </div>
    );
}

export default AuthForms;
