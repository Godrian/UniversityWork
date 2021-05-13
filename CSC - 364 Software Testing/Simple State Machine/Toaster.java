import java.util.Scanner;

//  S0 increase /       --> S6
//  S0 push     / on    --> S1
//  S0 defrost  /       --> S2
//  S1 time     / off   --> S0
//  S1 stop     / off   --> S0
//  S1 increase /       --> S7
//  S2 defrost  /       --> S0
//  S2 increase /       --> S4
//  S2 push     / on    --> S3
//  S3 increase /       --> S5
//  S3 stop     / off   --> S0
//  S3 time_d   /       --> S1
//  S4 decrease /       --> S2
//  S4 push     / on    --> S5
//  S4 defrost  /       --> S6
//  S5 time_d   /       --> S7
//  S5 stop     / off   --> S6
//  S5 decrease /       --> S3
//  S6 push     / on    --> S7
//  S6 decrease /       --> S0
//  S6 defrost  /       --> S4
//  S7 stop     / off   --> S6
//  S7 decrease /       --> S1
//  S7 time     / off   --> S6


public class Toaster
{

    public enum State
    {
        S0, S1, S2, S3, S4, S5, S6, S7
    }

    public static void main(String[] args)
    {

        // set initial state
        State currentState = State.S0;

        Scanner input = new Scanner(System.in);

        while (true)
        {
            // write current state on the screen
            // used only for debugging
            // System.out.println("the current state is " + currentState);

            // read input
            System.out.print("your input: ");
            String currentInput = input.nextLine();

            // take the transition
            switch (currentState)
            {
                case S0:
                    // three transition starts at S0
                    //  S0 increase /       --> S6
                    //  S0 push     / on    --> S1
                    //  S0 defrost  /       --> S2

                    // UML semantics: any input different from "increase", "push", "defrost"
                    // is to be ignored, i.e., we stay in state S0

                    switch (currentInput)
                    {
                        case "push":
                            System.out.println("Output: on");
                            currentState = State.S1;
                            break;
                        case "increase":
                            currentState = State.S6;
                            break;
                        case "defrost":
                            currentState = State.S2;
                            break;
                    }
                    break;

                case S1:
                    // three transition starts at S1
                    //  S1 time     / off   --> S0
                    //  S1 stop     / off   --> S0
                    //  S1 increase /       --> S7

                    // UML semantics: any input different from "time", "stop", "increase"
                    // is to be ignored, i.e., we stay in state S1

                    switch (currentInput)
                    {
                        case "time":
                        case "stop":
                            System.out.println("Output: off");
                            currentState = State.S0;
                            break;
                        case "increase":
                            currentState = State.S7;
                            break;
                    }
                    break;

                case S2:
                    // three transitions start at S2
                    //  S2 defrost  /       --> S0
                    //  S2 increase /       --> S4
                    //  S2 push     / on    --> S3

                    // UML semantics: any input different from  "defrost", "increase", "push"
                    // are to be ignored, i.e., we stay in state S2

                    switch (currentInput)
                    {
                        case "defrost":
                            currentState = State.S0;
                            break;
                        case "increase":
                            currentState = State.S4;
                            break;
                        case "push":
                            currentState = State.S3;
                            System.out.println("Output: on");
                            break;
                    }

                case S3:
                    // three transitions start at S3
                    //  S3 increase /       --> S5
                    //  S3 stop     / off   --> S0
                    //  S3 time_d   /       --> S1

                    // UML semantics: any input different from  "increase", "stop", "time_d"
                    // are to be ignored, i.e., we stay in state S3

                    switch (currentInput)
                    {
                        case "increase":
                            currentState = State.S5;
                            break;
                        case "stop":
                            System.out.println("Output: off");
                            currentState = State.S0;
                            break;
                        case "time_d":
                            currentState = State.S1;
                            break;
                    }
                    break;
                case S4:
                    // three transitions start at S4
                    //  S4 decrease /       --> S2
                    //  S4 push     / on    --> S5
                    //  S4 defrost  /       --> S6

                    // UML semantics: any input different from  "decrease", "push", "defrost"
                    // are to be ignored, i.e., we stay in state S4

                    switch (currentInput)
                    {
                        case "decrease":
                            currentState = State.S2;
                            break;
                        case "push":
                            System.out.println("Output: on");
                            currentState = State.S5;
                            break;
                        case "defrost":
                            currentState = State.S6;
                            break;
                    }
                    break;
                case S5:
                    // three transitions start at S5
                    //  S5 time_d   /       --> S7
                    //  S5 stop     / off   --> S6
                    //  S5 decrease /       --> S3

                    // UML semantics: any input different from  "decrease", "stop", "time_d"
                    // are to be ignored, i.e., we stay in state S5

                    switch (currentInput)
                    {
                        case "decrease":
                            currentState = State.S3;
                            break;
                        case "stop":
                            System.out.println("Output: off");
                            currentState = State.S6;
                            break;
                        case "time_d":
                            currentState = State.S7;
                            break;
                    }
                    break;
                case S6:
                    // three transitions start at S6
                    //  S6 push     / on    --> S7
                    //  S6 decrease /       --> S0
                    //  S6 defrost  /       --> S4

                    // UML semantics: any input different from  "push", "decrease", "defrost"
                    // are to be ignored, i.e., we stay in state S6

                    switch (currentInput)
                    {
                        case "decrease":
                            currentState = State.S0;
                            break;
                        case "push":
                            System.out.println("Output: on");
                            currentState = State.S7;
                            break;
                        case "defrost":
                            currentState = State.S4;
                            break;
                    }
                    break;
                case S7:
                    // three transitions start at S7
                    //  S7 stop     / off   --> S6
                    //  S7 decrease /       --> S1
                    //  S7 time     / off   --> S6

                    // UML semantics: any input different from  "decrease", "stop", "time"
                    // are to be ignored, i.e., we stay in state S7

                    switch (currentInput)
                    {
                        case "decrease":
                            currentState = State.S1;
                            break;
                        case "stop":
                        case "time":
                            System.out.println("Output: off");
                            currentState = State.S6;
                            break;
                    }
                    break;
            }
        }
    }
}