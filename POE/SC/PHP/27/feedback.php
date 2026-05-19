<?php

$conn = mysqli_connect("localhost","phpuser","password123","student_db");

$msg = "";

if($_SERVER["REQUEST_METHOD"] == "POST") {
	$name = $_POST["name"];
	$email = $_POST["email"];
	$message = $_POST["message"];
	$rating = $_POST["rating"];

	if($name == "" || $email == "" || $message == "" || $rating == ""){
		$msg = "All fields must be filled";
	}else{
		$sql = "INSERT INTO feedback(name,email,message,rating)
			VALUES('$name','$email','$message','$rating')";
		if(mysqli_query($conn,$sql)){
			$msg = "Sent Successfully";
		}else {
			$msg = "Error saving feddback!!";
		}
	}
}

?>

<!DOCTYPE html>
<html>
<head>
	<title>Feedback form</title>
</head>
<body>


<p><?php echo $msg; ?></p>

<form method="POST">
	Name : <input type = "text" name="name">
	Email : <input type = "email" name="email">
	Feedback : <textarea type = "text" name= "message"></textarea>
	Rating : 
	<select name = "rating">
		<option value = "">SELECT</option>
		<option>1</option>
		<option>2</option>
		<option>3</option>
		<option>4</option>
		<option>5</option>
	</select>

	<input type="submit" value="Submit Feedback">
</form>

<br>
<br>
<br>
<a href="admin.php">Admin</a>
</body>
</html>
