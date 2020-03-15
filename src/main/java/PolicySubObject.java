
class PolicySubObject {

  public PolicySubObject() {
  }

  public PolicySubObject(String subObjectName, double insuredSum, RiskType riskType) {
    this.subObjectName = subObjectName;
    this.insuredSum = insuredSum;
    this.riskType = riskType;
  }

  private String subObjectName;
  private double insuredSum;
  private RiskType riskType;

  public String getSubObjectName() {
    return subObjectName;
  }

  public void setSubObjectName(String subObjectName) {
    this.subObjectName = subObjectName;
  }

  public double getInsuredSum() {
    return insuredSum;
  }

  public void setInsuredSum(double insuredSum) {
    this.insuredSum = insuredSum;
  }

  public RiskType getRiskType() {
    return riskType;
  }

  public void setRiskType(RiskType riskType) {
    this.riskType = riskType;
  }
}
