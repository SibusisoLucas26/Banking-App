import React from 'react';

const ViewStatements = () => {
    const statements = [
        { date: '2024-08-01', description: 'Deposit', amount: 500.00 },
        { date: '2024-08-05', description: 'Withdrawal', amount: -200.00 },
        { date: '2024-08-10', description: 'Transfer', amount: -150.00 },
    ];

    return (
        <div className="view-statements modern-ui">
            <h3>Account Statements</h3>
            <table>
                <thead>
                    <tr>
                        <th>Date</th>
                        <th>Description</th>
                        <th>Amount</th>
                    </tr>
                </thead>
                <tbody>
                    {statements.map((statement, index) => (
                        <tr key={index}>
                            <td>{statement.date}</td>
                            <td>{statement.description}</td>
                            <td>{statement.amount < 0 ? `-$${Math.abs(statement.amount)}` : `$${statement.amount}`}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default ViewStatements;

