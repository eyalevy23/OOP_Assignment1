# GroupAdmin

GroupAdmin is a Java class that represents a group administrator and allows them to send updates to a group of members. The administrator can register and unregister members, and send updates by inserting, appending, deleting, or undoing changes to an UndoableStringBuilder object.
Installation

To use the GroupAdmin class, you will need to have the following dependencies installed:

    Java 11 or higher
    The java.util package

To install these dependencies, you can use a package manager like Maven or Gradle.
Usage

To use the GroupAdmin class, you will need to create an instance of it and register any members that you want to receive updates. You can then use the insert, append, delete, and undo methods to send updates to the group.

Here is an example of how to use the GroupAdmin class:

    GroupAdmin admin = new GroupAdmin();
    
    Member member1 = new Member("John");
    Member member2 = new Member("Jane");
    
    admin.register(member1);
    admin.register(member2);
    
    admin.insert(0, "Hello, world!");
    admin.append(" This is a test message.");
    admin.delete(5, 10);
    admin.undo();

Contributing

To contribute to the GroupAdmin project, please follow these guidelines:

Create a new branch for your changes
Make your changes and test them thoroughly
Submit a pull request with a clear description of your changes

# ConcreteMember

ConcreteMember is a Java class that represents a member in a group.
It implements the Member interface and can receive updates from a
group administrator by having its update method called.
The ConcreteMember class also has a unique ID and maintains a 
copy of the UndoableStringBuilder object that was last sent to it by 
the administrator.

Usage

To use the ConcreteMember class, you will need to create an instance of it and register it with a group administrator. The administrator will then send updates to the member by calling the update method with an UndoableStringBuilder object.

The ConcreteMember class also provides a PrintAfterUndo method that allows the member to print the contents of the UndoableStringBuilder object after undoing the last change. It also provides a getID method that returns the unique ID of the member, and a getUsb method that returns the current value of the UndoableStringBuilder object.

Here is an example of how to use the ConcreteMember class:

    GroupAdmin admin = new GroupAdmin();
    ConcreteMember member = new ConcreteMember();
    admin.register(member);
    
    admin.insert(0, "Hello, world!");
    admin.append(" This is a test message.");
    
    System.out.println(member.getUsb());
    member.PrintAfterUndo();
