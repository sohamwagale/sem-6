<?php

$conn = mysqli_connect("localhost", "phpuser", "password123", "student_db");

$sql = "SELECT seminar_registrations.student_name,
		seminars.topic,
		seminars.speaker_name,
		seminars.seminar_date
	FROM seminar_registrations
	JOIN seminars
	ON seminars.id = seminar_registrations.seminar_id";
$result = mysqli_query($conn, $sql);

?>

<!DOCTYPE html>
<html>
<head>
    <title>Participant List</title>
</head>
<body>

<h2>Seminar Participants</h2>

<table border="1" cellpadding="10">

<tr>
    <th>Student Name</th>
    <th>Seminar Topic</th>
    <th>Speaker</th>
    <th>Date</th>
</tr>

<?php while($row = mysqli_fetch_assoc($result)) { ?>

<tr>
    <td><?php echo $row['student_name']; ?></td>
    <td><?php echo $row['topic']; ?></td>
    <td><?php echo $row['speaker_name']; ?></td>
    <td><?php echo $row['seminar_date']; ?></td>
</tr>

<?php } ?>

</table>

</body>
</html>
