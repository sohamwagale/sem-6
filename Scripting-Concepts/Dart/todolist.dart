import 'dart:io';

void main() {
  List<String> tasks = [];

  while (true) {
    print("\n1. Add Task");
    print("2. View Tasks");
    print("3. Remove Task");
    print("4. Exit");

    stdout.write("Enter Choice: ");
    String? choice = stdin.readLineSync();

    if (choice == "1") {
      stdout.write("Enter task: ");
      String? task = stdin.readLineSync();
      tasks.add(task!);
      print("Task Added!");

    } else if (choice == "2") {
      print("Your Tasks: ");
      for (int i = 0; i < tasks.length; i++) {
        print("${i + 1}.${tasks[i]}");
      }

    } else if (choice == "3") {
      stdout.write("Enter task number to remove: ");
      int index = int.parse(stdin.readLineSync()!);
      tasks.removeAt(index - 1);
      print("Task Removed!");
      
    } else if (choice == "4") {
      print("Exiting...");
      break;
    } else {
      print("Invalid choice!");
    }
  }
}
