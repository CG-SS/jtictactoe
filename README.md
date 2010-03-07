# JTicTacToe

TicTacToe build purely using Java, Swing and Ant.

Created as a first project for learning Java 6.

There are two modes, one is against the computer, the other against another player.

The computer logic can be found under `jtictactoe/logic`.

### Project structure

```
└───jtictactoe
    ├───gui
    │   ├───context
    │   └───panels
    ├───logic
    └───resources
```

Where:

- `jtictactoe`: main package
- `gui`: contains the logic and classes relating to the GUI.
- `context`: contains the context repository for the GUI.
- `panels`: contains all the views.
- `logic`: contains the logic for the computer opponent.
- `resources`: contains all the resources such as images.

### How to compile

Make sure you have a Java JDK that supports at least Java 6 and run:

```
javac -sourcepath -jar . jtictactoe/Jtictactoe.java
```

And then run with:

```
java -cp .
```
