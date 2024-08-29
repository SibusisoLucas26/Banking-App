import React, { useState } from 'react';

const PayBills = () => {
    const [billData, setBillData] = useState({ biller: '', amount: '' });
    const handleChange = (e) => setBillData({ ...billData, [e.target.name]: e.target.value });
    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle bill payment logic here
        console.log('Bill data:', billData);
    };

    return (
        <div className="pay-bills modern-ui">
            <h3>Pay Bills</h3>
            <form onSubmit={handleSubmit}>
                <label>Biller:</label>
                <input type="text" name="biller" value={billData.biller} onChange={handleChange} placeholder="Enter biller name" required />

                <label>Amount:</label>
                <input type="number" name="amount" value={billData.amount} onChange={handleChange} placeholder="Enter amount to pay" required />

                <button type="submit" className="submit-button">Pay Now</button>
            </form>
        </div>
    );
};

export default PayBills;

