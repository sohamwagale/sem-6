<?php

$message = "";

if($_SERVER["REQUEST_METHOD"]=="POST"){
try {
	$balance = $_POST["balance"];
	$withdraw = $_POST["withdraw"];

	if($withdraw <0 || $balance < 0){
		throw new Exception("Amount cant be negative");
	}
	if($balance < $withdraw ){
		throw new Exception("Insuffuciant balance");
	}
	$remaining = $balance - $withdraw;
	$message = "Transaction succesfull! Remaining balance : Rs" . $remaining;
}
catch(Exception $e){
	$message = "Error".$e->getMessage();
}
finally {
	$message .= "<br>Thanks for using our banking system.";
}
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Bank Transaction System</title>
</head>
<body>

<h2>Bank Transaction</h2>

<?php
echo $message;
?>

<form method="POST">

    <br><br>

    Account Balance:
    <input type="number" name="balance">
    <br><br>

    Withdrawal Amount:
    <input type="number" name="withdraw">
    <br><br>

    <input type="submit" value="Withdraw">

</form>

</body>
</html>

