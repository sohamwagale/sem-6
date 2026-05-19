<?php

$conn = mysqli_connect("localhost","phpuser","password123","student_db");

$msg = "";

if($_SERVER["REQUEST_METHOD"]=="POST"){
	$topic = $_POST["topic"];
	$speaker = $_POST["speaker"];
	$date = $_POST["date"];

	if($topic == "" || $speaker == "" || $date == ""){
		$msg = "Alle fields are required!";
	} else {
		$sql = "INSERT INTO seminars(topic,speaker_name,seminar_date)
			VALUES('$topic','$speaker','$date')";

		if(mysqli_query($conn,$sql)){
			$msg = "Seminar added successfully!";
		}else{
			$msg = "Error!";
		}
	}
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Admin - Add Seminar</title>
</head>
<body>

<h2>Add Seminar</h2>

<p><?php echo $msg; ?></p>

<form method="POST">

    Topic:
    <input type="text" name="topic">
    <br><br>

    Speaker Name:
    <input type="text" name="speaker">
    <br><br>

    Seminar Date:
    <input type="date" name="date">
    <br><br>

    <input type="submit" value="Add Seminar">

</form>

</body>
</html>
