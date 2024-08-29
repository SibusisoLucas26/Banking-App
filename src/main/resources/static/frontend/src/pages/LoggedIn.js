import React, { useState } from 'react';
import PayBills from './PayBills';
import QuickTransfer from './QuickTransfer';
import ViewStatements from './ViewStatement';
const LoggedInComponent = ({ userInfo, setIsLoggedIn }) => {
    const [activeComponent, setActiveComponent] = useState(null);

    const renderComponent = () => {
        switch (activeComponent) {
            case 'transfer':
                return <QuickTransfer />;
            case 'payBills':
                return <PayBills />;
            case 'viewStatements':
                return <ViewStatements />;
            default:
                return <p>Select an action to perform.</p>;
        }
    };

    return (
        <div className="logged-in-ui">
            <header className="dashboard-header">
                <br></br>
                <h2>Welcome, {userInfo.username}!</h2>
                <button className="logout-button" onClick={() => setIsLoggedIn(false)}>Logout</button>
            </header>

            <div className="dashboard-overview">
                <h3>Account Overview</h3>
                <div className="account-summary">
                    <p><strong>Account Number:</strong> {userInfo.accountNumber}</p>
                    <p><strong>Balance:</strong> ${userInfo.balance}</p>
                </div>
            </div>

            <div className="quick-actions">
                <h3>Quick Actions</h3>
                <div className="action-buttons">
                    <button className="transfer-button" onClick={() => setActiveComponent('transfer')}>Quick Transfer</button>
                    <button className="pay-bills-button" onClick={() => setActiveComponent('payBills')}>Pay Bills</button>
                    <button className="view-statements-button" onClick={() => setActiveComponent('viewStatements')}>View Statements</button>
                </div>
            </div>

            <div className="action-component">
                {renderComponent()}
            </div>

            <div className="support-section">
                <h3>Need Help?</h3>
                <p>Contact our <a href="/support">Support Team</a> for assistance.</p>
            </div>
            <br></br>
        </div>
    );
};

export default LoggedInComponent;


