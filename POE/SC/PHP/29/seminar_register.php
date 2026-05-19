<?php

$conn = mysqli_connect("localhost","phpuser","password123","student_db");

$msg = "";

if($_SERVER["REQUEST_METHOD"] == "POST" ){
	$student = $_POST["student"];
	$seminar_id = $_POST["seminar_id"];

	if($seminar_id == "" || $student == ""){
		$msg = "All feilds are required!";
	}else {
		$sql = "INSERT INTO seminar_registrations(student_name,seminar_id)
			VALUES('$student','$seminar_id')";

		if(mysqli_query($conn,$sql)){
			$msg = "Registration succesfull";
		} else{
			$msg = "Error !!";
		}
	}
}

$seminars = mysqli_query($conn,"SELECT * FROM seminars");

?>

<!DOCTYPE html>
<html>
<head>
    <title>Seminar Registration</title>
</head>
<body>

<h2>Upcoming Seminars</h2>

<table border="1" cellpadding="10">

<tr>
    <th>Topic</th>
    <th>Speaker</th>
    <th>Date</th>
</tr>

<?php while($row = mysqli_fetch_assoc($seminars)) { ?>

<tr>
    <td><?php echo $row['topic']; ?></td>
    <td><?php echo $row['speaker_name']; ?></td>
    <td><?php echo $row['seminar_date']; ?></td>
</tr>

<?php } ?>

</table>

<hr>

<h2> register for seminar </h2>

<p><?php echo $msg; ?></p>

<form method="POST">

    Student Name:
    <input type="text" name="student">
    <br><br>

    Select Seminar:
    <select name="seminar_id">

        <option value="">Select</option>

        <?php
        $seminars = mysqli_query($conn,"SELECT * FROM seminars");
        while($s = mysqli_fetch_assoc($seminars)) {
        ?>

        <option value="<?php echo $s['id']; ?>">
            <?php echo $s['topic']; ?>
        </option>

        <?php } ?>

    </select>

    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>
