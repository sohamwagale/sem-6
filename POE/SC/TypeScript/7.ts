class Task{
  constructor(
    public task : string,
    public status : boolean
  ){}
}

class Todo{
  list : Task[] = [];

  addTask(task : string):void{
    this.list.push(new Task(task,true));
  }

  veiwTasks():void{
    this.list.forEach((entry,index)=>{
      console.log(`${index} : ${entry.task} , ${entry.status?"not completed":"completed"}`);
    })
  }

  markAsCompleted(name : string):void{
    this.list.forEach((entry)=>{
      if(entry.task == name){
        entry.status = false;
      }
    });
  }

  delete(name: string):void {
    this.list = this.list.filter((entry)=>{
      return entry.task != name
    })
  }

}

const todo = new Todo();

todo.addTask("Study TypeScript");
todo.addTask("Complete Assignment");
todo.addTask("Go to Gym");

todo.veiwTasks();

todo.markAsCompleted("Complete Assignment");

todo.veiwTasks();

todo.delete("Go to Gym");

todo.veiwTasks();

