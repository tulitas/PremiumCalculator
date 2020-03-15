public class PremiumCalculator {


    public static void main(String[] args) {
        calculate();
    }


    private static void calculate() {

        PolicyObject policyObject = new PolicyObject();
        policyObject.setObjectName("Flat");
        Policy policy = new Policy();
        policy.setPolicyNumber("LV19-07-100000-1");
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setSubObjectName("TV");
        PolicyStatus policyStatus = PolicyStatus.APPROVED;

        System.out.println("Policy Nr.: " + policy.getPolicyNumber());
        System.out.println("Policy object name: " + policyObject.getObjectName());
        System.out.println("Policy subobject name: " + policySubObject.getSubObjectName());
        System.out.println("Policy status: " + policyStatus);

    }

    double getFireCoefficient(Double sumInsuredFire) {
        if (sumInsuredFire > 100) {
            return 0.023;
        }
        return 0.013;
    }

    double getWaterCoefficient(Double sumInsuredFire) {
        if (sumInsuredFire >= 10) {
            return 0.05;
        }
        return 0.1;
    }
}