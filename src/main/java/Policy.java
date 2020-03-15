import java.util.*;

public class Policy {

  public Policy() {
  }

  public Policy(String policyNumber, PolicyStatus policyStatus, List<PolicyObject> policyObjects,
      Double premium) {
    this.policyNumber = policyNumber;
    this.policyStatus = policyStatus;
    this.policyObjects = policyObjects;
    this.premium = premium;
  }

  private String policyNumber;
  private PolicyStatus policyStatus;
  private List<PolicyObject> policyObjects;
  private Double premium;

  public String getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(String policyNumber) {
    this.policyNumber = policyNumber;
  }

  public PolicyStatus getPolicyStatus() {
    return policyStatus;
  }

  public void setPolicyStatus(PolicyStatus policyStatus) {
    this.policyStatus = policyStatus;
  }

  public List<PolicyObject> getPolicyObjects() {
    return policyObjects;
  }

  public void setPolicyObjects(List<PolicyObject> policyObjects) {
    this.policyObjects = policyObjects;
  }

  public Double getPremium() {
    return premium;
  }

  public void setPremium(Double premium) {
    this.premium = premium;
  }
}
