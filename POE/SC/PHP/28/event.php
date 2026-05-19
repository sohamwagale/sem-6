<?php
$conn = mysqli_connect("localhost","phpuser","password123","student_db");

$msg = "";

if($_SERVER["REQUEST_METHOD"]=="POST"){
	$part = $_POST["parti"];
	$clg = $_POST["clg"];
	$event = $_POST["event"];
	$num = $_POST["num"];

	if($part == "" || $clg == "" || $event == "" || $num == ""){
		$msg = "All the fields are required";
	}else{
		$sql = "INSERT INTO events(participant,college,event,number)
			VALUES('$part','$clg','$event','$num')";
		if(mysqli_query($conn,$sql)){
			$msg = "Registered";
		}else{
			$msg = "Error occurred";
		}
	}
}

$count_res = mysqli_query($conn,"SELECT COUNT(*) AS total FROM events");
$count_row = mysqli_fetch_assoc($count_res);
$total = $count_row["total"];

?>

<!DOCTYPE html>
<html>
<head>
    <title>Event Registration</title>
</head>
<body>

<h2>Technical Event Registration</h2>

<p><?php echo $msg; ?></p>

<form method="POST">

    Participant Name:
    <input type="text" name="parti">
    <br><br>

    College Name:
    <input type="text" name="clg">
    <br><br>

    Event Name:
    <input type="text" name="event">
    <br><br>

    Contact Number:
    <input type="text" name="num">
    <br><br>

    <input type="submit" value="Register">

</form>

<hr>

<h3>Total Registered Participants: <?php echo $total; ?></h3>

</body>
</html>
