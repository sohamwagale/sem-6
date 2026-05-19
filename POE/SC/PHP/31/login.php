<?php

$msg = "";


if($_SERVER["REQUEST_METHOD"]=="POST"){
	$username = $_POST["username"];
	$password = $_POST["password"];

	try{
		if($username == "" || $password== ""){
			throw new Exception("All the fields are required !!");
		}
		else{
			$correct_username = "sohamwagale@gmail.com";
			$correct_password = "soham123";

			if($username != $correct_username || $password != $correct_password){
				throw new Exception("Invalid Credentials");
			}
			else{
				header("Location: dashboard.php");
				exit();
				$msg = "Logged in";
			}
		}

	}
	catch(Exception $e){
		$msg = "Error is : {$e->getMessage()}";
	}
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Login System</title>
</head>
<body>

<h2>Login Form</h2>

<p><?php echo $msg; ?></p>

<form method="POST">

    Username:
    <input type="text" name="username">
    <br><br>

    Password:
    <input type="password" name="password">
    <br><br>

    <input type="submit" value="Login">

</form>

</body>
</html>


