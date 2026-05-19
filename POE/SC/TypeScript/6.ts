class Contact{
  constructor(
    public name: string,
    public phone: string,
  ){}
}

class ContactManager {
  private contacts: Contact[] = [];

  addContact(contact : Contact): void {
    this.contacts.push(contact);
    console.log("Contact added Successfully");
  }

  displayContacts():void {
    if(this.contacts.length == 0){
      console.log("No contacts available");
      return;
    }

    console.log("Contact List : ");
    this.contacts.forEach((contact :Contact,index) => {
      console.log(`
        ${index} . ${contact.name} Number: ${contact.phone} \n
      `)
    })
  }

  searchContact(name : string): void{
    const found = this.contacts.filter(contact =>
      contact.name.toLowerCase().includes(name.toLowerCase())
    );

    if (found.length > 0) {
      console.log("\nSearch Results:");
      found.forEach(contact => {
        console.log(
          `Name: ${contact.name}, Phone: ${contact.phone}`
        );
      });
    } else {
      console.log("Contact not found.");
    }
  }

  deleteContact(name : string) : void {

    const initialLength = this.contacts.length;

    const newContacts : Contact[] = this.contacts.filter( 
      contact => contact.name !== name
    )

    this.contacts = newContacts;

    if (this.contacts.length < initialLength) {
      console.log("Contact deleted successfully!");
    } else {
      console.log("Contact not found.");
    }
  }
}


const manager = new ContactManager();

// Adding Contacts
manager.addContact(new Contact("Soham", "9876543210"));
manager.addContact(new Contact("Rahul", "9123456780"));

// Display Contacts
manager.displayContacts();

// Search Contact
manager.searchContact("Soham");

// Delete Contact
manager.deleteContact("Rahul");

// Display Contacts After Deletion
manager.displayContacts();