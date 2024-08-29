import React, { useState } from 'react';

const QuickTransfer = () => {
    // State for managing transfer data
    const [transferData, setTransferData] = useState({ amount: '', recipient: '' });

    // Handle form input changes
    const handleChange = (e) => {
        setTransferData({ ...transferData, [e.target.name]: e.target.value });
    };

    // Handle form submission
    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle transfer logic here
        console.log('Transfer data:', transferData);
    };

    return (
        <div className="quick-transfer modern-ui">
            <h3>Quick Transfer</h3>
            <form onSubmit={handleSubmit}>
                <label>Recipient Account:</label>
                <input
                    type="text"
                    name="recipient"
                    value={transferData.recipient}
                    onChange={handleChange}
                    placeholder="Enter recipient account number"
                    required
                />

                <label>Amount:</label>
                <input
                    type="number"
                    name="amount"
                    value={transferData.amount}
                    onChange={handleChange}
                    placeholder="Enter amount to transfer"
                    required
                />

                <button type="submit" className="submit-button">Transfer</button>
            </form>
        </div>
    );
};

export default QuickTransfer;

