package nomination;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class NominationApp {
    final static String checkinsFilePath = "checkins.ser";
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Nomination> submissions = loadSubs();

        Nomination report = startSubmission();

        submissions.add(report);

        saveSubmissions(submissions);
    }

    private static void saveSubmissions(ArrayList<Nomination> report) {
        try {
            FileOutputStream fileStream = new FileOutputStream("orders.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(report);
            os.close();
        } catch (IOException ex) {
            System.out.println("Save Failed! :(");

        }
    }

    public static Nomination startSubmission() {
        System.out.print("Nominator Name: ");
        String nominatorName = input.nextLine();
        System.out.print("Email Address: ");
        String nominatorEmail = input.nextLine();
        System.out.println("What is your affiliation with the student: ");
        String affiliation = input.nextLine();
        System.out.println("What is your position: ");
        String position = input.nextLine();
        System.out.println("What is your relationship with the student: ");
        String relationship = input.nextLine();
        System.out.println("What is the student's name: ");
        String nomineeName = input.nextLine();
        System.out.println("Student contact info: ");
        String nomineeContactInfo = input.nextLine();
        System.out.println("How old is the student: ");
        Integer nomineeAge = input.nextInt();
        System.out.println("What year will the student Graduate: ");
        Integer gradDate = input.nextInt();

        return new Nomination(nominatorName, nominatorEmail, affiliation, position, relationship, nomineeName,
                nomineeAge, nomineeContactInfo, gradDate);
    }

    public static ArrayList<Nomination> loadSubs() {
        try {
            FileInputStream fileStream = new FileInputStream("orders.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Nomination> submissions = (ArrayList<Nomination>) os.readObject();
            os.close();
            return submissions;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Nomination>();
        }
    }
}