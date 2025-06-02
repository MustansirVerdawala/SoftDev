# Circuit Builder (Java)

A console-based Java application that models a simple electronic circuit builder supporting resistors and voltage sources. Users can input components, and the system will validate and display them in SPICE-like format.

---

## 🧩 Features

- Add resistor (R) and voltage source (V) components by entering commands.
- Validates input parameters (node numbers, values).
- Automatically assigns unique IDs to each component.
- Checks and corrects voltage polarity.
- Displays all components in a SPICE-compatible format on command.
- Ends session with `end` command.

---


## 💻 Usage Instructions

- To add a resistor, enter:

    ```
    r <node1> <node2> <resistance_in_ohms>
    ```

- To add a voltage source, enter:

    ```
    v <node1> <node2> <voltage_in_volts>
    ```

- Example commands:

    ```
    r 1 2 1000
    v 2 0 5
    ```

- To display all components with corrected polarities, type:

    ```
    spice
    ```

- To exit the program, type:

    ```
    end
    ```

---

## ⚠️ Input Validation & Behavior

- Node numbers must be positive integers.
- Resistance values must be positive doubles.
- Voltage values can be positive or negative; polarity will be corrected automatically.
- Invalid inputs will be rejected with a message.

---


Made by a budding engineer who can’t resist throwing some static counters around.
