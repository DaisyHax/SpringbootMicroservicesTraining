<html>
    <body>
        <h1>BANK</h1>
        <form action="/bank/balance/accnum" method="GET">
            Please enter your Account Number : <input type="int" name="accnum"><br/>
            <button>Check Balance</button>
            <h2>Your Balance is ${balance}</h2>
        </form>
        <form action="/bank/balance/deposit" method="POST">
            Please enter your Account Number : <input type="int" name="accnum"><br/>
            Enter the amount to be deposited : <input type="int" name="amount"><br/>
            The transaction type is "DEPOSIT"<br/>
            <button>Deposit!</button>
            <h2>${Dmessage}</h2>
            <%--<h1>${message} Your new balance is : ${balance}</h1>--%>
        </form>
        <form action="/bank/balance/withdraw" method="POST">
            Please enter your Account Number : <input type="int" name="accnum"><br/>
            Enter the amount to be deposited : <input type="int" name="amount"><br/>
            The transaction type is "WITHDRAW"<br/>
            <button>WITHDRAW!</button>
            <h2>${Wmessage}</h2>
            <%--<h1>${message} Your new balance is : ${balance}</h1>--%>
        </form>
    </body>
</html>