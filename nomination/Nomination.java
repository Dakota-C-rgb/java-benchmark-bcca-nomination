package nomination;

import java.io.Serializable;

public class Nomination implements Serializable {
    String nominatorName;
    String nominatorEmail;
    String affiliation;
    String position;
    String relationship;
    String nomineeName;
    Integer nomineeAge;
    String nomineeContactInfo;
    Integer gradDate;

    public Nomination(String nominatorName, String nominatorEmail, String affiliation, String position,
            String relationship, String nomineeName, Integer nomineeAge, String nomineeContactInfo, Integer gradDate) {
        this.nominatorName = nominatorName;
        this.nominatorEmail = nominatorEmail;
        this.affiliation = affiliation;
        this.position = position;
        this.relationship = relationship;
        this.nomineeName = nomineeName;
        this.nomineeAge = 0;
        this.nomineeContactInfo = nomineeContactInfo;
        this.gradDate = gradDate;
    }
}