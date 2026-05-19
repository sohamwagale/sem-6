<?php 
$conn = mysqli_connect("localhost","phpuser","password123","student_db");

$message = "";

if(isset($_POST['submit'])){
    $name = $_POST["name"];
    $email = $_POST['email'];
    $mobile = $_POST['mobile'];
    $course = $_POST['course'];
    $gender = $_POST["gender"];

    if($name == "" || $email == "" || $mobile == "" || $course == "" || $gender == ""){
        $message = "All fields are required";
    }
    elseif (!filter_var($email,FILTER_VALIDATE_EMAIL)){
        $message = "Invalid email format !";
    }
    elseif(strlen($mobile) != 10){
        $message = "Invalid mobile number";
    }
    else {
        $sql = "INSERT INTO students(name,email,mobile,course,gender)
                VALUES('$name','$email','$mobile','$course','$gender')";

        if(mysqli_query($conn,$sql)){
            $message = "Student registered successfully !!";
        } else {
            $message = "Error saving data !";
        }
    }
}

if(isset($_POST['clear'])){
    $delete = "DELETE FROM students";

    if(mysqli_query($conn,$delete)){
        $message = "All student records deleted successfully !";
    } else {
        $message = "Error deleting records!";
    }
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h2>Student Registration Form</h2>

    <p><?php echo $message; ?></p>

    <form action="index.php" method="POST">

        Name: <input type="text" name="name">
        Email: <input type="email" name="email">
        Mobile: <input type="text" name="mobile">
        Course: <input type="text" name="course">
        Gender: 
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female
        <br><br>

        <input type="submit" name="submit" value="Register">

    </form>

    <h2>Registered Students</h2>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Course</th>
            <th>Gender</th>
        </tr>

        <?php

        $result = mysqli_query($conn,"SELECT * FROM students");
        while($row = mysqli_fetch_assoc($result)){
        ?>
        <tr>
            <td><?php echo $row['id']; ?></td>
            <td><?php echo $row['name']; ?></td>
            <td><?php echo $row['email']; ?></td>
            <td><?php echo $row['mobile']; ?></td>
            <td><?php echo $row['course']; ?></td>
            <td><?php echo $row['gender']; ?></td>
        </tr>

        <?php } ?>
    </table>

    <form action="" method="POST">
        <input type="submit" name="clear" value="Clear Database">
    </form>
</body>
</html>