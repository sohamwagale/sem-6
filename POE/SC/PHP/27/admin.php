<?php

$conn = mysqli_connect("localhost","phpuser","password123","student_db");
$sql = "SELECT * FROM feedback";

$result = mysqli_query($conn,$sql);

?>

<html>
<body>

<table border="1" padding-top="10px">
	<tr>
		<th>Sr. N0</th>
		<th>Name</th>
		<th>Email</th>
		<th>Feedback</th>
		<th>Rating</th>
	</tr>

<?php

while($row = mysqli_fetch_assoc($result)){

?>

	<tr>
		<td><?php echo $row["id"] ?></td>
		<td><?php echo $row["name"] ?></td>
		<td><?php echo $row["email"] ?></td>
		<td><?php echo $row["message"] ?></td>
		<td><?php echo $row["rating"] ?></td>
	</tr>

<?php

}

?>

<a href="feedback.php">Feedback</a>

</table>
</body>
</html>
