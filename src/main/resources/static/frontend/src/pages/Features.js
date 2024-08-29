import React from "react";

function Features() {
    return (
        <>

            <div className="container">

                <div className="col-md-4">
                    <div className="card">

                        <div className="card-body">
                            <h5 className="card-title">Online Banking</h5>
                            <p className="card-text">Manage your accounts online, anytime, anywhere.</p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card">

                        <div className="card-body">
                            <h5 className="card-title">Secure Transactions</h5>
                            <p className="card-text">Enjoy secure and encrypted transactions for peace of mind.</p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card">

                        <div className="card-body">
                            <h5 className="card-title">Mobile Banking</h5>
                            <p className="card-text">Access your accounts on the go with our mobile banking app.</p>
                        </div>
                    </div>
                </div>

            </div>

        </>
    );
}
export default Features;
